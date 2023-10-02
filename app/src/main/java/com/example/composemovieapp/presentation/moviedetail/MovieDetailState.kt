package com.example.composemovieapp.presentation.moviedetail

import com.example.composemovieapp.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movieDetail: MovieDetail? = null,
    val error: String = ""
)
