package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.domain.model.ChecklistItem
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import javax.inject.Inject

class ChecklistRepository @Inject constructor(

) : IChecklistRepository {
    override suspend fun getChecklist(): List<ChecklistItem> {
        TODO("Not yet implemented")
    }
}