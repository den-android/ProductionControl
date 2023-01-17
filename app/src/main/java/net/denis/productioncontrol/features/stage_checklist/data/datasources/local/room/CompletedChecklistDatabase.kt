package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities.CompletedChecklistEntity
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.ICompletedChecklistDao

@Database(
    entities = [
        CompletedChecklistEntity::class,
    ],
    version = 1
)
abstract class CompletedChecklistDatabase : RoomDatabase() {
    abstract val completedChecklistDao: ICompletedChecklistDao
}