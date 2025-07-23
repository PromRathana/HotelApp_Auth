Hotel App
This is an Android application designed to provide user authentication (login, registration, logout) and display a list of categories, likely for hotel-related services or rooms.

Features
User Registration: Allows new users to create an account with details such as first name, last name, username, email, phone, and password.

User Login: Enables existing users to log in using their username and password.

User Logout: Provides functionality for authenticated users to log out of their session.

Category Listing: Displays a list of categories (e.g., room types, hotel services).

Local User Data Storage: Stores user session data locally for persistence.

Technologies Used
Android SDK: Core framework for building Android applications.

Java: The primary programming language used for the application logic.

AndroidX Libraries: Modern Android support libraries for backward compatibility and new features (e.g., AppCompatActivity, EdgeToEdge).

Retrofit (Implied): Used for making network requests to the backend API (via AuthRepository and ApiCallbackResponse).

Progress Bar: Visual feedback for ongoing operations.

Toast Messages: Simple, short-lived messages for user feedback.

Dependencies
The following key dependencies are used in this project:

appcompat: Provides backward-compatible versions of Android framework APIs.

material: Implements Material Design components and themes.

gson: A Java serialization/deserialization library to convert Java Objects into JSON and vice-versa.

converter-gson: A Retrofit converter for Gson.

logging-interceptor: An OkHttp interceptor that logs HTTP request and response data.

okhttp: An HTTP client for Android and Java applications.

retrofit: A type-safe HTTP client for Android and Java.

activity: Provides components for managing activity lifecycle and interactions.

constraintlayout: Allows you to create large and complex layouts with a flat view hierarchy.

junit: A unit testing framework for Java.

ext.junit: JUnit extensions for AndroidX Test.

espresso.core: A testing framework for Android UI tests.

Setup and Installation
To get this project up and running on your local machine, follow these steps:

Clone the Repository:

git clone <repository_url>


(Replace <repository_url> with the actual URL of your Git repository.)

Open in Android Studio:

Launch Android Studio.

Select File > Open or Open an Existing Android Studio Project.

Navigate to the cloned project directory and select it.

Sync Gradle:

Android Studio will automatically try to sync the Gradle project. If it doesn't, click File > Sync Project with Gradle Files.

Install Dependencies:

Ensure all necessary dependencies are downloaded. Android Studio should handle this automatically during Gradle sync.

Configure Backend API (if applicable):

This application relies on a backend API for authentication and data. You will need to ensure your AuthRepository is correctly configured to point to your API endpoints.

Check for any API base URLs or configuration files within the network or data/remote packages that might need updating.

Run on a Device or Emulator:

Connect an Android device to your computer with USB debugging enabled, or set up an Android Emulator.

Click the Run button (green triangle) in Android Studio to deploy the app to your chosen device/emulator.

Usage
Registration
From the Login screen, click the "Register" button.

Fill in all the required details (First Name, Last Name, Username, Email, Phone, Password, Confirm Password).

Ensure the password and confirm password fields match.

Click the "Register" button to create your account. A toast message will indicate success or failure.

Upon successful registration, you will be returned to the Login screen.

Login
On the Login screen, enter your registered username and password.

Click the "Login" button.

A progress bar will appear during the login process.

Upon successful login, you will be navigated to the MainActivity (where categories are likely listed).

Logout
(Based on the provided code, the logout functionality is not explicitly shown but would typically be implemented in MainActivity or a similar main screen). Once logged in, there should be a "Logout" option (e.g., a button, menu item) that, when clicked, clears local user data and returns to the LoginActivity.

Viewing Categories
After successful login, the application navigates to MainActivity. This is where the list of categories is expected to be displayed.

Project Structure (Relevant Files)
activities/LoginActivity.java: Handles user login and navigation to registration/main activity.

activities/RegisterActivity.java: Manages user registration.

data/local/UserLocalData.java: Handles local storage of user session data.

data/remote/repositories/AuthRepository.java: Manages API calls related to authentication (login, register).

network/ApiCallbackResponse.java: Interface for handling API response callbacks (loading, success, error).

utils/MessageUtils.java: Utility class for displaying toast messages.

res/layout/activity_login.xml: Layout file for the login screen.

res/layout/activity_register.xml: Layout file for the registration screen.
