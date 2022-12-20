package net.denis.productioncontrol.domain.repository

import net.denis.productioncontrol.domain.util.Result
import net.denis.productioncontrol.domain.model.Car

interface ICarRepository {

    suspend fun getCarList(): Result<List<Car>>

}