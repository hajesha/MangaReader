package com.hajesha.mangaapp.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DetailsAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragments: ArrayList<Fragment> = ArrayList()
    var tabTitles: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    public fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        tabTitles.add(title)

    }

    public override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles.get(position)
    }
}