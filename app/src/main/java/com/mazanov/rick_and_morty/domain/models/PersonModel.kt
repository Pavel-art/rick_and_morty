package com.mazanov.rick_and_morty.domain.modelsimport com.mazanov.rick_and_morty.data.dto.LocationDtoimport com.mazanov.rick_and_morty.data.dto.OriginDtodata class PersonModel(    val created: String,    val episode: List<String>,    val id: Int,    val image: String,    val location: Location,    val name: String,    val origin: Origin,    val species: String,    val status: String,    val url: String) {    companion object {        const val TOTAL_PAGES = 42    }}