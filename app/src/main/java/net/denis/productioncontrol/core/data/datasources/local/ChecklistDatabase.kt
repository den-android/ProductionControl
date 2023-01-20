package net.denis.productioncontrol.core.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import net.denis.productioncontrol.core.data.datasources.local.entities.ChecklistItemEntity
import net.denis.productioncontrol.core.data.interfaces.IChecklistDao

@Database(
    entities = [
        ChecklistItemEntity::class,
    ],
    version = 1
)
abstract class ChecklistDatabase : RoomDatabase() {
    abstract val completedChecklistDao: IChecklistDao
}