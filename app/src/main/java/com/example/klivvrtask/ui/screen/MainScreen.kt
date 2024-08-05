package com.example.klivvrtask.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.klivvrtask.ui.components.CustomSearchBar
import com.example.klivvrtask.ui.screen.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.klivvrtask.ui.components.CityItem

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
val state = viewModel.state
  val context = LocalContext.current
  LaunchedEffect(key1 = true) {
    viewModel.fetchFile(context)
  }
 Column(modifier = Modifier.fillMaxSize()){

   // Search Field
   CustomSearchBar(modifier = Modifier , onQueryChange =  {

     // Do Something on QueryChange

   })

 LazyColumn {
items(state.currentCities){
  CityItem(cityName = it.name, countryName =it.country ) {

  }
}
 }



   // Lazy List for Cities



 }







}
