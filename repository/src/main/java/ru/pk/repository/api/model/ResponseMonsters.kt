import ru.pk.repository.api.model.MonsterShort


data class ResponseMonsters(
    val count: Int,
    val results: ArrayList<MonsterShort>
)
