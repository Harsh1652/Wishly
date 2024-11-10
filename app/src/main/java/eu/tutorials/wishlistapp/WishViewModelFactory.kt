package eu.tutorials.wishlistapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.tutorials.wishlistapp.WishViewModel
import eu.tutorials.wishlistapp.data.WishRepository

class WishViewModelFactory(private val repository: WishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WishViewModel::class.java)) {
            return WishViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
