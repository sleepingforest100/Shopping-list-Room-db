package kz.just_code.shoppinglistroom.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import kz.just_code.shoppinglistroom.domain.model.ShoppingItem
import kz.just_code.shoppinglistroom.domain.usecase.AddShoppingItemUseCase
import kz.just_code.shoppinglistroom.domain.usecase.DeleteShoppingItemUseCase
import kz.just_code.shoppinglistroom.domain.usecase.GetShoppingItemListUseCase
import kz.just_code.shoppinglistroom.domain.usecase.SetIsBoughtUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getShoppingItemListUseCase: GetShoppingItemListUseCase,
    private val addShoppingItemUseCase: AddShoppingItemUseCase,
    private val deleteShoppingItemUseCase: DeleteShoppingItemUseCase,
    private val setIsBoughtUseCase: SetIsBoughtUseCase,
): ViewModel() {
    val shoppingList: LiveData<List<ShoppingItem>> = getShoppingItemListUseCase().asLiveData()

    fun addShoppingItem(name: String) = viewModelScope.launch {
        addShoppingItemUseCase(
            ShoppingItem(name=name)
        )
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        deleteShoppingItemUseCase(shoppingItem)
    }
    fun setIsBought(shoppingItem: ShoppingItem) = viewModelScope.launch {
        setIsBoughtUseCase(shoppingItem)
    }
}