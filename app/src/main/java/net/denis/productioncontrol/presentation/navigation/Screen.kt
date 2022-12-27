package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object Stage : Screen("Stage")

    object Checklist : Screen("Checklist?id={id}") {
        fun passStageId(id: Int): String = "Checklist?=id=$id"
    }

}