package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.denis.productioncontrol.features.stage_checklist.presentation.model.CompletedChecklistItem

@Entity(
    tableName = "completed_checklist_item_table"
)
data class CompletedChecklistItemEntity(
    @ColumnInfo(name = "stage_id")
    val stageId: Int,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "checklist_item_id")
    val checklistItemId: Int,

    @ColumnInfo(name = "status_code")
    val statusCode: Int,

    @ColumnInfo(name = "status_message")
    val statusMessage: String?,
)