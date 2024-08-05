package com.example.klivvrtask.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
  modifier: Modifier = Modifier,
  onQueryChange: (String) -> Unit
) {

  var query by remember {
    mutableStateOf("")
  }
  var isActive by remember {
    mutableStateOf(false)
  }
  SearchBar(
    modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 15.dp, horizontal = 15.dp)
        .clip(RoundedCornerShape(10.dp)),

    query = query,
    onQueryChange = { newQuery ->
      query = newQuery
      onQueryChange(newQuery)
    },
    onSearch = {

    },
    active = false,
    onActiveChange = { activeChange ->
      isActive = activeChange

    },
    shape = RoundedCornerShape(10.dp),
    colors = SearchBarDefaults.colors(),
    trailingIcon = {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "SearchIcon",
        tint = Color.Gray,
        modifier = Modifier.size(30.dp)
      )
    },
    placeholder = {
      Text(
        text = "Search",
        modifier = Modifier
            .fillMaxWidth()
            .size(30.dp),
        color = Color.Black
      )
    },
    tonalElevation = 0.dp


  ) {

  }
}


@Composable
fun CityItem(
  modifier: Modifier = Modifier,
  cityName: String,
  countryName: String,
  latitude: String,
  longitude: String,
  onClick: () -> Unit
) {



  Box(
    modifier = modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(20.dp))
        .padding(5.dp)
        .background(Color.Black)
        .clickable {
            onClick()
        }
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Row {

        Text(
          text = cityName,
          modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
          style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp
          )
        )
        Text(
          text = countryName,
          modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
          style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp
          )
        )
      }
      Row {
        Text(
          text = "Lat : $latitude",
          modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
          style = TextStyle(
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
          )
        )
        Text(
          text = "Lat : ${longitude}",
          modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
          style = TextStyle(
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
          )
        )
      }


    }
  }
}
//@Preview(showBackground = true)
//@Composable
//fun SearchBarPreview(){
//
////CityItem(cityName = "Cairo", countryName ="Egypt" ) {
//
//}
//
//}
