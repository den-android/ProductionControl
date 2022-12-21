package net.denis.productioncontrol.presentation.screen.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CardItem(

) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Box {
            Text(
                text = "123",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "123",
                overflow = TextOverflow.Ellipsis,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                Toast.makeText(context, "123", Toast.LENGTH_SHORT).show()
            }) {}
            Text("Unchecked")
        }
    }
}
