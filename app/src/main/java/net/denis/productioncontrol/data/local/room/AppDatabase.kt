package net.denis.productioncontrol.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.denis.productioncontrol.data.local.room.dao.AssemblyStageDao
import net.denis.productioncontrol.data.local.room.entities.ChecklistEntity
import net.denis.productioncontrol.data.local.room.entities.AssemblyStageEntity

@Database(
    entities = [
        AssemblyStageEntity::class,
        ChecklistEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun assemblyStageDao(): AssemblyStageDao

}