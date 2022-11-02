package com.harets.testing_features.features.the_lazy_media.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.harets.testing_features.databinding.RowItemGameLazyBinding
import com.harets.testing_features.features.the_lazy_media.response.LazyResponseItem

class LazyGamesAdapter(val games : List<LazyResponseItem>) : RecyclerView.Adapter<LazyGamesAdapter.GamesViewHolder>(){

    class GamesViewHolder(val binding: RowItemGameLazyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder(
            RowItemGameLazyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val game = games[position]
        holder.binding.apply {
            txtTitle.text = game.title
            Glide.with(ivPicture)
                .load(game.thumb)
                .apply(RequestOptions())
                .override(100,100)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(ivPicture)
        }
    }

    override fun getItemCount() = games.size
}