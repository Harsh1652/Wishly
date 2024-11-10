package eu.tutorials.wishlistapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.tutorials.wishlistapp.data.Wish
import eu.tutorials.wishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch


class WishViewModel(private val wishRepository: WishRepository) : ViewModel() {

    var wishTitleState = mutableStateOf("")
    var wishDescriptionState = mutableStateOf("")

    // Fetch data from the repository
    val getAllWishes: Flow<List<Wish>> = wishRepository.getWishes()

    fun onWishTitleChanged(newTitle: String) {
        wishTitleState.value = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String) {
        wishDescriptionState.value = newDescription
    }

    fun addWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishRepository.addAWish(wish)
    }

    fun getAWishById(id: Long): Flow<Wish> = wishRepository.getAWishById(id)

    fun updateWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishRepository.updateAWish(wish)
    }

    fun deleteWish(wish: Wish) = viewModelScope.launch(Dispatchers.IO) {
        wishRepository.deleteAWish(wish)
    }
}
