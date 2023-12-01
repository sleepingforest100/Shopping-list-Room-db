package kz.just_code.shoppinglistroom.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.shoppinglistroom.data.repository.ShoppingItemRepositoryImplementation
import kz.just_code.shoppinglistroom.domain.repository.ShoppingItemRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindShoppingRepository(shoppingItemRepositoryImplementation: ShoppingItemRepositoryImplementation): ShoppingItemRepository
}