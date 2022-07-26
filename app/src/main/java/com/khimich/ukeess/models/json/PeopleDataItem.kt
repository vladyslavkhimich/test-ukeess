package com.khimich.ukeess.models.json

data class PeopleDataItem(
    val _id: String,
    val about: String?,
    val birth: Birth?,
    val death: DeathX?,
    val gender: String?,
    val name: String?,
    val picture: String?
)