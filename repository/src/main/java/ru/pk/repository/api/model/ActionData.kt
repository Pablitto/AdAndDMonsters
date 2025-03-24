package ru.pk.repository.api.model

data class ActionData(
    val name: String?,
    val desc: String?,
    val actionOptions: ru.pk.repository.api.model.Choice?,
    val actions: List<ru.pk.repository.api.model.Action>?,
    val options: ru.pk.repository.api.model.Choice?,
    val multiattackType: String?,
    val attackBonus: Int?,
    val dc: ru.pk.repository.api.model.DC?,
    val attacks: List<ru.pk.repository.api.model.Attack>?,
    val damage: List<ru.pk.repository.api.model.Damage>?,
)
