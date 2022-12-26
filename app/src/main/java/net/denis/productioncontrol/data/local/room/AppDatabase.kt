package net.denis.productioncontrol.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import net.denis.productioncontrol.data.local.room.dao.StageDao
import net.denis.productioncontrol.data.local.room.entities.StageEntity

@Database(
    entities = [
        StageEntity::class,
        //ChecklistEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun stageDao(): StageDao

}