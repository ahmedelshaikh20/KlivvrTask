package com.example.klivvrtask.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)
