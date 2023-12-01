package kz.just_code.shoppinglistroom.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.just_code.shoppinglistroom.R
import kz.just_code.shoppinglistroom.databinding.ItemShoppingBinding
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem

class ShoppingListAdapter(
    private val onBuyItemClick: (ShoppingItem) -> Unit,
    private val onDeleteClick: (ShoppingItem) -> Unit
) : ListAdapter<ShoppingItem, ShoppingListAdapter.ShoppingViewHolder>(ShoppingDiffCallBack) {

    inner class ShoppingViewHolder(
        private val binding: ItemShoppingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shoppingItem: ShoppingItem) {
            with(binding) {
                name.text = shoppingItem.name
                if (shoppingItem.isBought) {
                    purchase.setImageResource(R.drawable.ic_purchased)
                } else {
                    purchase.setImageResource(R.drawable.ic_not_purchased)
                }
                purchase.setOnClickListener {
                    shoppingItem.isBought = !shoppingItem.isBought
                    if (shoppingItem.isBought) {
                        purchase.setImageResource(R.drawable.ic_purchased)
                    } else {
                        purchase.setImageResource(R.drawable.ic_not_purchased)
                    }
                    onBuyItemClick(shoppingItem)
                }
                link.setOnClickListener {
                    onDeleteClick(shoppingItem)
                }
            }

        }
    }

    companion object {
        private val ShoppingDiffCallBack = object : DiffUtil.ItemCallback<ShoppingItem>() {
            override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(
            ItemShoppingBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}