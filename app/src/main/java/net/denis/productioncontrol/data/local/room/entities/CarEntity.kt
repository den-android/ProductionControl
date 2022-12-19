package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "car_table"
)

data class CarEntity(
    /**
     *  Расширить модель
     */
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "name_car")
    val nameCar: String,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "model_car")
    val modelCar: String,

    ): Serializable