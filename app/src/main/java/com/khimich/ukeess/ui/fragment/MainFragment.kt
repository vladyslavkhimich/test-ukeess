package com.khimich.ukeess.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.khimich.ukeess.databinding.FragmentMainBinding
import com.khimich.ukeess.models.binding.PeopleItemModel
import com.khimich.ukeess.ui.base.BaseBindingFragment
import com.khimich.ukeess.ui.recycler.adapter.PeopleAdapter
import com.khimich.ukeess.utils.ModelClickListener
import com.khimich.ukeess.viewmodel.PeopleViewModel

class MainFragment : BaseBindingFragment<FragmentMainBinding>() {
    private val peopleViewModel: PeopleViewModel by activityViewModels()
    private lateinit var peopleAdapter: PeopleAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initListeners()
    }

    private fun initUi() {
        peopleAdapter = PeopleAdapter(onItemClickListener)
        with(binding.peopleRecycler) {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            val dividerItemDecoration = DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun initListeners() {
        peopleViewModel.people.observe(viewLifecycleOwner) {
            peopleAdapter.submitList(peopleViewModel.mapToPeopleItem())
        }
    }

    private val onItemClickListener = object: ModelClickListener<PeopleItemModel> {
        override fun onItemClicked(model: PeopleItemModel) {
            navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(model.id))
        }

    }
}