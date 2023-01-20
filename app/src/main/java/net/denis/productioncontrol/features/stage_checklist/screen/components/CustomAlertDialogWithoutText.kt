package net.denis.productioncontrol.features.stage_checklist.screen.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomAlertDialogWithoutText(
    onDialogDismissClick: () -> Unit,
    onDialogOkClick: () -> Unit,
) {
    AlertDialog(onDismissRequest = { },
        confirmButton = {
            Button(
                onClick = { onDialogOkClick() },
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