# Testing

## Testing Method

This project was tested manually using the Android emulator in Android Studio.

Because this version is a frontend-focused prototype, the main goal of testing was to confirm that screen navigation, user input, and feature behavior worked as expected.

---

## Test Cases and Results

### 1. App Launch
- The app launched successfully in the emulator.
- The home screen appeared without crashing.

### 2. Screen Navigation
- The user could move from the home screen to the write screen.
- The user could move from the home screen to the diary list screen.
- The user could open the detail screen from the diary list.
- The drawer menu opened correctly and navigation through the menu worked.

### 3. Diary Entry Creation
- The user could type a title and content.
- Pressing the save button added a new diary entry.
- The new entry appeared in the diary list.

### 4. Diary Detail View
- A saved diary entry could be opened from the list.
- The detail page displayed the correct title and content.

### 5. Search Function
- Search input filtered entries by title.
- Search input filtered entries by content.
- Non-matching entries were hidden from the visible list.

### 6. Mood Tag Parsing
- When content included a tag such as `#mood:Happy`, the app extracted the mood value correctly.
- The mood tag was shown separately from the main content.
- The cleaned content appeared without the mood tag line.

### 7. Emoji Reaction
- Emoji reactions could be selected on the detail page.
- The selected reaction was saved and displayed correctly.

### 8. Temporary Diary Logic
- Temporary diary mode could be turned on when writing an entry.
- Temporary entries were labeled correctly.
- Expiration logic for 24-hour diary behavior was implemented in the UI flow.

### 9. Prototype Pages
- The login prototype page opened correctly.
- The add-friend prototype page opened correctly.
- Username and partner name values could be updated in the interface.

---

## Test Result Summary

Overall, the main UI flow of the application worked correctly for a prototype version.

The following features worked successfully during testing:
- app launch
- screen navigation
- diary writing and saving
- diary list display
- diary detail display
- search filtering
- mood tag parsing
- emoji reactions
- temporary diary logic
- login and add-friend prototype pages

---

## Known Limitations

The current version still has the following limitations:

- no real backend
- no real authentication
- no persistent database
- no actual syncing between users
- login and add-friend are UI prototypes only
- data is stored only during runtime

Because of this, testing focused mainly on frontend behavior and interaction flow rather than full system integration.
