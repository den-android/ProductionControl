package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object CarList : Screen("CarList")

    object ProductionProcessList : Screen("ProductionProcess?id={id}"){
        fun passCarId(id: Int): String {
            return "ProductionProcess?id=$id"
        }
    }

    object Checklist : Screen("Checklist?id={id}"){
        fun passProcessId(id: Int): String {
            return "Checklist?id=$id"
        }
    }

}