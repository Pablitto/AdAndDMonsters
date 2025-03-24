package ru.pk.repository.api.model

data class Usage(
    val type: String?,
    val restTypes: List<String>,
    val times: Int?
)
