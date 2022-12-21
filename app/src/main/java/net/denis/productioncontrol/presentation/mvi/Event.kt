package net.denis.productioncontrol.presentation.mvi

sealed class Event {
    object onStageClicked: Event()
    object onChecklistClicked: Event()
}