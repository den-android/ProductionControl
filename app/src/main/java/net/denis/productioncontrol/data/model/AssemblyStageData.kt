package net.denis.productioncontrol.data.model

import net.denis.productioncontrol.data.local.room.entities.AssemblyStageEntity
import net.denis.productioncontrol.domain.model.AssemblyStage

data class AssemblyStageData (
    val id: Int,
    val name: String,
    val checklistData: List<ChecklistData>
) {
    fun toAssemblyStage(): AssemblyStage {
        return AssemblyStage(
            id = id,
            name = name,
            checklist = checklistData.map { it.toChecklist() }
        )
    }
    fun toAssemblyStageEntity(): AssemblyStageEntity {
        return AssemblyStageEntity(
            id = id,
            name = name,
            checklistItem = checklistData.map { it.toChecklistEntity() }
        )
    }
}