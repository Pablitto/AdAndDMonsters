package ru.pk.repository.api.model

data class ResponseMonsters(
    val count: Int,
    val results: ArrayList<ru.pk.repository.api.model.MonsterShort>
)
