import ru.pk.repository.api.model.MonsterShort

interface MonstersRepository {

    fun getMonstersList(): List<ru.pk.repository.api.model.MonsterShort>

}