package ru.pk.repository

import ru.pk.core.model.MonsterShort
import ru.pk.repository.api.Api
import ru.pk.repository.interfaces.MonstersRepository
import ru.pk.repository.tools.monsterShort
import javax.inject.Inject

class MonstersRepositoryImpl
    @Inject constructor(val api: Api): MonstersRepository {

    override suspend fun getMonstersList(): List <MonsterShort> =
        api.getMonstersList().results.map { monsterShort(it) }

    override suspend fun getMonsterInfo(index: String): MonsterShort {
        TODO("Not yet implemented")
    }

}