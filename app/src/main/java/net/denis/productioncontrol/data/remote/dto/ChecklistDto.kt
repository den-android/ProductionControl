package net.denis.productioncontrol.data.remote.dto

import net.denis.productioncontrol.presentation.model.Checklist

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
