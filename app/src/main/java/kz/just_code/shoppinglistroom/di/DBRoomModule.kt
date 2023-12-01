package kz.just_code.shoppinglistroom.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kz.just_code.shoppinglistroom.data.source.local.database.AppDatabase
import kz.just_code.shoppinglistroom.data.source.local.database.ShoppingItemDao
import kz.just_code.shoppinglistroom.general.DatabaseName
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBRoomModule {


    @Provides
    @Singleton
    fun provideDB0(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = DatabaseName.ROOM_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoppingItemDao(appDatabase: AppDatabase): ShoppingItemDao{
        return appDatabase.shoppingItemDao()
    }

}