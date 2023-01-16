package net.denis.productioncontrol.features.stage_checklist.data.remote.dto

import net.denis.productioncontrol.features.stage_checklist.presentation.model.Checklist

data class ChecklistDto(
    val id: Int,
    val name: String
) {
    fun toChecklist(): Checklist {
        return Checklist(
            id = id,
            name = name
        )
    }

}
