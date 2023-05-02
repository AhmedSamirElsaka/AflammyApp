package com.example.aflammy.domain.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}