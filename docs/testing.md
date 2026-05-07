# Testing

## Testing Method
This project was tested manually using the Android emulator in Android Studio.

Since this version is a frontend-focused prototype, the main goal of testing was to check whether the screens worked correctly, navigation was smooth, and the main features behaved as expected.

---

## Main Test Cases

### 1. App Launch Test
- The app launches successfully in the emulator.
- The home screen appears without crashing.

### 2. Navigation Test
- The user can move from the home screen to the write screen.
- The user can move from the home screen to the diary list screen.
- The user can open the detail screen from the diary list.
- The user can return to previous screens using the provided buttons.
- The drawer menu opens and navigation through the menu works correctly.

### 3. Diary Entry Creation Test
- The user can type a title and content.
- The user can save a new diary entry.
- The saved diary entry appears in the diary list.

### 4. Diary Detail Test
- The user can open a diary entry from the list.
- The detail page correctly displays the title and content.

### 5. Search Test
- The search bar filters entries by title.
- The search bar filters entries by content.
- Entries that do not match the search input are hidden from the list.

### 6. Mood Tag Parsing Test
- If the user writes a tag such as `#mood:Happy`, the app correctly extracts the mood value.
- The detail page shows the mood separately.
- The main content is shown without the mood tag line.

### 7. Emoji Reaction Test
- The user can select an emoji reaction on the detail page.
- The selected emoji appears correctly as the saved reaction.

### 8. Temporary Diary Logic Test
- The user can turn on the temporary diary option.
- Temporary entries are labeled correctly.
- The expiration logic is implemented for 24-hour diary behavior.

### 9. Login and Add Friend Prototype Test
- The login prototype screen opens correctly.
- The add-friend prototype screen opens correctly.
- Username and partner name values can be updated in the UI.

---

## Test Result Summary

Overall, the main UI flow of the application works correctly for a prototype version.

The following features were successfully tested:
- screen navigation
- diary writing and saving
- diary list display
- detail page display
- search filtering
- mood tag parsing
- emoji reactions
- temporary diary logic
- login and add-friend prototype pages

---

## Known Limitations

This project is still a prototype, so some limitations remain:
- there is no real backend
- there is no real authentication
- there is no persistent database
- data is stored only during runtime
- login and add-friend are prototype UI screens only

Because of this, testing was focused mainly on frontend behavior and interaction flow.
