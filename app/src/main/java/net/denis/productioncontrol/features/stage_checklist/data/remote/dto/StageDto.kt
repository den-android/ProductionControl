package net.denis.productioncontrol.features.stage_checklist.data.remote.dto

import net.denis.productioncontrol.features.stage_checklist.presentation.model.Stage

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
}
