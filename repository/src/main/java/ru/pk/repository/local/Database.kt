package ru.pk.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.pk.repository.local.converters.Converters
import ru.pk.repository.local.entities.MonsterEntity

@Database(
    entities = [
        MonsterEntity::class
    ], version = 1
)

@TypeConverters(Converters::class)
abstract class Database: RoomDatabase() {
}