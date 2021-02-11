package com.androiddevs.shoppinglisttestingyt.ui

import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.androiddevs.shoppinglisttestingyt.R
import com.androiddevs.shoppinglisttestingyt.adpters.ImageAdapter
import com.androiddevs.shoppinglisttestingyt.other.Constants.GRID_SPAN_COUNT
import kotlinx.android.synthetic.main.fragment_image_pick.*
import javax.inject.Inject

class ImagePickFragment @Inject constructor(
     val imageAdapter: ImageAdapter
): Fragment(R.layout.fragment_image_pick) {

    lateinit var viewModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        setupRecyclerView()

        imageAdapter.setOnItemClickListener {
            findNavController().popBackStack()
            viewModel.setCurImageUrl(it)
        }
    }

    private fun setupRecyclerView(){
        rvImages.apply {
            adapter = imageAdapter
            layoutManager = GridLayoutManager(requireContext(),GRID_SPAN_COUNT)
        }
    }
}