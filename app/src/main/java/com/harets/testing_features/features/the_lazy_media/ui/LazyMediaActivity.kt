package com.harets.testing_features.features.the_lazy_media.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.harets.testing_features.R
import com.harets.testing_features.databinding.ActivityLazyMediaBinding
import com.harets.testing_features.features.the_lazy_media.remote.APIConfig
import com.harets.testing_features.features.the_lazy_media.response.LazyResponseItem
import com.harets.testing_features.features.the_lazy_media.viewmodel.LazyViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class LazyMediaActivity : AppCompatActivity() {

    private var _binding :ActivityLazyMediaBinding? = null
    private val binding get() = _binding as ActivityLazyMediaBinding

    private var _viewModel: LazyViewModel? = null
    private val viewModel get() = _viewModel as LazyViewModel

//    private val _lazyResponse = MutableLiveData<List<LazyResponseItem>>()
//    val lazyResponse: LiveData<List<LazyResponseItem>> = _lazyResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLazyMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _viewModel = ViewModelProvider(this)[LazyViewModel::class.java]
        viewModel.games()
        viewModel.lazyResponse.observe(this) {
            Log.i("LazyMediaActivity", "onCreate: $it")
            binding.rvLazyGames.adapter = LazyGamesAdapter(it)
        }
//        binding.apply {
//            refreshLayoutLazy.setOnRefreshListener {
//                fetchGames()
//            }
//        }
    }

//    private fun fetchGames() {
//        binding.refreshLayoutLazy.isRefreshing = true
//        APIConfig().getAPIService().getNews()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                binding.refreshLayoutLazy.isRefreshing = false
//                _lazyResponse.value = it
//            }, {
//                binding.refreshLayoutLazy.isRefreshing = false
//                Log.e("LazyViewModel", "$it")
//            })
//    }
}