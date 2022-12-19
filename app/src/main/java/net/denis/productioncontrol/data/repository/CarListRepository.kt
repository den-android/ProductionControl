package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.common.Result
import net.denis.productioncontrol.domain.model.CarItem
import net.denis.productioncontrol.domain.repository.ICarListRepository
import javax.inject.Inject

class CarListRepository @Inject constructor(

): ICarListRepository {
    override suspend fun getCarList(): Result<List<CarItem>> {
        return try {
            Result.Success(remoteDataSource)
        } catch (e: Exception) {
            Result.Error(message = e.message ?: "Some error")
        }
    }

    private val remoteDataSource = (1..100).map {
        CarItem(
            idCar = it,
            nameCar = "NameCar $it",
            modelCar = "ModelCar $it",
        )
    }

}