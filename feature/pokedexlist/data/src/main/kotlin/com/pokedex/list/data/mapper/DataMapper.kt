import com.pokedex.database.entity.PokedexEntity
import com.pokedex.list.domain.model.Pokedex
import com.pokedex.network.model.PokedexDTO
import com.pokedex.network.model.PokedexListResponse

fun PokedexListResponse.mapToDomain(): List<Pokedex>? {

    return results?.map {
        Pokedex(it.name, it.url)
    }
}

fun PokedexEntity.mapToDomain(): Pokedex {
    return Pokedex(name = name, imageUrl = url)
}

fun PokedexDTO.mapToEntity(): PokedexEntity {
    return PokedexEntity(
        name = name,
        url = url
    )
}