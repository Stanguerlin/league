package br.com.cwi.nespresso_app.presentation.products.coffee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.data.entity.CategoryResponse
import br.com.cwi.nespresso_app.data.entity.CoffeeResponse
import br.com.cwi.nespresso_app.databinding.ItemCategoryBinding
import br.com.cwi.nespresso_app.databinding.ItemCoffeBinding
import br.com.cwi.nespresso_app.presentation.extension.toMoneyFormat
import com.bumptech.glide.Glide

private const val VIEW_TYPE_CATEGORY = 0

class CoffeAdapter(val context: Context, private val list: List<CapsuleType>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == VIEW_TYPE_CATEGORY) {
            CategoryViewHolder(inflateView(R.layout.item_category, parent))
        } else {
            CapsuleViewHolder(inflateView(R.layout.item_coffe, parent))
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]

        if (item.type == VIEW_TYPE_CATEGORY) {

            item as CategoryResponse
            (viewHolder as CategoryViewHolder).bind(item)

        } else {

            item as CoffeeResponse
            (viewHolder as CapsuleViewHolder).bind(context, item)

        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) = list[position].type

    private fun inflateView(layout: Int, parent: ViewGroup) = LayoutInflater
        .from(parent.context)
        .inflate(layout, parent, false)
}

class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvCategory = ItemCategoryBinding.bind(item).tvCategory

    fun bind(item: CategoryResponse) {
        tvCategory.text = item.category
    }
}

class CapsuleViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val tvTitle = ItemCoffeBinding.bind(item).tvCapsuleTitle
    private val tvSubtitle = ItemCoffeBinding.bind(item).tvCapsuleSubtitle
    private val ivImage = ItemCoffeBinding.bind(item).ivCapsuleImage
    private val tvIntensity = ItemCoffeBinding.bind(item).tvCapsuleIntensity
    private val tvPrice = ItemCoffeBinding.bind(item).tvCapsulePrice
    private val ivFavorite = ItemCoffeBinding.bind(item).ivFavorite

    fun bind(context: Context, item: CoffeeResponse) {
        tvTitle.text = item.name
        tvSubtitle.text = item.description
        tvIntensity.text = context.getString(R.string.txt_intensity, item.intensity)
        tvPrice.text = item.unitPrice.toMoneyFormat()

        Glide.with(context)
            .load(item.urlImage)
            .into(ivImage)
    }
}
