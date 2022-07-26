package com.khimich.ukeess.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.khimich.ukeess.databinding.FragmentDetailsBinding
import com.khimich.ukeess.ui.base.BaseBindingFragment
import com.khimich.ukeess.utils.ModelsMappers.mapToDetailsModel
import com.khimich.ukeess.viewmodel.DetailsViewModel
import com.khimich.ukeess.viewmodel.PeopleViewModel

class DetailsFragment : BaseBindingFragment<FragmentDetailsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val peopleViewModel: PeopleViewModel by activityViewModels()
    private val detailsViewModel: DetailsViewModel by viewModels()

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val peopleId = args.id
        val people = peopleViewModel.getPeopleById(peopleId)
        if (people != null) {
            detailsViewModel.detailsModel = people.mapToDetailsModel()
            binding.model = detailsViewModel.detailsModel
        } else {
            Toast.makeText(requireContext(), "Person not found", Toast.LENGTH_LONG).show()
        }
    }
}