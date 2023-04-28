package com.example.characterinfo.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.characterinfo.R
import com.example.characterinfo.databinding.FragmentCharacterDetailBinding
import com.example.characterinfo.viewModels.CharacterViewModel
import com.squareup.picasso.Picasso

private const val BASE_URL = "https://duckduckgo.com/"

class CharacterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailBinding

    private val viewModel : CharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        viewModel.selectedCharacter.observe(viewLifecycleOwner) {
            binding.title.text = it.Text.substringBefore("-")
            binding.description.text = it.Text
            val icon = BASE_URL+it.Icon.URL
            if (it.Icon.URL.isNullOrEmpty()) {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_android_black_24dp)
            } else {
                Picasso.get().load(icon).into(binding.iconURL)
            }
        }
        return binding.root
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
           view?.visibility = View.GONE
        } else {
            view?.visibility = View.VISIBLE
        }
    }

    companion object {
        const val TAG = "DetailFragment"
    }
}