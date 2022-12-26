package net.denis.productioncontrol.domain.model

import net.denis.productioncontrol.data.model.ChecklistData

data class Checklist(
    val id: Int,
    val name: String
){
    fun toChecklistData(): ChecklistData {
        return ChecklistData(
            id = id,
            name = name
        )
    }
}