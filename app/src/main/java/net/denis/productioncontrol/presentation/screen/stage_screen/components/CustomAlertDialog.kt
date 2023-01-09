package net.denis.productioncontrol.presentation.screen.stage_screen.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomAlertDialog(
    onDialogDismissClick: () -> Unit,
    onDialogOkClick: (String) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    AlertDialog(onDismissRequest = { },
        text = {
            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Blue,
                    disabledIndicatorColor = Color.Blue,
                    unfocusedIndicatorColor = Color.Blue,
                    backgroundColor = Color.LightGray,
                )
            )
        },
        confirmButton = {
            Button(
                onClick = { onDialogOkClick(text) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(text = "Ok", style = TextStyle(color = Color.White, fontSize = 12.sp))
            }
        }, dismissButton = {
            Button(
                onClick = onDialogDismissClick,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(text = "Cancel", style = TextStyle(color = Color.White, fontSize = 12.sp))
            }
        }
    )
}