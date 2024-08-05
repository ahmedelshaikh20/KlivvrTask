package com.example.klivvrtask.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class City(
  val _id: Int,
  val coord: Coord,
  val country: String,
  val name: String
)
