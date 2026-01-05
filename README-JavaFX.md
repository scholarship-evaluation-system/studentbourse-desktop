# StudentBourse JavaFX Conversion

This folder contains JavaFX versions of the StudentBourse HTML/CSS pages.

## Structure

### Dashboard (Evaluator_page/studentbourse JavaFx/)
- **StudentBourseDashboard.fxml** - UI layout (replaces HTML)
- **studentbourse.css** - JavaFX CSS styling
- **DashboardController.java** - Logic and event handling
- **DashboardApp.java** - Main application launcher

### Login (Login page/login JavaFx/)
- **Login.fxml** - UI layout (replaces HTML)
- **login.css** - JavaFX CSS styling
- **LoginController.java** - Logic and event handling
- **LoginApp.java** - Main application launcher

## Key Differences from HTML/CSS

### Layout Components
| HTML | JavaFX |
|------|--------|
| `<div>` | VBox, HBox, StackPane |
| flexbox | HBox/VBox with spacing |
| grid | GridPane |
| `<input>` | TextField |
| `<select>` | ComboBox |
| `<button>` | Button |

### CSS Properties
| Web CSS | JavaFX CSS |
|---------|-----------|
| `background` | `-fx-background-color` |
| `color` | `-fx-text-fill` |
| `padding` | `-fx-padding` |
| `margin` | Use Insets |
| `font-size` | `-fx-font-size` |
| `border` | `-fx-border-color`, `-fx-border-width` |

### Event Handling
- HTML: JavaScript event handlers
- JavaFX: Java methods with `@FXML` annotation

### Charts
- HTML: Chart.js library
- JavaFX: Built-in JavaFX Charts (BarChart, PieChart, LineChart)

## Running the Applications

### Prerequisites
- Java JDK 11 or higher
- JavaFX SDK (if not included in JDK)

### Compile and Run
```bash
# Dashboard
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml DashboardApp.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml DashboardApp

# Login
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml LoginApp.java
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml LoginApp
```

### Using an IDE (IntelliJ IDEA / Eclipse)
1. Import the project
2. Configure JavaFX library
3. Run DashboardApp.java or LoginApp.java

## Package Structure
All Java files should be in package: `com.studentbourse`

```
src/
  com/
    studentbourse/
      DashboardApp.java
      DashboardController.java
      LoginApp.java
      LoginController.java
      StudentBourseDashboard.fxml
      Login.fxml
      studentbourse.css
      login.css
```

## Features Implemented

### Dashboard
- ✅ Header with logo and icons
- ✅ Sidebar navigation menu
- ✅ University and semester dropdowns
- ✅ Search functionality
- ✅ Statistics cards with progress bars
- ✅ Bar chart for student data
- ✅ Action cards
- ✅ Footer

### Login
- ✅ Header with logo
- ✅ Tab navigation (Create Account / Login)
- ✅ Email and password fields
- ✅ Form validation
- ✅ Login button with hover effects

## Notes
- The FXML files define the UI structure
- CSS files provide styling (similar to web CSS but with `-fx-` prefix)
- Controller files handle all logic and user interactions
- App files are entry points that launch the application
- Icons and images need to be placed in the correct relative paths
