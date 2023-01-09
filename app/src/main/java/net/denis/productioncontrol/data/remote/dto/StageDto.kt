package net.denis.productioncontrol.data.remote.dto

import net.denis.productioncontrol.presentation.model.Stage

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
