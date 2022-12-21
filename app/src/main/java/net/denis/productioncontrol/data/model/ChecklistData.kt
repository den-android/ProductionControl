package net.denis.productioncontrol.data.model

import net.denis.productioncontrol.data.local.room.entities.ChecklistEntity
import net.denis.productioncontrol.domain.model.Checklist

data class ChecklistData(
    val id: Int,
    val name: String
) {
    fun toChecklist(): Checklist {
        return Checklist(
            id = id,
            name = name
        )
    }
    fun toChecklistEntity(): ChecklistEntity {
        return ChecklistEntity(
            id = id,
            name = name
        )
    }
}
