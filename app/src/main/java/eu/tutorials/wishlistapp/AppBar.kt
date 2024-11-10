package eu.tutorials.wishlistapp

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import eu.tutorials.wishlistapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(title: String, onBackNavClicked: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(text = title, color = colorResource(id = R.color.white))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.app_bar_color),
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back"
                )
            }
        }
    )
}
