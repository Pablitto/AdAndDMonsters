package ru.pk.repository.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pk.repository.MonstersRepositoryImpl
import ru.pk.repository.interfaces.MonstersRepository
import ru.pk.repository.local.Database
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideRepository(api: Api): MonstersRepository =
//        MonstersRepositoryImpl(api)

    @Singleton
    @Binds
    abstract fun bindRepository(repo: MonstersRepositoryImpl): MonstersRepository
}