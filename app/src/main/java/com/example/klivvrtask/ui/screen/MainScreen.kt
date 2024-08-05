package com.example.klivvrtask.ui.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.klivvrtask.domain.model.Coord
import com.example.klivvrtask.ui.components.CityItem
import com.example.klivvrtask.ui.components.CustomSearchBar
import com.example.klivvrtask.ui.screen.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
  val state = viewModel.state
  val context = LocalContext.current




  Column(modifier = Modifier.fillMaxSize()) {

    CustomSearchBar(modifier = Modifier, onQueryChange = {

      viewModel.onEvent(MainScreenEvents.OnQueryChange(it))

    })
if(state.isLoaded) {
  LazyColumn {
    items(state.currentCities) {
      CityItem(
        cityName = it.name,
        countryName = it.country,
        longitude = it.coord.lon.toString(),
        latitude = it.coord.lat.toString()
      ) {
        launchMapIntent(context, it.coord, it.name)
      }
    }
  }

}else {
  CircularProgressIndicator(
    modifier = Modifier
      .padding(top = 200.dp)
      .width(64.dp)
      .align(CenterHorizontally),
    color = Color.Black,
  )
}


  }


}


fun launchMapIntent(context: Context, coordinate: Coord, countryName: String) {
  val gmmIntentUri = Uri.parse("geo:${coordinate.lat},${coordinate.lon}?q=${coordinate.lat},${coordinate.lon}(${Uri.encode(countryName)})")

  val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
    this.setPackage("com.google.android.apps.maps")

  }
  if (mapIntent.resolveActivity(context.packageManager) != null) {
    context.startActivity(mapIntent)
  } else {
    Toast.makeText(context, "No app available to handle Street View.", Toast.LENGTH_LONG).show()
  }

}
