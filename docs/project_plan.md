# Project Plan

## Project Idea

For this project, I decided to create **Exchange Diary**, which is an Android shared diary prototype for two users.

I wanted to make something more personal than a simple memo app. Instead of only saving notes, this app was designed to feel like a small shared space where users can write entries, react to them, and keep memories together.

I thought this idea fit the project well because it allowed me to combine UI design, screen navigation, data handling, parsing, and interactive features in one application.

---

## Project Goals

The main goals of this project were:

- build a working Android application prototype
- create a shared diary experience rather than a basic notes app
- organize the code in a readable and modular way
- include interactive features beyond simple writing and viewing
- demonstrate computer science concepts such as parsing, filtering, and structured data handling

---

## Design Overview

The app is organized into several main screens:

- **Home Screen**  
  The starting page of the app. It introduces the app and shows the current user and partner information.

- **Write Screen**  
  This screen allows the user to write a diary title and content. It also includes a temporary diary option.

- **Diary List Screen**  
  This screen displays saved diary entries and allows the user to search through them.

- **Diary Detail Screen**  
  This screen shows one selected diary entry in more detail and allows emoji reactions.

- **Login Screen**  
  A prototype screen used to show what login could look like in a more complete version of the app.

- **Add Friend Screen**  
  A prototype screen used to show how partner connection could be handled in a fuller version of the project.

- **Drawer Menu**  
  A slide-out navigation menu used to move between the main screens.

---

## Main Features

The project currently includes the following features:

- writing diary entries
- viewing saved diary entries
- opening a detail page for each entry
- searching entries by title or content
- parsing mood tags such as `#mood:Happy`
- showing cleaned content separately from parsed tags
- adding emoji reactions
- temporary diary logic using 24-hour expiration behavior
- prototype login and add-friend pages
- drawer-based navigation
- partner-oriented labels and shared diary text

---

## Computer Science Concepts Used

### Object-Oriented Programming
The project uses structured Kotlin files and a `DiaryEntry` data class to model diary information.

### Data Structures
The main structure used in the project is a list of diary entries. Filtered lists are also used for searching and displaying specific entries.

### Iterative Programming
Iteration is used when processing diary entries, checking content line by line, and filtering lists.

### Algorithms
This project includes:
- search filtering
- mood tag extraction
- temporary entry expiration logic
- emoji reaction updating

### Parsing
A simple parsing concept is used to detect tags such as `#mood:Happy` in diary content. The app extracts the mood value and separates it from the main text.

### Software Engineering
The project was organized by screens, components, and model files to keep the code easier to read and maintain.

### OS Concepts
The application was built and tested in the Android environment using Android Studio and an emulator.

---

## Development Process

### Stage 1
I created the Android project and set up the basic app structure.

### Stage 2
I built the main screens and connected them through navigation.

### Stage 3
I added diary writing, saving, and list display functionality.

### Stage 4
I added search and mood tag parsing.

### Stage 5
I added emoji reactions and temporary diary logic.

### Stage 6
I added prototype login and add-friend pages to make the app feel closer to a shared diary application.

### Stage 7
I improved the user interface using a softer color palette, a drawer menu, and profile-related UI elements.

---

## Current Limitations

This project is still a prototype, so there are some limitations:

- no real backend
- no real authentication
- no real user-to-user syncing
- no persistent database
- login and add-friend are prototype pages only
- diary data is stored only during runtime

Even with these limitations, the project still demonstrates the intended design and overall feature flow clearly.

---

## Final Notes

This project is not a full production app yet, but it works well as a frontend-focused prototype and demonstrates many of the ideas I originally planned.

If I continue working on it in the future, I would like to add real authentication, a database, and actual syncing between users.
