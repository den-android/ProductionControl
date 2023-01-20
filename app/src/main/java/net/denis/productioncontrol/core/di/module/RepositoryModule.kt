package net.denis.productioncontrol.core.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.core.data.datasources.local.LocalDataSource
import net.denis.productioncontrol.core.data.datasources.remote.RemoteDataSource
import net.denis.productioncontrol.core.data.interfaces.ILocalDataSource
import net.denis.productioncontrol.core.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.core.data.interfaces.IStageRepository
import net.denis.productioncontrol.core.data.repository.StageRepository
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

    @Binds
    @Singleton
    abstract fun bindILocalDataSource(localDataSource: LocalDataSource): ILocalDataSource
}