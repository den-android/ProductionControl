package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object CarList : Screen("CarList")

    object Checklist : Screen("Checklist?id={id}"){
        fun passCarId(id: Int): String {
            return "Checklist?id=$id"
        }
    }

}