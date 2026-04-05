# 🛒 GrocerEase - Android Grocery App

## 📌 Overview

GrocerEase is an Android-based grocery management application designed to help users organize and manage their daily shopping items efficiently. The app allows users to add, update, and track grocery items with details such as quantity, unit (kg/liter), and price.

---

## 🚀 Features

* ➕ Add grocery items
* ✏️ Edit and update items
* ❌ Delete items
* 📊 Quantity management (kg / liter validation)
* 📱 Clean and user-friendly UI
* 🔄 RecyclerView for dynamic item display

---

## 🛠️ Tech Stack

* **Language:** Kotlin 
* **IDE:** Android Studio
* **UI Components:** XML, RecyclerView ,Scrollview
* **Architecture:** Basic Android Architecture

---

## 📂 Project Structure

```
GrocerEase/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/grocerease/
│   │   │   │
│   │   │   │── data/
│   │   │   │   ├── local/
│   │   │   │   │   ├── GroceryItems.kt
│   │   │   │   │   ├── GroceryDao.kt
│   │   │   │   │   └── GroceryDatabase.kt
│   │   │   │   │
│   │   │   │   └── repo/
│   │   │   │       └── GroceryRepository.kt
│   │   │   │
│   │   │   │── ui/
│   │   │   │   ├── GroceryAdapter.kt
│   │   │   │   ├── GroceryViewModel.kt
│   │   │   │   ├── GroceryItemDialog.kt
│   │   │   │   └── DialogListener.kt
│   │   │   │
│   │   │   │── MainActivity.kt
│   │   │
│   │   │── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── item_grocery.xml
│   │   │   │   └── grocerydialog.xml
│   │   │   │
│   │   │   ├── drawable/
│   │   │   │   ├── apple.jpg
│   │   │   │   ├── banana.jpg
│   │   │   │   ├── orange.jpg
│   │   │   │   ├── potato.jpg
│   │   │   │   └── vegetables.jpg
│   │   │   │
│   │   │   ├── mipmap/
│   │   │   │   ├── ic_launcher (all densities)
│   │   │   │   ├── ic_launcher_round
│   │   │   │   └── ic_launcher_foreground
│   │   │   │
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   │
│   │   │   └── xml/
│   │   │       ├── backup_rules.xml
│   │   │       └── data_extraction_rules.xml
│   │   │
│   │   │── AndroidManifest.xml
│   │
│   ├── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md
```

---

## 📸 Screenshots

<img width="959" height="563" alt="grocer_app" src="https://github.com/user-attachments/assets/c57b1456-0491-4231-97b6-3ec3acd3c295" />


---

## 🎥 Demo Video

[Click to watch demo](https://github.com/Hasti-gadara/GrocerEase/blob/main/grocery_app_record.mp4)

---

## ⚙️ Installation Steps

1. Clone the repository:

```
git clone https://github.com/your-username/grocerease.git
```

2. Open in Android Studio

3. Build the project

4. Run on Emulator / Device

---

## ✅ Input Validation

The app validates units to ensure correct input:

* Allowed units: **kg, kilogram, l, liter**

---

## 🎯 Purpose

This project demonstrates:

* Android UI design
* RecyclerView implementation
* Input validation
* Real-world app development basics

---

## 👩‍💻 Author

**Hasti Gadara**

---

## ⭐ Future Improvements

* Add database (Room / Firebase)
* Add user authentication
* Add price calculation & billing
* Improve UI/UX

