package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.model.ChecklistItem

interface IChecklistRepository {

    suspend fun getChecklist(): List<ChecklistItem>

}