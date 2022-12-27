package net.denis.productioncontrol.domain.model

import net.denis.productioncontrol.data.model.StageData

data class Stage(
    val id: Int,
    val name: String,
    //val checklist: List<Checklist>
) {
    fun toStageData(): StageData {
        return StageData(
            id = id,
            name = name,
            //checklistData = checklist.map { it.toChecklistData() }
        )
    }
}