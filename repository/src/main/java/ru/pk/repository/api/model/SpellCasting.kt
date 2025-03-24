package ru.pk.repository.api.model

data class SpellCasting(
    val ability: ru.pk.repository.api.model.APIReference?,
    val dc: ru.pk.repository.api.model.DC?,
    val modifier: Int?,
    val componentsRequired: List<String>,
    val school: String?,
//    val slots
    val spells: List<ru.pk.repository.api.model.Spell>?,
    val times: ru.pk.repository.api.model.Usage?
)
