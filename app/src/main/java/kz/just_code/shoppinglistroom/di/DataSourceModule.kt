package kz.just_code.shoppinglistroom.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.just_code.shoppinglistroom.data.source.DataSource
import kz.just_code.shoppinglistroom.data.source.local.LocalDataSource

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule{
    @Binds
    fun bindDataSourceLocally(localDataSource: LocalDataSource): DataSource.Local
}