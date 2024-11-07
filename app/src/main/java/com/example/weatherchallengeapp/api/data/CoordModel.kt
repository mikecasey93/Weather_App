package com.example.weatherchallengeapp.api.data


import com.google.gson.annotations.SerializedName

data class CoordModel(
    @SerializedName("lat")
    val lat: Double? = 0.0,
    @SerializedName("lon")
    val lon: Double? = 0.0
)