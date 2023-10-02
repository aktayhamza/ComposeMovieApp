package com.example.composemovieapp.remote.dto

import com.example.composemovieapp.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("Response") val response: String,
    @SerializedName("Search") val search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovieList() :List<Movie> {
    return search.map { search -> Movie(search.Poster,search.Title,search.Year,search.imdbID) }
}