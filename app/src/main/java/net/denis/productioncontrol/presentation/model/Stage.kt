package net.denis.productioncontrol.presentation.model

data class Stage(
    val id: Int,
    val name: String,
    val checklist: List<Checklist>
) {
    fun toTestAction(): Stage {
        return Stage(
            id = id,
            name = "${name} TEST ACTION",
            checklist = checklist
        )
    }
}