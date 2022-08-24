package com.evgeshaog.iswarandcraftsoundboardapplication.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evgeshaog.iswarandcraftsoundboardapplication.databinding.ItemSoundboardBinding
import com.evgeshaog.iswarandcraftsoundboardapplication.domain.model.SoundboardItemModel

class SoundboardAdapter : RecyclerView.Adapter<SoundboardViewHolder>() {

    var clickOnItem: ((SoundboardItemModel) -> Unit)? = null

    var items = emptyList<SoundboardItemModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSoundboardBinding.inflate(layoutInflater, parent, false)
        return SoundboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundboardViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            imageView.setImageResource(item.image)
            itemBoard.setOnClickListener {
                clickOnItem?.invoke(item)
            }
        }
    }

    override fun getItemCount() = items.size
}


