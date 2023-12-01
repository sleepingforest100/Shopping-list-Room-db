package kz.just_code.shoppinglistroom.data.mapper

import kz.just_code.shoppinglistroom.data.model.ShoppingItemEntity
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import javax.inject.Inject

class ShoppingItemMapper @Inject constructor() {
    fun fromEntity(argument: ShoppingItemEntity) = ShoppingItem(
        id = argument.id,
        name = argument.name,
        isBought = argument.isBought
    )

    fun toEntity(argument: ShoppingItem) = ShoppingItemEntity(
        id = argument.id,
        name = argument.name,
        isBought = argument.isBought
    )

    fun fromEntity(argument: List<ShoppingItemEntity>): List<ShoppingItem> =
        argument.map(::fromEntity)

    fun toEntity(argument: List<ShoppingItem>): List<ShoppingItemEntity> =
        argument.map(::toEntity)
}