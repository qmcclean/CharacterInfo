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

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CharacterActivity)
            this.adapter = adapter
        }

        viewModel.characters.observe(this) {
            supportActionBar?.title = it.heading
            adapter.submitList(it.relatedTopics)
            adapter.setOriginalList(viewModel.characters)
        }

        binding.searchView.apply {
            onActionViewExpanded()
            queryHint = resources.getString(R.string.search_hint)
            clearFocus()

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(query: String?): Boolean {
                    if (query?.isEmpty() == true) {
                        adapter.filter.filter("")
                        scrollToPositionZero()
                    }
                    adapter.filter.filter(query)
                    return false
                }

                override fun onQueryTextSubmit(query: String?): Boolean {
                    adapter.filter.filter(query)
                    return false
                }
            })

            setOnCloseListener {
                adapter.filter.filter("")
                scrollToPositionZero()
                false
            }
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

    private fun scrollToPositionZero() {
        (binding.recyclerView.layoutManager as? LinearLayoutManager)?.scrollToPosition(0)
    }
}
