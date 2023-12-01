package kz.just_code.shoppinglistroom.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import kz.just_code.shoppinglistroom.domain.repository.ShoppingItemRepository
import javax.inject.Inject

class SetIsBoughtUseCase @Inject constructor(
    private val shoppingItemRepository: ShoppingItemRepository
){
    suspend operator fun invoke(shoppingItem: ShoppingItem) = withContext(Dispatchers.IO){
        shoppingItemRepository.setIsBought(shoppingItem)
    }

}