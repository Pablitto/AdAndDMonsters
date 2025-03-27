package ru.pk.monsters.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.pk.monsters.R
import ru.pk.monsters.viewModel.MonsterDetailsViewModel

@Composable
fun MonsterDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MonsterDetailsViewModel,
) {

    val screenState by viewModel.screenState.collectAsState()


    Box(
        modifier = modifier.fillMaxSize()
    ) {

        AnimatedVisibility(
            visible = screenState.isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {

            Box(
                modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(40.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.bckg),
            contentDescription = "background",
            contentScale = ContentScale.Crop
        )

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .defaultMinSize(250.dp)
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(top = 64.dp, start = 32.dp, end = 32.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            AsyncImage(
                model = screenState.monster?.imageUrl
                    ?: "https://5e-bits.github.io/docs/api/2014/images/monsters/adult-black-dragon.png",
                contentDescription = "monster",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(4.dp, Color.Black)),
                contentScale = ContentScale.Crop
            )
        }
    }
}