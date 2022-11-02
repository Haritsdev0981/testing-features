package com.harets.testing_features.features.the_lazy_media.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.harets.testing_features.R
import com.harets.testing_features.databinding.ActivityLazyMediaBinding
import com.harets.testing_features.features.the_lazy_media.viewmodel.LazyViewModel

class LazyMediaActivity : AppCompatActivity() {

    private var _binding :ActivityLazyMediaBinding? = null
    private val binding get() = _binding as ActivityLazyMediaBinding

    private var _viewModel: LazyViewModel? = null
    private val viewModel get() = _viewModel as LazyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLazyMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _viewModel = ViewModelProvider(this)[LazyViewModel::class.java]
        viewModel.games()
        viewModel.lazyResponse.observe(this) {
            binding.rvSwpRefrhLazy.adapter = LazyGamesAdapter(it)
        }
    }
}