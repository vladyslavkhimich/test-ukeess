package com.khimich.ukeess.models.binding

data class DetailsModel(
    val name: String,
    val imageUrl: String,
    val about: String,
    val genderModel: InfoModel,
    val birthDateModel: InfoModel,
    val birthPlaceModel: InfoModel,
    val deathDateModel: InfoModel,
    val deathPlaceModel: InfoModel,
)