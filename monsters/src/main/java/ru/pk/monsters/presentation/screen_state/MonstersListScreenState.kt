package ru.pk.monsters.presentation.screen_state

import ru.pk.core.model.MonsterShort

data class MonstersListScreenState (
    val isLoading: Boolean,
    val monsters: List<MonsterShort>
)