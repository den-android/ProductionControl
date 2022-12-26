package net.denis.productioncontrol.presentation.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import net.denis.productioncontrol.domain.model.Stage

@Composable
fun CardItem(
 //   checklist: Checklist,
    stage: Stage,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Box {
            Text(
                text = "${stage.id}",
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "${stage.name}",
                overflow = TextOverflow.Ellipsis,
            )
//            Text(
//                text = "${checklist.id}",
//                overflow = TextOverflow.Ellipsis,
//            )
//            Text(
//                text = "${checklist.name}",
//                overflow = TextOverflow.Ellipsis,
//            )
        }

    }
}
