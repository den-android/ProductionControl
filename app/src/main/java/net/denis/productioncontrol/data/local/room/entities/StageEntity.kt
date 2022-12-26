package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.denis.productioncontrol.data.model.StageData
import java.io.Serializable

@Entity(
    tableName = "stage_table"
)

data class StageEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "stage_name")
    val name: String,
//
//    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "checklist_item")
//    val checklistItem: List<ChecklistEntity>

) : Serializable {
    fun toStageData(): StageData {
        return StageData(
            id = id,
            name = name,
            //checklistData = checklistItem.map { it.toChecklistData() }
        )
    }
}