package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "assembly_stage_table"
)

data class AssemblyStageEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "assembly_stage_name")
    val name: String,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "checklist_item")
    val checklistItem: ChecklistEntity

) : Serializable