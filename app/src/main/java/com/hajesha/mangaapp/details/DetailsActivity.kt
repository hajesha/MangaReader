package com.hajesha.mangaapp.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.hajesha.mangaapp.R

class DetailsActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        setUpViewPager(viewPager)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setUpViewPager(viewPager : ViewPager ) {
        val adapter = DetailsAdapter(supportFragmentManager)
        adapter.addFragment(DescriptionFragment(), "Description")
        adapter.addFragment(DescriptionFragment(), "Chapters")
        viewPager.adapter = adapter
    }
}
