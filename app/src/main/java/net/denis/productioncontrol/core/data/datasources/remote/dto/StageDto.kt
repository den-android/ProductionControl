package net.denis.productioncontrol.core.data.datasources.remote.dto

import net.denis.productioncontrol.features.stage_checklist.model.Stage

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
