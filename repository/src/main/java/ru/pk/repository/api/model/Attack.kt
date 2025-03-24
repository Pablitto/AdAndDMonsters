package ru.pk.repository.api.model

data class Attack(
    val name: String?,
    val dc: ru.pk.repository.api.model.DC?,
    val damage: ru.pk.repository.api.model.Damage?
)
