package com.example.aflammy.domain.mappers.series

import com.example.aflammy.BuildConfig
import com.example.aflammy.data.local.database.entity.series.AiringTodaySeriesEntity
import com.example.aflammy.domain.enums.MediaType
import com.example.aflammy.domain.models.Media
import com.example.aflammy.domain.mappers.Mapper
import javax.inject.Inject


class AiringTodaySeriesMapper @Inject constructor() : Mapper<AiringTodaySeriesEntity, Media> {
    override fun map(input: AiringTodaySeriesEntity): Media {
        return Media(
            mediaID = input.id,
            mediaName = input.name,
            mediaImage = BuildConfig.IMAGE_BASE_PATH + input.imageUrl,
            mediaRate = 0f,
            mediaDate = "",
            mediaType = MediaType.TV_SHOW.value,
        )
    }
}