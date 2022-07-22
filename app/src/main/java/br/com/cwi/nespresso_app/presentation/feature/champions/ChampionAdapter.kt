package br.com.cwi.nespresso_app.presentation.feature.champions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ItemChampionBinding
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.presentation.feature.extension.inflate
import br.com.cwi.nespresso_app.presentation.feature.extension.loadImage

class ChampionAdapter(
    val context: Context,
    private var list: List<Champion>,
    private val onChampionClick: (String) -> Unit
) : RecyclerView.Adapter<ChampionAdapter.CharacterViewHolder>() {

    fun updateItems(newItems: List<Champion>) {
        list = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(parent.inflate(R.layout.item_champion, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size

    inner class CharacterViewHolder(item: View) : ViewHolder(item) {

        private val ivCharacter = ItemChampionBinding.bind(item).ivChampionPhoto
        private val tvCharacterName = ItemChampionBinding.bind(item).tvChampionName

        fun bind(champion: Champion) = with(champion) {
            ivCharacter.loadImage(image_icon)
            tvCharacterName.text = name

            itemView.setOnClickListener {
                onChampionClick(id)


            }
        }
    }
}

