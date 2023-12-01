package kz.just_code.shoppinglistroom.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem

interface ShoppingItemRepository {
    val shoppingList: Flow<List<ShoppingItem>>
    suspend fun addShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
    suspend fun setIsBought(shoppingItem: ShoppingItem)
}