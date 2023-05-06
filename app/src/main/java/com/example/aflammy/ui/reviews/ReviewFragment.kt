package com.example.aflammy.ui.reviews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentReviewBinding
import com.example.aflammy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ReviewFragment : BaseFragment<FragmentReviewBinding>() {
    override val fragmentLayoutId: Int = R.layout.fragment_review
    override val viewModel: ReviewViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.review))
        binding.commentReviewAdapter.adapter = ReviewAdapter(emptyList(), viewModel)
    }

}