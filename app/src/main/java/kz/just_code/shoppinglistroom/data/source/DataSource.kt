package kz.just_code.shoppinglistroom.data.source

import kotlinx.coroutines.flow.Flow
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem

interface DataSource{
    interface Local{
        fun getShoppingItemList(): Flow<List<ShoppingItem>>
        suspend fun addShoppingItem(shoppingItem: ShoppingItem)
        suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
        suspend fun setIsBought(shoppingItem: ShoppingItem)
    }
}