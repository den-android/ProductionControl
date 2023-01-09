package net.denis.productioncontrol.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import net.denis.productioncontrol.data.remote.RemoteDataSource
import net.denis.productioncontrol.data.repository.StageRepository
import net.denis.productioncontrol.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.data.interfaces.IStageRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindIAssemblyStageRepository(stageRepository: StageRepository): IStageRepository

    @Binds
    @ViewModelScoped
    abstract fun bindIRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource
}