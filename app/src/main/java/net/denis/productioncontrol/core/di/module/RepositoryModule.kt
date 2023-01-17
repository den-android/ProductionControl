package net.denis.productioncontrol.core.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.ChecklistDatabase
import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.RemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.IStageApi
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.data.repository.StageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIStageRepository(stageRepository: StageRepository): IStageRepository

    @Binds
    @Singleton
    abstract fun bindIRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource

}