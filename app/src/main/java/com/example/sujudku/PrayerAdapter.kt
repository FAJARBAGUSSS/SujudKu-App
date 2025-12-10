package com.example.sujudku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrayerAdapter(private val data: List<PrayerData>) :
    RecyclerView.Adapter<PrayerAdapter.PrayerViewHolder>() {

    inner class PrayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tvPrayerName)
        val time = view.findViewById<TextView>(R.id.tvPrayerTime)
        val doa = view.findViewById<TextView>(R.id.tvPrayerDoa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prayer, parent, false)
        return PrayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrayerViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.name
        holder.time.text = item.time
        holder.doa.text = item.doa
    }

    override fun getItemCount() = data.size
}
