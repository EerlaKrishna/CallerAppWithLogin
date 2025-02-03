package com.example.callerapp

import ContactsFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList = listOf(
        RecentFragment(),
        ContactsFragment(),
        FavoritesFragment()
    )

    private val fragmentTitleList = listOf(
        "Recent",
        "Contacts",
        "Favorites"
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun getTitle(position: Int): CharSequence = fragmentTitleList[position]
}