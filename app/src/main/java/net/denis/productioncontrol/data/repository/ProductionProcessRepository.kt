package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.domain.model.ProductionProcess
import net.denis.productioncontrol.domain.repository.IProductionProcessRepository
import net.denis.productioncontrol.domain.util.Result
import javax.inject.Inject

class ProductionProcessRepository @Inject constructor(

) : IProductionProcessRepository {
    override suspend fun getProductionProcess(): Result<List<ProductionProcess>> {
        TODO("Not yet implemented")
    }
}