package net.denis.productioncontrol.features.stage_checklist.mvi

import net.denis.productioncontrol.core.presentation.redux.Action

sealed class UiAction : Action {
    object PopBackStack : UiAction()
    data class Navigate(val route: String) : UiAction()
    data class ShowAlertDialog(
        val message: String,
        val action: String? = null,
    ): UiAction()
}