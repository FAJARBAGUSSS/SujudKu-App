package com.example.sujudku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.homefragment, container, false)

        recyclerView = view.findViewById(R.id.rvPrayers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Ambil data dari repository
        val adapter = PrayerAdapter(PrayerRepository.getPrayerList())

        recyclerView.adapter = adapter

        return view
    }
}
