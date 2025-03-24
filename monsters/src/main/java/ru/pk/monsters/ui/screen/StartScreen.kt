package ru.pk.monsters.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pk.monsters.R

@Preview
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {}
) {


    Box(
        modifier = modifier.fillMaxSize()
    ) {

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

            Image(
                painter = painterResource(R.drawable.monsters),
                contentDescription = "title image",
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(4.dp, Color.Black)),
                contentScale = ContentScale.Crop
            )

            Button(
                onClick = onButtonClick,
                modifier = Modifier
                    .defaultMinSize(250.dp)
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.secondary,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text(stringResource(R.string.button_inspect_monsters).uppercase())
            }
        }

    }
}