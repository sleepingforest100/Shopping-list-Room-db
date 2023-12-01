package kz.just_code.shoppinglistroom.domain.usecase

import kotlinx.coroutines.flow.Flow
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import kz.just_code.shoppinglistroom.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class GetShoppingItemListUseCase @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository
) {
    operator fun invoke(): Flow<List<ShoppingItem>> = shoppingItemRepository.shoppingList
}