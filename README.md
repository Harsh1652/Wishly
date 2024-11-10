# Wishly

Wishly is an Android application built using Jetpack Compose and Room Database. It allows users to add, update, and delete wish items with a simple and modern UI. The app also features swipe-to-delete functionality for easy removal of items from the wish list.

Table of Contents
Features
Screenshots
Architecture
Technologies Used
Installation
Usage
Future Improvements
Contributing

Features
Add a new wish with a title and description.
Update existing wishes.
Swipe left to delete a wish.
View a list of all added wishes.
Simple and clean user interface using Material Design 3.

Screenshots

Home Screen

The Home screen displays a list of all wishes. Users can add new wishes using the floating action button.

![image](https://github.com/user-attachments/assets/d35110b8-0d00-41fd-ae1a-13e1ce1b2a41)


Add/Edit Wish Screen

The Add/Edit screen allows users to add a new wish or update an existing one.

![image](https://github.com/user-attachments/assets/564073ae-04b1-4103-adec-4fc3ffbedc2c)


Architecture
The project follows the MVVM (Model-View-ViewModel) architecture:

Model: Defines the data structure (Wish.kt) and the database access layer using Room (WishDao.kt).

ViewModel: Handles business logic and provides data to the UI (WishViewModel.kt).

View: Uses Jetpack Compose for creating UI components (HomeView.kt, AddEditDetailView.kt).

Technologies Used
Kotlin: Programming language.
Jetpack Compose: Modern toolkit for building native Android UI.
Room Database: Local database for persistent storage.
Coroutines: For asynchronous operations.
Material Design 3: For UI components and theming.
Navigation Component: For handling navigation between screens.
Installation

To run this project, follow these steps:

Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/Wishly.git
cd Wishly
Open the project in Android Studio.

Sync the project with Gradle files.

Build and run the application on an Android device or emulator.

Usage
Launch the app on your Android device.
Tap the + button on the Home screen to add a new wish.
Enter the title and description of the wish and tap "Add Wish".
Swipe left on a wish item to delete it.
Tap on a wish item to update its title or description.

Key Files
Wish.kt: Data model for wish items.
WishDao.kt: DAO interface for accessing the Room database.
WishDatabase.kt: Room database setup.
WishRepository.kt: Repository for handling data operations.
WishViewModel.kt: ViewModel for managing UI-related data.
HomeView.kt: Main screen displaying the list of wishes.
AddEditDetailView.kt: Screen for adding or editing a wish.
Navigation.kt: Manages navigation between screens.
Dependencies
Ensure the following dependencies are added in your build.gradle file:

gradle
Copy code
dependencies {
    implementation "androidx.room:room-runtime:2.5.0"
    kapt "androidx.room:room-compiler:2.5.0"
    implementation "androidx.room:room-ktx:2.5.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"
    implementation "androidx.compose.ui:ui:1.5.0"
    implementation "androidx.compose.material3:material3:1.2.0"
    implementation "androidx.navigation:navigation-compose:2.6.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1"
}
Future Improvements
Add a search feature to filter wish items.
Implement undo functionality for deleted wishes.
Add persistent storage for app settings.
Include synchronization with a remote server.

Contributing
Contributions are welcome! If you find any issues or have suggestions, please open an issue or submit a pull request.

