package com.khimich.ukeess.utils

import com.khimich.ukeess.models.binding.DetailsModel
import com.khimich.ukeess.models.binding.InfoModel
import com.khimich.ukeess.models.binding.PeopleItemModel
import com.khimich.ukeess.models.json.PeopleData
import com.khimich.ukeess.models.json.PeopleDataItem
import java.util.*

object ModelsMappers {
    fun PeopleData.mapToRecyclerModels() : List<PeopleItemModel> {
        val resultList = LinkedList<PeopleItemModel>()
        this.forEach {
            peopleDataItem ->
            resultList.add(
                PeopleItemModel(
                    peopleDataItem._id,
                    peopleDataItem.picture ?: "",
                    peopleDataItem.name ?: "No name",
                    peopleDataItem.gender ?: "Unknown gender",
                    peopleDataItem.birth?.date ?: "No date"
                )
            )
        }
        return resultList
    }

    fun PeopleDataItem.mapToDetailsModel() : DetailsModel {
        return DetailsModel(
            this.name ?: "No name",
                this.picture ?: "",
            this.about ?: "",
            genderModel = InfoModel("Gender", this.gender ?: "Unknown"),
            birthDateModel = InfoModel("Birth date", this.birth?.date ?: "No birth date"),
            birthPlaceModel = InfoModel("Birth place", this.birth?.location?.name ?: "No location data"),
            deathDateModel = InfoModel("Death date", this.death?.date ?: "No death date"),
            deathPlaceModel = InfoModel("Death place", this.death?.location?.name ?: "No death place")
        )
    }
}