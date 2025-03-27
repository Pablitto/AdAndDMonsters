package ru.pk.repository

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.pk.core.model.MonsterFull
import ru.pk.core.model.MonsterShort
import ru.pk.repository.api.Api
import ru.pk.repository.interfaces.MonstersRepository
import ru.pk.repository.local.Database
import ru.pk.repository.local.LocalDataWrapper
import ru.pk.repository.tools.monsterFull
import ru.pk.repository.tools.monsterShort
import javax.inject.Inject
import javax.inject.Named

class MonstersRepositoryImpl
@Inject constructor(
    val api: Api,
    @Named("AppContext") context: Context,
        val roomDatabase: RoomDatabase,
        val local: LocalDataWrapper
) : MonstersRepository {

//    private val roomDatabase = Room.databaseBuilder(context, Database::class.java, "monsters_db")
//        .fallbackToDestructiveMigration().build()
//
//    val localDataWrapper = LocalDataWrapper(roomDatabase)

    override suspend fun getMonstersList(): List<MonsterShort> =
        api.getMonstersList().results.map { monsterShort(it) }

    override suspend fun getMonsterInfo(index: String): MonsterFull {

        return monsterFull(api.getMonster(index))
    }
}