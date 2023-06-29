package com.sample.wireviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sample.wireviewer.R
import com.sample.wireviewer.databinding.FragmentCharacterDetailBinding

import com.sample.wireviewer.CharacterModel.RelatedTopic
//import com.example.wireviewer.databinding.FragmentForecastDetailBinding
import com.sample.wireviewer.util.parseName


class CharacterDetailFragment : Fragment() {
    private val TAG = "CharacterDetailFragment"
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!
    private val args: com.sample.wireviewer.view.CharacterDetailFragmentArgs by navArgs()
    private lateinit var cDetail: RelatedTopic

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharacterDetailBinding.inflate(layoutInflater, container, false).also {
        _binding = it

        cDetail = args.cDetail
        initViews()

    }.root


    private fun initViews() = with(binding) {


        if (cDetail != null) {
            binding.characterDescriptTextView?.text = cDetail.Text.toString()
            binding.characterTitleTextView.text = parseName(cDetail.Text.toString())
            val imageUrl = cDetail.Icon.URL
            if (imageUrl != null && imageUrl.isNotEmpty()) {
                val completeImageUrl  = "https://duckduckgo.com$imageUrl"

                Glide.with(requireContext())
                    .load(completeImageUrl)
                    .placeholder(R.drawable.place_holder) // Replace with your placeholder image resource
                    .error(R.drawable.error_image) // Replace with your error image resource (optional)
                    .into(binding.characterImageView)

            } else {
                binding.characterImageView.setImageResource(R.drawable.place_holder)
            }


        }

    }


}