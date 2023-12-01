package kz.just_code.shoppinglistroom.data.repository

import kotlinx.coroutines.flow.Flow
import kz.just_code.shoppinglistroom.data.source.DataSource
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import kz.just_code.shoppinglistroom.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class ShoppingItemRepositoryImplementation @Inject constructor(
    private val local: DataSource.Local,
) : ShoppingItemRepository {
    override val shoppingList = local.getShoppingItemList()

    override suspend fun addShoppingItem(shoppingItem: ShoppingItem) =
        local.addShoppingItem(shoppingItem)


    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) =
        local.deleteShoppingItem(shoppingItem)


    override suspend fun setIsBought(shoppingItem: ShoppingItem) =
        local.setIsBought(shoppingItem)


}