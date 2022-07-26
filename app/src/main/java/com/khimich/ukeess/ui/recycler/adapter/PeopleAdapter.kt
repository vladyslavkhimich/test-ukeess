package com.khimich.ukeess.ui.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khimich.ukeess.R
import com.khimich.ukeess.databinding.ItemPeopleBinding
import com.khimich.ukeess.models.binding.PeopleItemModel
import com.khimich.ukeess.ui.recycler.diffutil.PeopleDiffUtilCallback
import com.khimich.ukeess.utils.ModelClickListener

class PeopleAdapter(
    private val itemClickListener: ModelClickListener<PeopleItemModel>
) : ListAdapter<PeopleItemModel, PeopleAdapter.PeopleViewHolder>(PeopleDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding: ItemPeopleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_people,
            parent,
            false
        )

        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class PeopleViewHolder(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(peopleItemModel: PeopleItemModel) {
            binding.model = peopleItemModel

            binding.root.setOnClickListener {
                itemClickListener.onItemClicked(peopleItemModel)
            }
        }
    }
}