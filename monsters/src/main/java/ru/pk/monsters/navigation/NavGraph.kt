package ru.pk.monsters.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pk.monsters.ui.screen.StartScreen
import ru.pk.core.ui.theme.MonstersTheme


@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
) {

   MonstersTheme {

        Surface {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.Start
            ) {

                composable<Screen.Start> {
                    StartScreen(modifier)
                }

            }
        }
    }
}