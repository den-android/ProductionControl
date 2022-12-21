package net.denis.productioncontrol.presentation.navigation

sealed class Screen(val route: String) {

    object AssemblyStageList : Screen("AssemblyStage")

    object Checklist : Screen("Checklist?id={id}"){
        fun passProcessId(id: Int): String {
            return "Checklist?id=$id"
        }
    }

}