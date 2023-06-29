package com.sample.wireviewer.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

import com.sample.wireviewer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(layoutInflater, container, false).also {
        _binding = it
      //  setupObservers()


        binding.lookUpButton.setOnClickListener {
            Log.i(TAG, "onCreateView: lookupbutton clicked")

            val directions =
                com.sample.wireviewer.view.HomeFragmentDirections.actionHomeFragmentToCharacterListFragment()
            view?.findNavController()?.navigate(directions)

        }


    }.root


    }



