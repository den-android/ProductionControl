package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "process_table"
)

data class ProcessEntity(
    /**
     *  Расширить модель
     */

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "process_name")
    val name: String,

   /*
    val checklistItem: Checklist
    */

    ) : Serializable