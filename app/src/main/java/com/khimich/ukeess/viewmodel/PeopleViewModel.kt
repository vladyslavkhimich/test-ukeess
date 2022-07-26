package com.khimich.ukeess.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khimich.ukeess.models.binding.PeopleItemModel
import com.khimich.ukeess.models.json.PeopleData
import com.khimich.ukeess.models.json.PeopleDataItem
import com.khimich.ukeess.repository.PeopleRepository
import com.khimich.ukeess.utils.ModelsMappers.mapToRecyclerModels
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val peopleRepository: PeopleRepository
) : ViewModel() {
    private val _people: MutableLiveData<PeopleData> = MutableLiveData()
    val people: LiveData<PeopleData> = _people
    private fun setPeople(people: PeopleData?) {
        if (people != null) {
            _people.postValue(people)
        } else {
            _people.postValue(PeopleData())
        }
    }

    init {
        fetchPeople()
    }

    private fun fetchPeople() {
        viewModelScope.launch {
            setPeople(peopleRepository.readJson())
        }
    }

    fun mapToPeopleItem() : List<PeopleItemModel> {
        return people.value?.mapToRecyclerModels() ?: emptyList()
    }

    fun getPeopleById(id: String) : PeopleDataItem? {
        return people.value?.find { it._id == id }
    }
}