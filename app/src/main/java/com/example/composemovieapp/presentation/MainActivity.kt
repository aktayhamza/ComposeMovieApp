package com.example.composemovieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composemovieapp.presentation.moviedetail.views.MovieDetailScreen
import com.example.composemovieapp.presentation.movies.views.MovieScreen
import com.example.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.example.composemovieapp.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMovieAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route) {
                        composable(Screen.MovieScreen.route) {
                            MovieScreen(navController = navController)
                        }


                        composable(Screen.MovieDetailScreen.route + "/{${IMDB_ID}}") {
                        MovieDetailScreen()
                        }

                    }
                }
            }
        }
    }
}