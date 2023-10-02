package com.example.composemovieapp.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Poster") val poster: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    val imdbID: String
)