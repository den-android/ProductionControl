package net.denis.productioncontrol.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.denis.productioncontrol.data.local.room.dao.CarDao
import net.denis.productioncontrol.data.local.room.dao.ChecklistDao
import net.denis.productioncontrol.data.local.room.dao.AssemblyStageDao
import net.denis.productioncontrol.data.local.room.entities.CarEntity
import net.denis.productioncontrol.data.local.room.entities.ChecklistEntity
import net.denis.productioncontrol.data.local.room.entities.AssemblyStageEntity

@Database(
    entities = [
        CarEntity::class,
        AssemblyStageEntity::class,
        ChecklistEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao
    abstract fun assemblyStageDao(): AssemblyStageDao
    abstract fun checklistDao(): ChecklistDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "production_control_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}