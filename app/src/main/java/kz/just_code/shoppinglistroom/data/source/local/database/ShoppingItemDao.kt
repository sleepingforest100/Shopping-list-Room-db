package kz.just_code.shoppinglistroom.data.source.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kz.just_code.shoppinglistroom.data.model.ShoppingItemEntity

@Dao
interface ShoppingItemDao {

    @Query("Select * from shopping_items")
    fun getShoppingItemList(): Flow<List<ShoppingItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shoppingItemEntity: ShoppingItemEntity)

    @Delete
    suspend fun delete(shoppingItemEntity: ShoppingItemEntity)

    @Query("Update shopping_items set isBought = :isBought where id = :id")
    suspend fun setIsBought(id: Int, isBought: Boolean)
}