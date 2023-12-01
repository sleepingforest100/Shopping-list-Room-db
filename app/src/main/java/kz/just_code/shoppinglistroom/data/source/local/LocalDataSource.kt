package kz.just_code.shoppinglistroom.data.source.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kz.just_code.shoppinglistroom.data.mapper.ShoppingItemMapper
import kz.just_code.shoppinglistroom.data.source.DataSource
import kz.just_code.shoppinglistroom.data.source.local.database.ShoppingItemDao
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao,
    private val shoppingItemMapper: ShoppingItemMapper
) : DataSource.Local {
    override fun getShoppingItemList(): Flow<List<ShoppingItem>> =
        shoppingItemDao.getShoppingItemList().map(shoppingItemMapper::fromEntity)

    override suspend fun addShoppingItem(shoppingItem: ShoppingItem) =
        shoppingItemDao.insert(
            shoppingItem.run(shoppingItemMapper::toEntity)
        )

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItemDao.delete(
            shoppingItem.run(shoppingItemMapper::toEntity)
        )
    }

    override suspend fun setIsBought(shoppingItem: ShoppingItem) {
        shoppingItemDao.setIsBought(
            id = shoppingItem.id,
            isBought = shoppingItem.isBought
        )
    }

}