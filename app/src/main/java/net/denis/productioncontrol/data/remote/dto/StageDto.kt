package net.denis.productioncontrol.data.remote.dto

import net.denis.productioncontrol.data.model.StageData
import net.denis.productioncontrol.domain.model.Stage

data class StageDto(
    val id: Int,
    val name: String,
    val checklistDto: List<ChecklistDto>
) {
    fun toStage(): Stage {
        return Stage(
            id = id,
            name = name,
            checklist = checklistDto.map { it.toChecklist() }
        )
    }

    fun toStageData(): StageData {
        return StageData(
            id = id,
            name = name,
            checklistData = checklistDto.map { it.toChecklistData() }
        )
    }
}
