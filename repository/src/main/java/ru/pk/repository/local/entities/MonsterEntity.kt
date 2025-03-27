package ru.pk.repository.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.pk.repository.api.model.ArmorClass
import ru.pk.repository.local.converters.Converters

@Entity(tableName = "monsters")
data class MonsterEntity (
    @PrimaryKey(autoGenerate = false) val index: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "size") val size: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "subtype") val subtype: String,
    @ColumnInfo(name = "alignment") val alignment: String,
    @ColumnInfo(name = "charisma") val charisma: Int,
    @ColumnInfo(name = "constitution") val constitution: Int,
    @ColumnInfo(name = "dexterity") val dexterity: Int,
    @ColumnInfo(name = "intelligence") val intelligence: Int,
    @ColumnInfo(name = "strength") val strength: Int,
    @ColumnInfo(name = "wisdom") val wisdom: Int,
    @ColumnInfo(name = "armor_class")
    val armorClass: ArmorClass
)
