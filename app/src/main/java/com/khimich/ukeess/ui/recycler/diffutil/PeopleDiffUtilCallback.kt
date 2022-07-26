package com.khimich.ukeess.ui.recycler.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.khimich.ukeess.models.binding.PeopleItemModel

class PeopleDiffUtilCallback : DiffUtil.ItemCallback<PeopleItemModel>() {
    override fun areItemsTheSame(oldItem: PeopleItemModel, newItem: PeopleItemModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PeopleItemModel, newItem: PeopleItemModel): Boolean {
        return oldItem == newItem
    }
}