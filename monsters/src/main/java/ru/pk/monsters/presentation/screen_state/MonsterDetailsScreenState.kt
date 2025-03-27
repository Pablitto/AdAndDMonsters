package ru.pk.monsters.presentation.screen_state

import ru.pk.core.model.MonsterFull

data class MonsterDetailsScreenState (
    val isLoading: Boolean,
    val monster: MonsterFull?
)