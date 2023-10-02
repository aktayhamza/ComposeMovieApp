package com.example.composemovieapp.domain.model

import com.google.gson.annotations.SerializedName

data class MovieDetail (
    @SerializedName("Actors") val actors: String,
    @SerializedName("Awards") val awards: String,
    @SerializedName("Country") val country: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Genre") val genre: String,
    @SerializedName("Language") val language: String,
    @SerializedName("Poster") val poster: String,
    @SerializedName("Rated") val rated: String,
    @SerializedName("Released") val released: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Year") val year: String,
    val imdbRating: String,
)