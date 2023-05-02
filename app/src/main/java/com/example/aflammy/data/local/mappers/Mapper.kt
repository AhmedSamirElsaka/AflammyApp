package com.example.aflammy.data.local.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}