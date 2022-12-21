package net.denis.productioncontrol.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.local.room.LocalDataSource
import net.denis.productioncontrol.data.remote.RemoteDataSource
import net.denis.productioncontrol.data.repository.AssemblyStageRepository
import net.denis.productioncontrol.data.repository.ILocalDataSource
import net.denis.productioncontrol.data.repository.IRemoteDataSource
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindIAssemblyStageRepository(assemblyStageRepository: AssemblyStageRepository): IAssemblyStageRepository

    @Binds
    abstract fun bindILocalDataSource(localDataSource: LocalDataSource): ILocalDataSource

    @Binds
    abstract fun bindIRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource
}