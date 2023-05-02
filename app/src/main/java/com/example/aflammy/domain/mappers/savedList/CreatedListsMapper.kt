package com.example.aflammy.domain.mappers.savedList

import com.example.aflammy.data.remote.response.CreatedListDto
import com.example.aflammy.domain.models.CreatedList
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject

class CreatedListsMapper @Inject constructor() : Mapper<CreatedListDto, CreatedList> {
    override fun map(input: CreatedListDto): CreatedList {
        return CreatedList(
            id = input.id ?: 0,
            name = input.name ?: "unknown",
            itemCount = input.itemCount ?: 0,)
    }
}