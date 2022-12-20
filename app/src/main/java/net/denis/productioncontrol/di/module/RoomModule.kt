package net.denis.productioncontrol.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.local.room.AppDatabase
import net.denis.productioncontrol.data.local.room.dao.CarDao
import net.denis.productioncontrol.data.local.room.dao.ChecklistDao
import net.denis.productioncontrol.data.local.room.dao.ProcessDao
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
    fun provideCarDao(appDatabase: AppDatabase): CarDao {
        return appDatabase.carDao()
    }

    @Provides
    @Singleton
    fun provideProcessDao(appDatabase: AppDatabase): ProcessDao {
        return appDatabase.processDao()
    }

    @Provides
    @Singleton
    fun provideChecklistDao(appDatabase: AppDatabase): ChecklistDao {
        return appDatabase.checklistDao()
    }
}