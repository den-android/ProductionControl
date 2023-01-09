package net.denis.productioncontrol.presentation.screen.stage_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
            Box(modifier = modifier
                .fillMaxSize()
                .weight(1f)) {
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
@Preview(showBackground = true)
@Composable
fun testradio(){
    CustomRadioGroup(onRadioClicked = {})
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