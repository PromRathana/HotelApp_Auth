# 🏨 Hotel App - Android Application

This Android application provides a simple and intuitive user experience for managing hotel-related user accounts and browsing service categories such as room types or amenities. The app includes user registration, login/logout functionality, and category listing with persistent local session storage.

---

## ✨ Features

- **👤 User Registration**
  - Collects: First Name, Last Name, Username, Email, Phone, and Password
  - Validates password and confirmation match

- **🔐 User Login**
  - Secure login using username and password
  - Displays feedback using progress bar and toast messages

- **🚪 User Logout**
  - Clears local user session data
  - Returns user to the login screen

- **📋 Category Listing**
  - Displays available hotel services or room categories
  - Accessible after successful login

- **💾 Local User Data Storage**
  - Persists login session using local storage

---

## 🛠️ Technologies Used

| Technology        | Purpose                                                   |
|-------------------|------------------------------------------------------------|
| **Android SDK**   | Core framework for building Android apps                   |
| **Java**          | Primary language for app development                       |
| **AndroidX**      | Modern libraries for compatibility and advanced features   |
| **Retrofit**      | HTTP client for networking (used in `AuthRepository`)      |
| **OkHttp**        | Handles network requests with logging support              |
| **Gson**          | JSON parsing/serialization                                 |
| **Material Design** | UI components and design system                          |
| **JUnit & Espresso** | Testing frameworks for unit and UI testing             |

---

## 📦 Dependencies

```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:okhttp:4.11.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.11.0'
    implementation 'androidx.activity:activity:1.7.2'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'

    // Testing
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```
## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/PromRathana/HotelApp_Auth.git
```
### 2. Open the Project in Android Studio
- Launch Android Studio
- Select File > Open and choose the cloned project directory
### 3. Sync and Install Dependencies
- Android Studio will try to sync the Gradle project automatically.
- If it doesn’t, go to File > Sync Project with Gradle Files
### 4. Configure Backend API
- Open AuthRepository.java or relevant configuration file
- Set your API base URL (make sure your backend is running and accessible)
### 5. Run the App
- Connect your Android device (with USB debugging enabled) or use an emulator
- Click the green Run ▶️ button in Android Studio to install and launch the app
## 📱 Usage
### 🔑 Register
- Open the app and tap "Register"
- Enter all required fields
- Tap "Register" to create your account
- Upon success, you’ll be redirected to the login screen
### 🔐 Login
- Enter your username and password
- Tap "Login"
- On success, you will be taken to the MainActivity where categories are shown
### 🚪 Logout
- After logging in, use the provided Logout mechanism (button or menu)
- This will clear stored session data and return you to the login screen
### 📋 View Categories
- Once logged in, you will see a list of hotel service categories in MainActivity
- Categories may include room types, services, or other offerings

