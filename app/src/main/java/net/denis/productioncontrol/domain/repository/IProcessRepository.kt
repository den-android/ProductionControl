package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.util.Result

interface IProcessRepository {
    suspend fun getProcess(): Result<List<Process>>
}