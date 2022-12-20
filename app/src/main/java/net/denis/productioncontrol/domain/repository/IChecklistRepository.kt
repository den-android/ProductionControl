package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.model.Checklist

interface IChecklistRepository {

    suspend fun getChecklist(): List<Checklist>

}