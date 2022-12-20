package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.Car

data class CarListState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val cars: List<Car> = emptyList(),
    var isChecked: Boolean = false
)