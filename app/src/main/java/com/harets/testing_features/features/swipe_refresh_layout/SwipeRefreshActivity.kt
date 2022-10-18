package com.harets.testing_features.features.swipe_refresh_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.harets.testing_features.R
import com.harets.testing_features.databinding.ActivitySwipeRefreshBinding
import com.harets.testing_features.features.swipe_refresh_layout.data.SurahApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SwipeRefreshActivity : AppCompatActivity() {

    private var _binding: ActivitySwipeRefreshBinding? = null
    private val binding get() = _binding as ActivitySwipeRefreshBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySwipeRefreshBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            refreshLayout.setOnRefreshListener {
                fetchSurah()
            }
        }

        fetchSurah()
    }

    private fun fetchSurah() {
        binding.refreshLayout.isRefreshing = true
        SurahApi().getSurah().enqueue(object : Callback<List<DataItem>> {
            override fun onFailure(call: Call<List<DataItem>>, t: Throwable) {
                binding.refreshLayout.isRefreshing = false
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<DataItem>>,
                response: Response<List<DataItem>>
            ) {
                binding.refreshLayout.isRefreshing = false
                val surah = response.body()

                surah?.let { showSurah(it) }
            }

        })
    }

    private fun showSurah(surah: List<DataItem>) {
        binding.apply {
            rvSwpRefrh.layoutManager = LinearLayoutManager(this@SwipeRefreshActivity)
            rvSwpRefrh.adapter = SurahAdapter(surah)
        }
    }
}