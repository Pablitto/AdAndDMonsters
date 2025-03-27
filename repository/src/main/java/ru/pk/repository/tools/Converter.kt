package ru.pk.repository.tools

import ru.pk.core.model.MonsterFull
import ru.pk.core.model.MonsterShort
import ru.pk.repository.api.Api


fun monsterShort(from: ru.pk.repository.api.model.MonsterShort) = with(from) {
    MonsterShort(index, name, url)
}

fun monsterFull(from: ru.pk.repository.api.model.MonsterFull) = with(from) {
    MonsterFull(name ?: "", "${Api.BASE_URL}${image ?: ""}")
}