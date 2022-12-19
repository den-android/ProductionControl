package net.denis.productioncontrol.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.repository.CarListRepository
import net.denis.productioncontrol.data.repository.ChecklistRepository
import net.denis.productioncontrol.domain.repository.ICarListRepository
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindChecklistRepository(checklistRepository: ChecklistRepository): IChecklistRepository

    @Binds
    @Singleton
    abstract fun bindCarListRepository(carListRepository: CarListRepository): ICarListRepository

}