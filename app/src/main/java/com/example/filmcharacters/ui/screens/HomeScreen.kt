package com.example.filmcharacters.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.filmcharacters.data.api.model.FilmCharacter
import com.example.viewmodel.HomeViewModel

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
  //  val homeViewModel: HomeViewModel = viewModel()
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }

        }
        items(state) { character ->
            CharacterImageCard(character)
        }

    }

}

@Composable
fun CharacterImageCard(character: FilmCharacter) {
    val imagerPainter = rememberImagePainter(data = character.image)

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Box {

            Image(
                painter = imagerPainter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )

            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Real name: ${character.actor}")
                    Text(text = "Actor name: ${character.name}")
                }
            }


        }


    }


}

/*
@Composable
fun HomeScreen() {

    val homeViewModel: HomeViewModel = viewModel()
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        items(state) { character ->
            CharacterImageCard(character)
        }
    }
}

@Composable
fun CharacterImageCard(character: FilmCharacter) {
    val imagePrinter = rememberImagePainter(data = character.image)
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box {
            Image(
                painter = imagePrinter,
                contentDescription = "character",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Surface(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = MaterialTheme.colors.onSurface.copy(0.3f),
                contentColor = MaterialTheme.colors.primary
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    Text(text = "Real name: ${character.actor}")
                    Text(text = "Actor Name:: ${character.name}")
                }
            }
        }
    }
}
*/

