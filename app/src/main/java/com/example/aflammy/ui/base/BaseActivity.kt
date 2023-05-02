package com.example.aflammy.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.aflammy.BR

abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    protected abstract val activityLayoutId: Int

    private lateinit var _binding: VDB
    protected val binding: VDB
        get() = _binding

    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        _binding = DataBindingUtil.setContentView<VDB>(this, activityLayoutId).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, viewModel)
        }
    }
}