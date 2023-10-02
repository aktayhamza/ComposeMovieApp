package com.example.composemovieapp.presentation.movies.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composemovieapp.presentation.Screen
import com.example.composemovieapp.presentation.movies.MoviesEvent
import com.example.composemovieapp.presentation.movies.MoviesViewModel
import com.example.composemovieapp.util.hideKeyboard

@Composable
fun MovieScreen(
    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            MovieSearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = "Search for movies...",
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                })

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies.size) {
                    MovieListRow(movie = state.movies[it], onItemClick = {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${it.imdbID}")
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    val context = LocalContext.current
    val view = LocalView.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 21.dp)
            .background(Color.Black, RoundedCornerShape(26.dp))
            .shadow(5.dp, CircleShape)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                isHintDisplayed = it.isEmpty()
            },
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
                context.hideKeyboard(view)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.White),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, CircleShape)
        )

        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )

            context.hideKeyboard(view)
        }
    }
}
