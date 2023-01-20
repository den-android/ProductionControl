package net.denis.productioncontrol.core.data.datasources.remote.dto

import net.denis.productioncontrol.features.stage_checklist.model.Checklist

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
