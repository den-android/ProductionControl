package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.domain.repository.IChecklistRepository
import javax.inject.Inject

class ChecklistRepository @Inject constructor(

) : IChecklistRepository {
    override suspend fun getChecklist(): List<Checklist> {
        TODO("Not yet implemented")
    }
}