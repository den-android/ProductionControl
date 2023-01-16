package net.denis.productioncontrol.features.stage_checklist.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomRadioGroup(
    modifier: Modifier = Modifier,
    onRadioClicked: (Color) -> Unit
) {
    val radioOptions = listOf(Color.Green, Color.Yellow, Color.Red)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
    Column {
        radioOptions.forEach { color ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Row(
                    modifier = modifier
                        .fillMaxSize()
                        .background(color = color)
                        .selectable(
                            selected = (color == selectedOption),
                            onClick = {
                                onOptionSelected(color)
                                onRadioClicked(color)
                            }
                        )
                        .padding(horizontal = 16.dp),

                    ) {

                }
            }
        }
    }
}