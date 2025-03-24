package ru.pk.monsters.navigation

import kotlinx.serialization.Serializable

sealed class Screen{

    @Serializable
    data object Start: Screen()

    @Serializable
    data object List: Screen()

    @Serializable
    data object Details: Screen()
}