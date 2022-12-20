package net.denis.productioncontrol.presentation.screen.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import net.denis.productioncontrol.domain.model.Car

@Composable
fun CarCardItem(
    car: Car,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Box {
            Text(
                text = car.name,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = car.model,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                Toast.makeText(context, car.model, Toast.LENGTH_SHORT).show()
            }) {}
            Text("Unchecked")
        }
    }
}
