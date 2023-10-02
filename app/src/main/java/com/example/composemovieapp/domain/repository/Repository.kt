package com.example.composemovieapp.domain.repository

import com.example.composemovieapp.remote.dto.MovieDetailDto
import com.example.composemovieapp.remote.dto.MoviesDto

interface MovieRepository {
    suspend fun getMovies(search: String): MoviesDto
    suspend fun getMovieDetail(imdbId: String): MovieDetailDto
}