package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object Stage : Screen("Stage")

    object Checklist : Screen(route = "Checklist?id={id}") {
        fun passStageId(id: Int = 0): String {
            return "Checklist?id=$id"
        }
    }

}