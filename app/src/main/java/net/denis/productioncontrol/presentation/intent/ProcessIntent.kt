package net.denis.productioncontrol.presentation.intent

sealed class ProcessIntent {
    object getProcess: ProcessIntent()
}