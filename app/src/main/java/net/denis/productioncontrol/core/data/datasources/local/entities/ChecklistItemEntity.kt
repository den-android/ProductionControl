package net.denis.productioncontrol.core.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem

@Entity(
    tableName = "checklist_item_table"
)
data class ChecklistItemEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "checklist_item_id")
    val checklistItemId: Int,

    @ColumnInfo(name = "stage_id")
    val stageId: Int,

    @ColumnInfo(name = "status_code")
    val statusCode: Int,

    @ColumnInfo(name = "status_message")
    val statusMessage: String,
) {
    fun toChecklistItem() = ChecklistItem(
        checklistItemId = checklistItemId,
        stageId = stageId,
        statusId = statusCode,
        message = statusMessage,
    )
}