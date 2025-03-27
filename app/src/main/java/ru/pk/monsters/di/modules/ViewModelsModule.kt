package ru.pk.monsters.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.pk.monsters.di.ActivityScope
import ru.pk.monsters.presentation.view_model.MonstersListViewModel
import ru.pk.monsters.presentation.view_model.MonstersListViewModelImpl


@Module
object ViewModelsModule {

    @ActivityScope
    @Provides
    fun getMonstersListViewModel(
//        colorGenerator: ColorGenerator,
//        source: MutableSharedFlow<Event>
    ): MonstersListViewModel = MonstersListViewModelImpl()

//    @ActivityScope
//    @Provides
//    fun getReceiverViewModule(
//        source: MutableSharedFlow<Event>
//    ) = ViewModelReceiver(
//        source
//    )

}