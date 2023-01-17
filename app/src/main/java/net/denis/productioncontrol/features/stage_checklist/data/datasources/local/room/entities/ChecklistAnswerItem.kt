package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "checklist_answer_item"
)
data class ChecklistAnswerItem(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "stage_id")
    val stageId: Int,

    @ColumnInfo(name = "status_code")
    val statusCode: Int,

    @ColumnInfo(name = "status_message")
    val statusMessage: String?,
 