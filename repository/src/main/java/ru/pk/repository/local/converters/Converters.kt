package ru.pk.repository.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import ru.pk.repository.api.model.ArmorClass

class Converters {

    companion object {
        val gson = Gson()
    }

    @TypeConverter
    fun fromArmorClass(armorClass: ArmorClass): String = gson.toJson(armorClass)

    @TypeConverter
    fun toArmorClass(jsonString: String): ArmorClass =
        gson.fromJson(jsonString, ArmorClass::class.java)
}