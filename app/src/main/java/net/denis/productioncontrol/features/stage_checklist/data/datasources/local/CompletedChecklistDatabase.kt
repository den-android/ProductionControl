package net.denis.productioncontrol.features.stage_checklist.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities.CompletedChecklistItemEntity
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ICompletedChecklistDao

@Database(
    entities = [
        CompletedChecklistItemEntity::class,
    ],
    version = 1
)
abstract class CompletedChecklistDatabase : RoomDatabase() {
    abstract val completedChecklistDao: ICompletedChecklistDao
}