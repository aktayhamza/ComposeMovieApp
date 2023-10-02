package com.example.composemovieapp.data.repository

import com.example.composemovieapp.domain.repository.MovieRepository
import com.example.composemovieapp.remote.MovieAPI
import com.example.composemovieapp.remote.dto.MovieDetailDto
import com.example.composemovieapp.remote.dto.MoviesDto
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieAPI) : MovieRepository {

    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetail(imdbId = imdbId)
    }
}