package ru.pk.repository.api.model

data class SpecialAbility(
    val name: String?,
    val desc: String?,
    val attackBonus: Int?,
    val damage: ru.pk.repository.api.model.Damage?,
    val dc: ru.pk.repository.api.model.DC?,
    val spellcasting: ru.pk.repository.api.model.SpellCasting?
)
