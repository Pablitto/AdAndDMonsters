package ru.pk.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.pk.repository.local.entities.MonsterEntity

@Dao
interface MonsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMonster(monsterEntity: MonsterEntity)

    @Query("SELECT * FROM monsters WHERE `index` LIKE :index")
    fun getMonster(index: String): MonsterEntity?
}