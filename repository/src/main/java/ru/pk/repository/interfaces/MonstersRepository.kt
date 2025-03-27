package ru.pk.repository.interfaces

import ru.pk.core.model.MonsterFull
import ru.pk.core.model.MonsterShort


interface MonstersRepository {

    suspend fun getMonstersList(): List<MonsterShort>

    suspend fun getMonsterInfo(index: String): MonsterFull
}