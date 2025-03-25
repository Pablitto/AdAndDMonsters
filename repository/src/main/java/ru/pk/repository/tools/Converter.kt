package ru.pk.repository.tools

import ru.pk.core.model.MonsterShort


fun monsterShort(from: ru.pk.repository.api.model.MonsterShort) = with(from) {
    MonsterShort(index, name, url)
}