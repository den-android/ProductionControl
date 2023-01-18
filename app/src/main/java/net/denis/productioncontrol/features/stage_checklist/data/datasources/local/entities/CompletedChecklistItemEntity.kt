package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "completed_checklist_item_table"
)
data class CompletedChecklistItemEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "stage_id")
    val stageId: Int,

    @ColumnInfo(name = "status_code")
    val statusCode: Int,

    @ColumnInfo(name = "status_message")
    val statusMessage: String?,
)