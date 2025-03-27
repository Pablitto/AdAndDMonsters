package ru.pk.monsters.di

import dagger.Binds
import dagger.Module
import ru.pk.repository.di.RepositoryModule
import ru.pk.repository.interfaces.MonstersRepository

@Module (includes = [RepositoryModule::class])
class MonstersModule {

}