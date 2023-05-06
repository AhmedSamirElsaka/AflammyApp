package com.example.aflammy.ui.youtubePlayer

import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import com.example.aflammy.BR
import com.example.aflammy.R
import com.example.aflammy.databinding.ActivityYoutubePlayerBinding
import com.example.aflammy.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class YoutubePlayerActivity : AppCompatActivity() {

    val viewModel: YoutubePlayerViewModel by viewModels()
    lateinit var binding: ActivityYoutubePlayerBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYoutubePlayerBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)
        fullScreen(window)
        supportActionBar?.hide()
    }


    private fun fullScreen(window: Window) {
        WindowInsetsControllerCompat(window, binding.youtubePlayer).apply {
            hide(WindowInsetsCompat.Type.systemBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}