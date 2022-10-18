package com.harets.testing_features.features

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.harets.testing_features.databinding.ActivityShimmerBinding

class ShimmerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShimmerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShimmerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            dataView.visibility = View.INVISIBLE
            shimmerView.startShimmerAnimation()

            val handler = Handler()
            handler.postDelayed({
                dataView.setVisibility(View.VISIBLE)
                shimmerView.stopShimmerAnimation()
                shimmerView.setVisibility(View.INVISIBLE)
            }, 5000)
        }
    }
}