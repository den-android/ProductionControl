package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.model.ProductionProcess
import net.denis.productioncontrol.domain.util.Result

interface IProductionProcessRepository {
    suspend fun getProductionProcess(): Result<List<ProductionProcess>>
}