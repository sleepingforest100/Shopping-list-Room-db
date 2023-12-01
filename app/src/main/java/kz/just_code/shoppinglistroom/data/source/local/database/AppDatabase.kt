package kz.just_code.shoppinglistroom.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.just_code.shoppinglistroom.data.model.ShoppingItemEntity
import javax.inject.Singleton

@Singleton
@Database(entities = [ShoppingItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun shoppingItemDao(): ShoppingItemDao
}