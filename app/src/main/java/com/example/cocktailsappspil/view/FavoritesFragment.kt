package com.example.cocktailsappspil.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cocktailsappspil.R
import com.example.cocktailsappspil.databinding.FragmentDrinksListBinding

class FavoritesFragment : Fragment() {

    private val binding by lazy {
        FragmentDrinksListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}