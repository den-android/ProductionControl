package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "completed_checklist_table"
)
data class CompletedChecklistEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val items: List<Int>
)