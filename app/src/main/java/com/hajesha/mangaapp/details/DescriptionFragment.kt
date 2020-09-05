package com.hajesha.mangaapp.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.hajesha.mangaapp.R

class DescriptionFragment : Fragment() {

    private lateinit var descriptionViewModel:DescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        descriptionViewModel = ViewModelProviders.of(this).get(DescriptionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_description, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        //do nothing for now
    }
}