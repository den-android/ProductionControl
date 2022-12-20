package net.denis.productioncontrol.presentation.state

import net.denis.productioncontrol.domain.model.ProductionProcess

sealed class MainViewState {
    object Idle : MainViewState()
    object Loading : MainViewState()
    class Error(val message: String) : MainViewState()
    class Success(val data: List<ProductionProcess>) : MainViewState()
}
