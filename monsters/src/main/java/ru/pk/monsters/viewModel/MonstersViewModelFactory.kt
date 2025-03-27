package ru.pk.monsters.viewModel

import ru.pk.repository.interfaces.MonstersRepository
import javax.inject.Inject

class MonstersViewModelFactory
 @Inject constructor(private val repository: MonstersRepository){

    fun getMonstersListViewModel() = MonstersListViewModel(repository)

    fun getMonsterDetailsViewModel(monsterIndex: String) = MonsterDetailsViewModel(repository, monsterIndex)
}