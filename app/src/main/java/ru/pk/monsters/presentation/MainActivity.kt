package ru.pk.monsters.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.pk.core.ui.theme.MonstersTheme
import ru.pk.monsters.MonstersApp
import ru.pk.repository.interfaces.MonstersRepository
import javax.inject.Inject

class MainActivity : ComponentActivity() {

//    lateinit var mainActivityComponent: MainActivityComponent
//        private set


    @Inject
    lateinit var repository: MonstersRepository

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MonstersApp).appComponent.inject(this)

        enableEdgeToEdge()

        setContent {
            MonstersTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("AD&D Monsters")
                            }
                        )
                    }) { innerPadding ->
                    ru.pk.monsters.navigation.NavGraph(
                        modifier = Modifier.padding(innerPadding),
                        isSystemInDarkTheme(),
                        {
                            MainScope().launch (Dispatchers.Default) {
                                Log.i("jopa", "click!")
                                repository.getMonstersList().also {
                                    it.forEach { monster ->
                                        Log.i("jopa", monster.name ?: "noname")
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}