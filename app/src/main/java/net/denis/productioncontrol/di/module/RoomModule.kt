package net.denis.productioncontrol.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.local.room.AppDatabase
import net.denis.productioncontrol.data.local.room.dao.StageDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "production_control_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideStageDao(appDatabase: AppDatabase): StageDao {
        return appDatabase.stageDao()
    }

}