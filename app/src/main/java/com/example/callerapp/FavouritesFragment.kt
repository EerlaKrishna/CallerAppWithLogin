package com.example.callerapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesFragment : Fragment() {

    private val favoriteContacts = listOf(
        Contact("Nana", "4444444444"),
        Contact("Amma", "5555555555"),
        Contact("sis", "6666666666")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourites, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PhoneNumberAdapter(favoriteContacts)
        return view
    }
}