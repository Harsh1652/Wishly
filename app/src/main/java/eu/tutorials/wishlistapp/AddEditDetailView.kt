// AddEditDetailView.kt
package eu.tutorials.wishlistapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.tutorials.wishlistapp.data.Wish
import eu.tutorials.wishlistapp.R
import kotlinx.coroutines.launch
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.rememberSnackbarHostState



@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val wishState by viewModel.getAWishById(id).collectAsState(initial = Wish(0L, "", ""))

    if (id != 0L && wishState.id != 0L) {
        viewModel.onWishTitleChanged(wishState.title)
        viewModel.onWishDescriptionChanged(wishState.description)
    }

    Scaffold(
        topBar = {
            AppBarView(
                title = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(id = R.string.add_wish),
                onBackNavClicked = { navController.navigateUp() }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WishTextField(
                label = "Title",
                value = viewModel.wishTitleState.value,
                onValueChanged = { viewModel.onWishTitleChanged(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            WishTextField(
                label = "Description",
                value = viewModel.wishDescriptionState.value,
                onValueChanged = { viewModel.onWishDescriptionChanged(it) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                if (viewModel.wishTitleState.value.isNotEmpty() && viewModel.wishDescriptionState.value.isNotEmpty()) {
                    if (id != 0L) {
                        viewModel.updateWish(Wish(id, viewModel.wishTitleState.value.trim(), viewModel.wishDescriptionState.value.trim()))
                    } else {
                        viewModel.addWish(Wish(title = viewModel.wishTitleState.value.trim(), description = viewModel.wishDescriptionState.value.trim()))
                        snackMessage.value = "Wish has been created"
                    }
                } else {
                    snackMessage.value = "Please enter both title and description"
                }
                scope.launch {
                    snackbarHostState.showSnackbar(snackMessage.value)
                    navController.navigateUp()
                }
            }) {
                Text(
                    text = if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(id = R.string.add_wish),
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            focusedBorderColor = colorResource(id = R.color.black),
            unfocusedBorderColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            focusedTextColor = Color.Black,       // For focused text color
            unfocusedTextColor = Color.Black      // For unfocused text color
        )
    )

}
