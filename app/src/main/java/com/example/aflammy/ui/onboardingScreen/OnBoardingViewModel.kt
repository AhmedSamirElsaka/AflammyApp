package com.example.aflammy.ui.onboardingScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aflammy.data.local.AppConfiguration
import com.example.aflammy.data.repository.OnBoardingRepository
import com.example.aflammy.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val onBoardingRepository: OnBoardingRepository,
) : BaseViewModel() {

    fun saveOnboardingScreenState(value:Boolean = false){
        viewModelScope.launch {
            onBoardingRepository.saveOnBoardingScreenState(value)
        }
    }
    fun getOnBoardingScreenState():Boolean?{
        var onBoardingState:Boolean? = false
         viewModelScope.launch{
             onBoardingState = onBoardingRepository.getOnBoardingScreenState()
        }
        return onBoardingState
    }

    override fun getData() {
    }
}