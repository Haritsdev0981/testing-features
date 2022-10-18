package com.harets.testing_features.features

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.harets.testing_features.R
import com.harets.testing_features.databinding.FragmentCompassBinding
import kotlin.text.Typography.degree
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.seconds


class CompassFragment : Fragment() , SensorEventListener {

    private lateinit var binding : FragmentCompassBinding

    private lateinit var sensorManager : SensorManager
    private lateinit var sensor : Sensor
    private var currentDegree : Float = 0.5f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompassBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION)

        if (sensor  != null){
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
        }else{
            Toast.makeText(context, "not Support", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
         var degree  = Math.round(event.values[0])
        val animation : RotateAnimation =  RotateAnimation(currentDegree,
        (-degree).toFloat(), Animation.RELATIVE_TO_SELF,0.5f,  Animation.RELATIVE_TO_SELF, 0.5F)
        animation.duration
        animation.fillAfter
        binding.ivCompass
        currentDegree= (-degree).toFloat()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
}