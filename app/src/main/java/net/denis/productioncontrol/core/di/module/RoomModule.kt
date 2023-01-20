package net.denis.productioncontrol.core.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.core.data.datasources.local.ChecklistDatabase
import net.denis.productioncontrol.core.data.interfaces.IChecklistDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideCompletedChecklistDatabase(app: Application): ChecklistDatabase {
        return Room.databaseBuilder(
            app,
            ChecklistDatabase::class.java,
            "checklist_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideIChecklistDao(checklistDatabase: ChecklistDatabase): IChecklistDao {
        return checklistDatabase.completedChecklistDao
    }

}