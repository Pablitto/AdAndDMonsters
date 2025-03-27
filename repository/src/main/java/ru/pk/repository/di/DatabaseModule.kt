package ru.pk.repository.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import ru.pk.repository.local.Database
import javax.inject.Named
import javax.inject.Singleton

@Module
object DatabaseModule {

//    @Provides
//    @Singleton
//    fun getRoomDatabase(@Named("AppContext") context: Context): RoomDatabase =
//        Room.databaseBuilder(context, Database::class.java, "monsters_db")
//            .fallbackToDestructiveMigration().build()
}