package com.example.characterinfo.views

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.characterinfo.databinding.ItemCharactersBinding
import com.example.characterinfo.models.CharactersUIData
import com.example.characterinfo.network.response.RelatedTopic


class CharactersAdapter(
    private val listener: (RelatedTopic) -> Unit
) : ListAdapter<RelatedTopic, CharactersAdapter.CharactersViewHolder>(CharacterDiffCallback()), Filterable {

    private var originalList: List<RelatedTopic> = emptyList()
    private var filteredItems: List<RelatedTopic> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharactersViewHolder(
            ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data, listener)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint.toString().lowercase()

                filteredItems = if (query.isEmpty()) {
                    originalList
                } else {
                    currentList.filter { it.text?.lowercase()?.contains(query) == true }
                }

                val results = FilterResults()
                results.values = filteredItems
                return results
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredItems = results?.values as? List<RelatedTopic> ?: emptyList()
                submitList(filteredItems)
                notifyDataSetChanged()
            }
        }
    }

    fun setOriginalList(list: LiveData<CharactersUIData>) {
        originalList = list.value?.relatedTopics.orEmpty()
        submitList(originalList)
    }

    class CharactersViewHolder(
        private val binding: ItemCharactersBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RelatedTopic, clickListener: (RelatedTopic) -> Unit) {
            binding.characterName.text = data.text?.substringBefore("-")
            binding.root.setOnClickListener { clickListener(data) }
        }
    }

    class CharacterDiffCallback : DiffUtil.ItemCallback<RelatedTopic>() {
        override fun areItemsTheSame(oldItem: RelatedTopic, newItem: RelatedTopic): Boolean {
            return oldItem.firstURL == newItem.firstURL
        }

        override fun areContentsTheSame(oldItem: RelatedTopic, newItem: RelatedTopic): Boolean {
            return oldItem == newItem
        }
    }
}