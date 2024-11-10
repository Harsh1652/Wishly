package eu.tutorials.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.tutorials.wishlistapp.data.Wish
import androidx.compose.runtime.remember
import androidx.compose.material3.*
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.rememberDismissState
import androidx.compose.ui.Alignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val wishlist = viewModel.getAllWishes.collectAsState(initial = emptyList())

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = { AppBarView(title = "Wishly") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddScreen.route + "/0") },
                containerColor = Color.Black,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(wishlist.value, key = { it.id }) { wish ->
                WishItem(
                    wish = wish,
                    onClick = { navController.navigate(Screen.AddScreen.route + "/${wish.id}") },
                    onDelete = { viewModel.deleteWish(it) }
                )
            }
        }
    }
}




@Composable
fun WishItem(
    wish: Wish,
    onClick: () -> Unit,
    onDelete: (Wish) -> Unit
) {
    val dismissState = rememberDismissState()

    // Check if the item was swiped to the end (delete action)
    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
        onDelete(wish)
    }

    SwipeToDismiss(
        state = dismissState,
        background = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete",
                    tint = Color.Red
                )
            }
        },
        directions = setOf(DismissDirection.EndToStart),
        dismissContent = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onClick() },
                elevation = CardDefaults.elevatedCardElevation(10.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = wish.title)
                    Text(text = wish.description)
                }
            }
        }
    )
}

