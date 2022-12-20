package net.denis.productioncontrol.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.repository.CarRepository
import net.denis.productioncontrol.data.repository.ChecklistRepository
import net.denis.productioncontrol.data.repository.ProductionProcessRepository
import net.denis.productioncontrol.domain.repository.ICarRepository
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import net.denis.productioncontrol.domain.repository.IProductionProcessRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindChecklistRepository(checklistRepository: ChecklistRepository): IChecklistRepository

    @Binds
    @Singleton
    abstract fun bindCarRepository(carRepository: CarRepository): ICarRepository

    @Binds
    @Singleton
    abstract fun bindProductionProcessRepository(productionProcessRepository: ProductionProcessRepository): IProductionProcessRepository

}