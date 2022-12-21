package net.denis.productioncontrol.data.remote.dto

import net.denis.productioncontrol.data.model.ChecklistData
import net.denis.productioncontrol.domain.model.Checklist

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

    fun toChecklistData(): ChecklistData {
        return ChecklistData(
            id = id,
            name = name
        )
    }
}
