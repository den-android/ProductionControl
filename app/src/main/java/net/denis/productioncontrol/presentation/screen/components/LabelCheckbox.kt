package net.denis.productioncontrol.presentation.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.denis.productioncontrol.presentation.state.CarListState

@Composable
fun LabelCheckbox(
    state: CarListState,
    onCheck:() -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {

        Checkbox(
            checked = state.isChecked,
            onCheckedChange = {onCheck()},
            enabled = true,
            colors = CheckboxDefaults.colors(Color.Green)
        )
        Text(text = "Просмотренно")
    }
}