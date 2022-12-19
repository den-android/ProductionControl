package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.CarItem

data class CarListState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val cars: List<CarItem> = emptyList(),
    var isChecked: Boolean = false
)