package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.ProductionProcess

data class ProductionProcessState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val process: List<ProductionProcess> = emptyList()
)