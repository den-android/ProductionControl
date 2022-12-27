package net.denis.productioncontrol.presentation.screen.components

import android.widget.RadioGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun SelectOptionsCheckout(
    index: Int,
    text: String,
    isSelectedOption: Boolean,
    onSelectOption: (Int) -> Unit
) {

    Column() {
        Checkbox(
            checked = false,
            colors = CheckboxDefaults.colors(Color.Red),
            onCheckedChange = { isSelectedOption },
            modifier = Modifier
                .clickable {
                    onSelectOption(index)
                }
        )
    }
}

@Composable
fun RadioGroup() {
    val radioOptions = listOf("Green", "Yellow", "Red")

    val (selectedOption: Int, onOptionSelected: (Int) -> Unit) = remember {
        mutableStateOf(
            -1
        )
    }

    Row(Modifier.selectableGroup()) {
        radioOptions.forEachIndexed { index, text ->
            SelectOptionsCheckout(
                index = index,
                text = text,
                isSelectedOption = selectedOption == index,
                onSelectOption = {
                    if (it == selectedOption) {
                        onOptionSelected(-1)
                    } else {
                        onOptionSelected(it)
                    }
                }
            )
        }
    }
}