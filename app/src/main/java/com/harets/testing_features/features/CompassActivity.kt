package com.harets.testing_features.features

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.harets.testing_features.R
import com.harets.testing_features.databinding.ActivityCompassBinding

class CompassActivity : AppCompatActivity() , SensorEventListener{

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null
    private var currentDegree = 0f

    private lateinit var binding: ActivityCompassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ORIENTATION)
        if (sensor != null) {
            sensorManager!!.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
        } else {
            Toast.makeText(this, "not Support", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val degree = Math.round(sensorEvent.values[0])
        val animation = RotateAnimation(
            currentDegree,
            (-degree).toFloat(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.duration = 500
        animation.fillAfter = true
        binding.ivCompass.animation = animation
        currentDegree = -degree.toFloat()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}