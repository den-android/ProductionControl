package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "production_process_table"
)

data class ProductionProcessEntity(
    /**
     *  Расширить модель
     */

    @PrimaryKey(autoGenerate = true)
    val processId: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "process_name")
    val processName: String,

   /*
    val checklistItem: Checklist
    */

    ) : Serializable