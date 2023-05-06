package com.example.aflammy.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aflammy.R
import com.example.aflammy.databinding.FragmentProfileBinding
import com.example.aflammy.ui.base.BaseFragment
import com.example.aflammy.utilities.Constants
import com.example.aflammy.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val fragmentLayoutId: Int = R.layout.fragment_profile
    override val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(true, getString(R.string.profile))

        collectLast(viewModel.profileUIEvent) {
            it.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: ProfileUIEvent) {
        val action = when (event) {
            ProfileUIEvent.DialogLogoutEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToLogoutDialog()
            }
            ProfileUIEvent.LoginEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToLoginFragment(Constants.PROFILE)
            }
            ProfileUIEvent.RatedMoviesEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToRatedMoviesFragment()
            }
            ProfileUIEvent.WatchHistoryEvent -> {
                ProfileFragmentDirections.actionProfileFragmentToWatchHistoryFragment()
            }
        }
        findNavController().navigate(action)
    }

}