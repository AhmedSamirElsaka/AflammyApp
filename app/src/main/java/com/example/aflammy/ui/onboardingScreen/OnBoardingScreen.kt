package com.example.aflammy.ui.onboardingScreen

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.aflammy.R
import com.example.aflammy.databinding.ActivityOnboardingScreenBinding
import com.example.aflammy.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingScreen : AppCompatActivity() {

    private lateinit var onboardingAdapter: OnboardingAdapter
    lateinit var binding: ActivityOnboardingScreenBinding
    val viewModel: OnBoardingViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (viewModel.getOnBoardingScreenState() == true) {
            startMainActivity()
        }

        initialize()
        makeStatusbarTransparent()
        initializeViewPager()
    }

    // Listener for next button press
    fun nextPage(view: View) {
        if (view.id == R.id.splash_next_button) {
            if (binding.onboardingViewPager.currentItem < onboardingAdapter.count - 1) {
                binding.onboardingViewPager.setCurrentItem(
                    binding.onboardingViewPager.currentItem + 1,
                    true
                )
            } else {
                viewModel.saveOnboardingScreenState(true)
                startMainActivity()
            }
        }
    }

    private fun makeStatusbarTransparent() {
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(baseContext, MainActivity::class.java))
        finish()
    }

    private fun initialize() {
        binding = ActivityOnboardingScreenBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.hide()
    }

    private fun initializeViewPager() {
        onboardingAdapter = OnboardingAdapter(this)
        binding.onboardingViewPager.adapter = onboardingAdapter
        binding.onboardingViewPager.setPageTransformer(false, OnboardingPageTransformer())
        binding.dotsIndicator.attachTo(binding.onboardingViewPager)
    }
}

