package net.denis.productioncontrol.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.local.room.AppDatabase
import net.denis.productioncontrol.data.local.room.dao.CarListDao
import net.denis.productioncontrol.data.local.room.dao.ChecklistDao
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
            "productionControl_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCarListDao(appDatabase: AppDatabase): CarListDao {
        return appDatabase.carListDao()
    }

    @Provides
    @Singleton
    fun provideChecklistDao(appDatabase: AppDatabase): ChecklistDao {
        return appDatabase.checklistDao()
    }
}