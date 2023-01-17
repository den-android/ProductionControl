package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "checklist_table"
)
data class ChecklistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "checklist_name")
    val name: String,
)