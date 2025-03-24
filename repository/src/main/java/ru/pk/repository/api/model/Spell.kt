package ru.pk.repository.api.model

data class Spell(
    val name: String?,
    val level: Int?,
    val url: String?,
    val usage: ru.pk.repository.api.model.Usage?
)
