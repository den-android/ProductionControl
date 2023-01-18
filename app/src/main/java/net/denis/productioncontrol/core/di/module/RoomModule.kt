package net.denis.productioncontrol.core.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.CompletedChecklistDatabase
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ICompletedChecklistDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideCompletedChecklistDatabase(app: Application): CompletedChecklistDatabase {
        return Room.databaseBuilder(
            app,
            CompletedChecklistDatabase::class.java,
            "completed_checklist_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideICompletedChecklistDao(completedChecklistDatabase: CompletedChecklistDatabase): ICompletedChecklistDao {
        return completedChecklistDatabase.completedChecklistDao
    }

}