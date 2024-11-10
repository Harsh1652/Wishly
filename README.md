# Wishly

Wishly is an Android application built using Jetpack Compose and Room Database. It allows users to add, update, and delete wish items with a simple and modern UI. The app also features swipe-to-delete functionality for easy removal of items from the wish list.

Table of Contents
1) Features
2) Screenshots
3) Architecture
4) Technologies Used
5) Installation
6) Usage
7) Future Improvements
8) Contributing

Features
1) Add a new wish with a title and description.
2) Update existing wishes.
3) Swipe left to delete a wish.
4) View a list of all added wishes.
5) Simple and clean user interface using Material Design 3.

Screenshots

1) Home Screen

The Home screen displays a list of all wishes. Users can add new wishes using the floating action button.

![image](https://github.com/user-attachments/assets/d35110b8-0d00-41fd-ae1a-13e1ce1b2a41)


2) Add/Edit Wish Screen

The Add/Edit screen allows users to add a new wish or update an existing one.

![image](https://github.com/user-attachments/assets/564073ae-04b1-4103-adec-4fc3ffbedc2c)


Architecture
The project follows the MVVM (Model-View-ViewModel) architecture:

Model: Defines the data structure (Wish.kt) and the database access layer using Room (WishDao.kt).

ViewModel: Handles business logic and provides data to the UI (WishViewModel.kt).

View: Uses Jetpack Compose for creating UI components (HomeView.kt, AddEditDetailView.kt).

Technologies Used
1) Kotlin: Programming language.
2) Jetpack Compose: Modern toolkit for building native Android UI.
3) Room Database: Local database for persistent storage.
4) Coroutines: For asynchronous operations.
5) Material Design 3: For UI components and theming.
6) Navigation Component: For handling navigation between screens.
7) Installation

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
1) Launch the app on your Android device.
2) Tap the + button on the Home screen to add a new wish.
3) Enter the title and description of the wish and tap "Add Wish".
4) Swipe left on a wish item to delete it.
5) Tap on a wish item to update its title or description.

Key Files
1) Wish.kt: Data model for wish items.
2) WishDao.kt: DAO interface for accessing the Room database.
3) WishDatabase.kt: Room database setup.
4) WishRepository.kt: Repository for handling data operations.
5) WishViewModel.kt: ViewModel for managing UI-related data.
6) HomeView.kt: Main screen displaying the list of wishes.
7) AddEditDetailView.kt: Screen for adding or editing a wish.
8) Navigation.kt: Manages navigation between screens.
9) Dependencies
Ensure the following dependencies are added in your build.gradle file:

gradle

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
1) Add a search feature to filter wish items.
2) Implement undo functionality for deleted wishes.
3) Add persistent storage for app settings.
4) Include synchronization with a remote server.

Contributing: 

    Contributions are welcome! If you find any issues or have suggestions, please open an issue or submit a pull request.

