package com.example.prakmobile8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prakmobile8.databinding.ActivityDisasterItemBinding

class DisasterItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disaster_item)
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", disasterType = "Natural"),
            Disaster(nameDisaster = "Volcanic Eruption", disasterType = "Natural"),
            Disaster(nameDisaster = "Earthquake", disasterType = "Natural"),
            Disaster(nameDisaster = "Flood", disasterType = "Natural"),
            Disaster(nameDisaster = "Fire", disasterType = "Natural"),
            Disaster(nameDisaster = "Nuclear Accident", disasterType = "Man-made"),
            Disaster(nameDisaster = "Terrorist Attack", disasterType = "Man-made"),
            Disaster(nameDisaster = "War", disasterType = "Man-made")
        )
        // Dummy data generation
    }

    class ItemDisasterViewHolder(private val binding: ActivityDisasterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Disaster, onClickDisaster: (Disaster) -> Unit) {
            with(binding) {
                namadisaster.text = data.nameDisaster
                txtDisasterType.text = data.disasterType
                itemView.setOnClickListener {
                    onClickDisaster(data)
                }
            }
        }
    }

    class DisasterAdapter(private val listDisaster: List<Disaster>, private val onClickDisaster: (Disaster) -> Unit) :
        RecyclerView.Adapter<ItemDisasterViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
            val itemBinding = ActivityDisasterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ItemDisasterViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
            holder.bind(listDisaster[position], onClickDisaster)
        }

        override fun getItemCount(): Int {
            return listDisaster.size
        }
    }
}
