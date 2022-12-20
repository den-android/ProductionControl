package net.denis.productioncontrol.data.repository

import net.denis.productioncontrol.common.Result
import net.denis.productioncontrol.domain.model.Car
import net.denis.productioncontrol.domain.repository.ICarRepository
import javax.inject.Inject

class CarRepository @Inject constructor(

): ICarRepository {
    override suspend fun getCarList(): Result<List<Car>> {
        return try {
            Result.Success(remoteDataSource)
        } catch (e: Exception) {
            Result.Error(message = e.message ?: "Some error")
        }
    }

    private val remoteDataSource = (1..5).map {
        Car(
            id = it,
            name = "NameCar $it",
            model = "ModelCar $it",
        )
    }

}