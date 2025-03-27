package ru.pk.monsters.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pk.core.ui.theme.MonstersTheme
import ru.pk.monsters.presentation.screen.MonsterDetailsScreen
import ru.pk.monsters.presentation.screen.MonstersListScreen
import ru.pk.monsters.presentation.screen.StartScreen
import ru.pk.monsters.presentation.screen_state.MonsterDetailsScreenState
import ru.pk.monsters.viewModel.MonstersViewModelFactory


@Composable
fun MonstersNavGraph(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    viewModelFactory: MonstersViewModelFactory
) {

    MonstersTheme {

        Surface {

            val navController = rememberNavController()
            var selectedMonster = remember { "" }

            NavHost(
                navController = navController,
                startDestination = Screen.Start
            ) {

                composable<Screen.Start> {
                    StartScreen(
                        modifier
                    ) { navController.navigate(Screen.List) }
                }

                composable<Screen.List> {

                    val viewModel = remember { viewModelFactory.getMonstersListViewModel() }

                    MonstersListScreen(
                        modifier,
                        { index ->
                            selectedMonster = index
                            navController.navigate(Screen.Details)
                        },
                        viewModel
                    )
                }

                composable<Screen.Details> {

                    val viewModel = remember { viewModelFactory.getMonsterDetailsViewModel(selectedMonster) }

                    MonsterDetailsScreen(
                        modifier,
                        viewModel
                    )
                }
            }
        }
    }
}