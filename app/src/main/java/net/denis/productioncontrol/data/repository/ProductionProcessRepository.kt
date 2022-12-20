package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.domain.model.Car
import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.domain.model.ProductionProcess
import net.denis.productioncontrol.domain.repository.IProductionProcessRepository
import net.denis.productioncontrol.domain.util.Result
import javax.inject.Inject

class ProductionProcessRepository @Inject constructor(

) : IProductionProcessRepository {
    override suspend fun getProductionProcess(): Result<List<ProductionProcess>> {
        TODO("Not yet implemented")
    }

    private val remoteDataSource = (1..5).map {
        ProductionProcess(
            id = it,
            name = "Production process name $it",
            checklist = listOf(
                Checklist(
                    id = it,
                    name = "#$it checklistItem name $it"
                )
            )
        )
    }
}