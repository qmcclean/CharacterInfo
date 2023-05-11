package com.example.characterinfo.views

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.characterinfo.R
import com.example.characterinfo.databinding.ActivityCharacterBinding
import com.example.characterinfo.network.response.RelatedTopic
import com.example.characterinfo.viewModels.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterActivity : AppCompatActivity() {

    private val viewModel : CharacterViewModel by viewModel()

    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        viewModel.fetchData()

        setSupportActionBar(binding.toolbar)
        val adapter = CharactersAdapter { onClickItem(it) }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.characters.observe(this) {
            supportActionBar?.title = it.heading
            adapter.submitList(it.relatedTopics)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }
        })
        binding.searchView.setOnCloseListener {
            adapter.filter.filter("")
            false
        }
    }

    private fun onClickItem(item: RelatedTopic) {
        viewModel.setSelectCharacter(item)
        val fragment = CharacterDetailFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .addToBackStack(CharacterDetailFragment.TAG)
            .commit()
    }
}
