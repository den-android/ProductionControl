package net.denis.productioncontrol.core.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IRemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageRepository
import net.denis.productioncontrol.features.stage_checklist.data.remote.RemoteDataSource
import net.denis.productioncontrol.features.stage_checklist.data.repository.StageRepository

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