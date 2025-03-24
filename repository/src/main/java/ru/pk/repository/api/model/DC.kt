package ru.pk.repository.api.model

data class DC(
    val dcType: ru.pk.repository.api.model.APIReference?,
    val dcValue: Int?,
    val successType: String?
)
