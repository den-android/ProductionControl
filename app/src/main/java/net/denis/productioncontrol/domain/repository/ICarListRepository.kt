package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.common.Result
import net.denis.productioncontrol.domain.model.CarItem

interface ICarListRepository {

    suspend fun getCarList(): Result<List<CarItem>>

}