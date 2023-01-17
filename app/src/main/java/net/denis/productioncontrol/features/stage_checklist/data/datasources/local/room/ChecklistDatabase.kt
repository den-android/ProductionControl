package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities.ChecklistEntity
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities.StageEntity

@Database(
    entities = [
        StageEntity::class,
        ChecklistEntity::class,
    ],
    version = 1
)
abstract class ChecklistDatabase : RoomDatabase() {
    abstract val checklistDao: IChecklistDao
}