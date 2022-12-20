package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object CarList : Screen("CarList")

    object ProcessList : Screen("Process?id={id}"){
        fun passCarId(id: Int): String {
            return "Process?id=$id"
        }
    }

    object Checklist : Screen("Checklist?id={id}"){
        fun passProcessId(id: Int): String {
            return "Checklist?id=$id"
        }
    }

}