package com.example.callerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecentFragment : Fragment() {

    private val recentContacts = listOf(
        Contact("John", "1234567890"),
        Contact("Smith", "9876543210"),
        Contact("Johnson", "5555555555")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recent, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewRecent)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PhoneNumberAdapter(recentContacts)
        return view
    }
}