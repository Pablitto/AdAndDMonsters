package ru.pk.monsters.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pk.monsters.presentation.screen_state.MonsterDetailsScreenState
import ru.pk.repository.interfaces.MonstersRepository

class MonsterDetailsViewModel(
    private val repository: MonstersRepository,
    monsterIndex: String
) : ViewModel() {

    private val _screenState = MutableStateFlow(MonsterDetailsScreenState(false, null))
    val screenState: StateFlow<MonsterDetailsScreenState> = _screenState.asStateFlow()

    init {
        loadMonster(monsterIndex)
    }

    private fun loadMonster(index: String) {
        if (_screenState.value.isLoading || _screenState.value.monster != null) return
        _screenState.value = MonsterDetailsScreenState(true, null)
        Log.i("jopa", "loading monster details...")
        viewModelScope.launch(Dispatchers.Default) {
            repository.getMonsterInfo(index).also {
                _screenState.value = MonsterDetailsScreenState(false, it)
                Log.w("jopa", "monster loaded: ${it.name}, ${it.imageUrl}")
            }
        }
    }
}