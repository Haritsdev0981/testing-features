package com.harets.testing_features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harets.testing_features.databinding.ActivityMainBinding
import com.harets.testing_features.features.CompassActivity
import com.harets.testing_features.features.CompassFragment
import com.harets.testing_features.features.ShimmerActivity
import com.harets.testing_features.features.swipe_refresh_layout.SwipeRefreshActivity
import com.harets.testing_features.features.the_lazy_media.ui.LazyMediaActivity

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnCompass.setOnClickListener {
                startActivity(Intent( this@MainActivity, CompassActivity::class.java))
            }

            btnShimmerEffect.setOnClickListener {
                startActivity(Intent(this@MainActivity, ShimmerActivity::class.java))
            }
            btnSwipeRefreshEffect.setOnClickListener {
                startActivity(Intent(this@MainActivity, SwipeRefreshActivity::class.java))
            }
            btnRxjava.setOnClickListener {
                startActivity(Intent(this@MainActivity, LazyMediaActivity::class.java))
            }
        }
    }
}