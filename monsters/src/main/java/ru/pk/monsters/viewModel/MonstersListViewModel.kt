package ru.pk.monsters.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pk.monsters.presentation.screen_state.MonstersListScreenState
import ru.pk.repository.interfaces.MonstersRepository
import javax.inject.Inject

class MonstersListViewModel
@Inject constructor(private val repository: MonstersRepository) : ViewModel() {

    private val _screenState = MutableStateFlow(MonstersListScreenState(false, emptyList()))
    val screenState: StateFlow<MonstersListScreenState> = _screenState.asStateFlow()

    init {
        loadMonsters()
    }

    private fun loadMonsters() {
        if (_screenState.value.isLoading || _screenState.value.monsters.isNotEmpty()) return
        _screenState.value = MonstersListScreenState(true, emptyList())
        Log.i("jopa", "loading monsters...")
        viewModelScope.launch(Dispatchers.Default) {
            repository.getMonstersList().also {
                _screenState.value = MonstersListScreenState(false, it)
            }
        }
    }
}