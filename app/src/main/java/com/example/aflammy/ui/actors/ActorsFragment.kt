package com.example.aflammy.ui.actors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentActorsBinding
import com.example.aflammy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActorsFragment : BaseFragment<FragmentActorsBinding>() {
    override val fragmentLayoutId: Int = R.layout.fragment_actors
    override val viewModel:ActorsViewModel by viewModels()

    private val actorsAdapter by lazy { ActorsAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, resources.getString(R.string.actors))
        setAdapter()
        collectEvent()
    }

}