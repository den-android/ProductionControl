package net.denis.productioncontrol.data.model

import net.denis.productioncontrol.data.local.room.entities.StageEntity
import net.denis.productioncontrol.domain.model.Stage

data class StageData (
    val id: Int,
    val name: String,
    //val checklistData: List<ChecklistData>
) {
    fun toStage(): Stage {
        return Stage(
            id = id,
            name = name,
            //checklist = checklistData.map { it.toChecklist() }
        )
    }
    fun toStageEntity(): StageEntity {
        return StageEntity(
            id = id,
            name = name,
            //checklistItem = checklistData.map { it.toChecklistEntity() }
        )
    }
}