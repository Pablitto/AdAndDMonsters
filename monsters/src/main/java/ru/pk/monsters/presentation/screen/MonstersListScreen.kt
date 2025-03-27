package ru.pk.monsters.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pk.core.ui.theme.AppColors
import ru.pk.core.ui.theme.MonstersTheme
import ru.pk.monsters.R
import ru.pk.monsters.viewModel.MonstersListViewModel


@Composable
fun MonstersListScreen(
    modifier: Modifier = Modifier,
    onMonsterSelected: (String) -> Unit = {},
    viewModel: MonstersListViewModel
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

        LazyColumn(
            modifier = Modifier.fillMaxSize()

        ) {
            items(screenState.monsters) { monster ->
                MonsterListItem(
                    name = monster.name ?: "Unknown",
                    index = monster.index,
                    onMonsterSelected
                    )
            }
        }
    }
}

@Composable
fun MonsterListItem(
    name: String,
    index: String,
    onMonsterSelected: (String) -> Unit,
    picUrl: String? = null
){
    Row (
        modifier = Modifier
            .padding(4.dp)
            .background(AppColors.ListItemBckg)
            .border(
                width = 2.dp,
                color = AppColors.ListItemBorder,
                shape = RoundedCornerShape(2.dp)
            )
            .clickable {
                onMonsterSelected(index)
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){

        Image(
            painter = painterResource(R.drawable.monsters),
            contentDescription = "monster",
            modifier = Modifier
                .size(80.dp)
                .border(BorderStroke(2.dp, Color.Black)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = name,
            Modifier
                .fillMaxWidth()
                .padding(4.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )

    }
}