# Exchange Diary

> Note: Some parts of this write-up may sound a little awkward because I used a translator to help with some of the English.

## Index
- [Project Summary](#project-summary)
- [Project Goals](#project-goals)
- [Main Features](#main-features)
- [Computer Science Concepts Used](#computer-science-concepts-used)
- [Tech Stack](#tech-stack)


---

## Project Summary

**Exchange Diary** is an Android shared diary prototype for two users.  
I wanted to make an app that feels more personal than a basic notes app, so I focused on the idea of a shared diary where one user can write entries, look back at old entries, react to them, and organize them in a simple but interactive way.

This project includes features such as writing diary entries, viewing saved entries in a list, opening detail pages, searching through entries, parsing mood tags like `#mood:Happy`, adding emoji reactions, and using temporary diary logic for entries that disappear after 24 hours.

I made this project as a senior-level computer science project to show not only app development, but also code organization, user interaction, data handling, and parsing concepts in a realistic Android application setting.

This version is still a prototype, so it does not include a real backend or persistent database yet. However, it still demonstrates the overall design and main behavior of the app clearly.

---

## Project Goals

The goal of this project was to build a shared diary application prototype that feels more personal and interactive than a simple note-taking app.

I also wanted this project to demonstrate:
- Android UI design using Jetpack Compose
- organized file and package structure
- user input handling
- navigation between screens
- search and filtering logic
- parsing structured tags from diary text
- shared diary interaction ideas such as reactions and partner information

---

## Main Features

- Write diary entries
- View saved entries in a shared diary list
- Open a diary detail screen
- Search diary entries by title or content
- Parse mood tags such as `#mood:Happy`
- Show cleaned diary content separately from parsed tags
- Add emoji reactions to entries
- Mark entries as temporary with 24-hour expiration logic
- Open prototype login and add-friend pages
- Use a slide-out drawer menu for navigation
- Display partner-oriented UI text such as partner name and shared diary labels

---

## Computer Science Concepts Used

### Iterative Programming
Iteration is used when processing diary entries, filtering lists, searching through saved data, and checking text line by line for tags.

### Object-Oriented Programming
The project uses structured Kotlin files and a `DiaryEntry` data class to organize diary data clearly.

### Data Structures
The main data structure used in this project is a list of diary entries. Filtered lists are also used for searching and for showing only valid entries.

### Algorithms
This project includes:
- search filtering by title and content
- temporary diary expiration logic
- emoji reaction updating
- mood tag parsing from entry content

### Software Engineering
This project uses:
- organized file and package structure
- reusable UI components
- feature-based screen separation
- GitHub repository organization
- readable naming and consistent coding practices

### OS Concepts
This app was developed and tested in the Android environment, so it involves app execution, UI rendering, navigation flow, and emulator-based testing.

### Parsing / Computer Theory Concept
One of the main computer science concepts used in this project is simple parsing.  
The app checks diary content for structured text such as `#mood:Happy`, extracts the mood value, and separates it from the main diary text.

---

## Tech Stack

- **Language:** Kotlin
- **Platform:** Android
- **IDE:** Android Studio
- **UI Framework:** Jetpack Compose

