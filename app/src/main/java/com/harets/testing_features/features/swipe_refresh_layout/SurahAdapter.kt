package com.harets.testing_features.features.swipe_refresh_layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harets.testing_features.R
import com.harets.testing_features.databinding.RowItemSwpRefrshBinding

class SurahAdapter(val surah : List<DataItem>) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    class SurahViewHolder(val binding: RowItemSwpRefrshBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        return SurahViewHolder(
            RowItemSwpRefrshBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surat = surah[position]
        holder.binding.txtName.text = surat.englishName
    }

    override fun getItemCount() = surah.size
}