package net.denis.productioncontrol.presentation.screen.components

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants

@Composable
fun RadioGroup(
    onRadioClick:(Color) -> Unit
) {
    val radioOptions = listOf(Color.Green, Color.Yellow, Color.Red)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
    Column {
        radioOptions.forEach { color ->
            Box(modifier = Modifier.weight(1f).fillMaxSize()) {
            Row(
                Modifier
                    .fillMaxSize()
                    .background(color = color)
                    .selectable(
                        selected = (color == selectedOption),
                        onClick = { onOptionSelected(color) }
                    )
                    .padding(horizontal = 16.dp),

            ) {
                    RadioButton(
                        selected = (color == selectedOption),
                        modifier = Modifier.padding(all = Dp(value = 8F)),
                        onClick = {
                            onOptionSelected(color)
                            onRadioClick(color)
                        }
                    )
                }
            }
        }
    }
}

//
//@Composable
//fun SelectOptionsCheckout(
//    index: Int,
//    text: String,
//    isSelectedOption: Boolean,
//    onSelectOption: (Int) -> Unit
//) {
//
//    Column() {
//        RadioButton(
//            selected = false,
//            onClick = { isSelectedOption },
//            modifier = Modifier
//                .clickable {
//                    onSelectOption(index)
//                }
//        )
//    }
//}
//
//@Composable
//fun RadioGroup() {
//    val radioOptions = listOf("Green", "Yellow", "Red")
//
//    val (selectedOption: Int, onOptionSelected: (Int) -> Unit) = remember {
//        mutableStateOf(
//            -1
//        )
//    }
//
//    Row(Modifier.selectableGroup()) {
//        radioOptions.forEachIndexed { index, text ->
//            SelectOptionsCheckout(
//                index = index,
//                text = text,
//                isSelectedOption = selectedOption == index,
//                onSelectOption = {
//                    if (it == selectedOption) {
//                        onOptionSelected(-1)
//                    } else {
//                        onOptionSelected(it)
//                    }
//                }
//            )
//        }
//    }
//}