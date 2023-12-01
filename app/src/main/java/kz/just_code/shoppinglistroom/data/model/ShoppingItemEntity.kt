package kz.just_code.shoppinglistroom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val isBought: Boolean,
)