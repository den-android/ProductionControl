package net.denis.productioncontrol.data.remote.dto

import net.denis.productioncontrol.data.model.AssemblyStageData
import net.denis.productioncontrol.domain.model.AssemblyStage

data class AssemblyStageDto(
    val id: Int,
    val name: String,
    val checklistDto: List<ChecklistDto>
) {
    fun toAssemblyStage(): AssemblyStage {
        return AssemblyStage(
            id = id,
            name = name,
            checklist = checklistDto.map { it.toChecklist() }
        )
    }

    fun toAssemblyStageData(): AssemblyStageData {
        return AssemblyStageData(
            id = id,
            name = name,
            checklistData = checklistDto.map { it.toChecklistData() }
        )
    }
}
