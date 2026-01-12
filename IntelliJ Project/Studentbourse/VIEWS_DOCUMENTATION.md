# StudentBourse - Documentación de Vistas

## Resumen

Todas las páginas HTML han sido convertidas a FXML con sus respectivos Controllers y CSS adaptados para JavaFX.

## Vistas Implementadas

### 1. **Cover Page** (Página de Inicio)
- **FXML:** `fxml/cover-page.fxml`
- **Controller:** `CoverPageController.java`
- **CSS:** `css/cover-page.css`
- **Descripción:** Página de bienvenida con logo y acceso inicial

### 2. **Role Selection** (Selección de Rol)
- **FXML:** `fxml/role-selection.fxml`
- **Controller:** `RoleSelectionController.java`
- **CSS:** `css/role-selection.css`
- **Descripción:** Permite al usuario elegir entre Student o Evaluator
- **Navegación:** 
  - Student → Student Login
  - Evaluator → Evaluator Login

### 3. **Student Login**
- **FXML:** `fxml/student-login.fxml`
- **Controller:** `StudentLoginController.java`
- **CSS:** `css/student-login.css`
- **Descripción:** Formulario de login para estudiantes
- **Navegación:**
  - "Log In" → Student Dashboard
  - "Create an account" → Create Account Student

### 4. **Evaluator Login**
- **FXML:** `fxml/evaluator-login.fxml`
- **Controller:** `EvaluatorLoginController.java`
- **CSS:** `css/evaluator-login.css`
- **Descripción:** Formulario de login para evaluadores
- **Navegación:**
  - "Log In" → Evaluator Dashboard
  - "Create an account" → Create Account Evaluator

### 5. **Student Dashboard**
- **FXML:** `fxml/student-dashboard.fxml`
- **Controller:** `StudentDashboardController.java`
- **CSS:** `css/student-dashboard.css`
- **Descripción:** Panel principal del estudiante con estadísticas de becas
- **Características:**
  - Selector de semestre
  - Menú lateral (Matches, Recommended, Picked, In Process, Submitted)
  - Tarjetas de estadísticas con progreso
  - Lista de becas
- **Navegación:**
  - "Matches" → Scholarship Matches

### 6. **Scholarship Matches**
- **FXML:** `fxml/scholarship-matches.fxml`
- **Controller:** `ScholarshipMatchesController.java`
- **CSS:** `css/scholarship-matches.css`
- **Descripción:** Lista de becas que coinciden con el perfil del estudiante
- **Características:**
  - Buscador
  - Tarjetas de becas con información detallada
  - Filtros por categoría
  - Menú lateral de navegación

### 7. **Evaluator Dashboard**
- **FXML:** `fxml/evaluator-dashboard.fxml`
- **Controller:** `EvaluatorDashboardController.java`
- **CSS:** `css/evaluator-dashboard.css`
- **Descripción:** Panel principal del evaluador

### 8. **Evaluator Applications**
- **FXML:** `fxml/evaluator-applications.fxml`
- **Controller:** `EvaluatorApplicationsController.java`
- **CSS:** `css/evaluator-applications.css`
- **Descripción:** Vista de aplicaciones para revisión por parte del evaluador
- **Características:**
  - Filtros por universidad y semestre
  - Grid de aplicaciones
  - Buscador
- **Navegación:**
  - "Reviews" → Evaluator Reviews (próximamente)

### 9. **Create Account Student**
- **FXML:** `fxml/create-account-student.fxml`
- **Controller:** `CreateAccountStudentController.java`
- **CSS:** `css/create-account-student.css`
- **Descripción:** Formulario de registro para estudiantes

### 10. **Create Account Evaluator**
- **FXML:** `fxml/create-account-evaluator.fxml`
- **Controller:** `CreateAccountEvaluatorController.java`
- **CSS:** `css/create-account-evaluator.css`
- **Descripción:** Formulario de registro para evaluadores

## Sistema de Navegación

### ViewNavigator Class
Clase centralizada para manejar toda la navegación de la aplicación.

**Ubicación:** `com.example.prueba_javafx.ViewNavigator`

**Constantes de Rutas:**
```java
public static final String COVER_PAGE = "/com/example/prueba_javafx/fxml/cover-page.fxml";
public static final String ROLE_SELECTION = "/com/example/prueba_javafx/fxml/role-selection.fxml";
public static final String STUDENT_LOGIN = "/com/example/prueba_javafx/fxml/student-login.fxml";
public static final String EVALUATOR_LOGIN = "/com/example/prueba_javafx/fxml/evaluator-login.fxml";
public static final String CREATE_ACCOUNT_STUDENT = "/com/example/prueba_javafx/fxml/create-account-student.fxml";
public static final String CREATE_ACCOUNT_EVALUATOR = "/com/example/prueba_javafx/fxml/create-account-evaluator.fxml";
public static final String STUDENT_DASHBOARD = "/com/example/prueba_javafx/fxml/student-dashboard.fxml";
public static final String EVALUATOR_DASHBOARD = "/com/example/prueba_javafx/fxml/evaluator-dashboard.fxml";
public static final String SCHOLARSHIP_MATCHES = "/com/example/prueba_javafx/fxml/scholarship-matches.fxml";
public static final String EVALUATOR_APPLICATIONS = "/com/example/prueba_javafx/fxml/evaluator-applications.fxml";
```

**Métodos:**
```java
// Navegación básica
ViewNavigator.navigateTo(Stage stage, String fxmlPath)

// Navegación con tamaño específico
ViewNavigator.navigateTo(Stage stage, String fxmlPath, double width, double height)

// Navegación con acceso al controller
Object controller = ViewNavigator.navigateToWithController(Stage stage, String fxmlPath)
```

### Ejemplo de Uso en Controllers:
```java
@FXML
private void onButtonClick() {
    try {
        Stage stage = (Stage) myNode.getScene().getWindow();
        ViewNavigator.navigateTo(stage, ViewNavigator.STUDENT_DASHBOARD, 1280, 800);
        stage.setMaximized(true);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

## View Test Menu

Se ha creado un menú de prueba para acceder fácilmente a todas las vistas.

- **FXML:** `fxml/view-test-menu.fxml`
- **Controller:** `ViewTestMenuController.java`

Para usarlo, cambia la vista inicial en `HelloApplication.java`:
```java
FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fxml/view-test-menu.fxml"));
```

## Estructura de Archivos

```
src/main/
├── java/com/example/prueba_javafx/
│   ├── HelloApplication.java
│   ├── ViewNavigator.java
│   ├── ViewTestMenuController.java
│   ├── ViewTestController.java
│   ├── CoverPageController.java
│   ├── RoleSelectionController.java
│   ├── StudentLoginController.java
│   ├── EvaluatorLoginController.java
│   ├── StudentDashboardController.java
│   ├── EvaluatorDashboardController.java
│   ├── ScholarshipMatchesController.java
│   ├── EvaluatorApplicationsController.java
│   ├── CreateAccountStudentController.java
│   └── CreateAccountEvaluatorController.java
│
└── resources/com/example/prueba_javafx/
    ├── fxml/
    │   ├── cover-page.fxml
    │   ├── role-selection.fxml
    │   ├── student-login.fxml
    │   ├── evaluator-login.fxml
    │   ├── student-dashboard.fxml
    │   ├── evaluator-dashboard.fxml
    │   ├── scholarship-matches.fxml
    │   ├── evaluator-applications.fxml
    │   ├── create-account-student.fxml
    │   ├── create-account-evaluator.fxml
    │   └── view-test-menu.fxml
    │
    ├── css/
    │   ├── cover-page.css
    │   ├── role-selection.css
    │   ├── student-login.css
    │   ├── evaluator-login.css
    │   ├── student-dashboard.css
    │   ├── evaluator-dashboard.css
    │   ├── scholarship-matches.css
    │   ├── evaluator-applications.css
    │   ├── create-account-student.css
    │   └── create-account-evaluator.css
    │
    ├── icons/
    └── images/
```

## Estilos y Diseño

Todos los CSS han sido adaptados de HTML a JavaFX:
- HTML properties → JavaFX CSS properties con prefijo `-fx-`
- Clases CSS aplicadas con `styleClass` en FXML
- Responsive design usando property bindings en los controllers

### Colores Principales:
- **Verde primario:** `#7fb069` / `#2fa86f`
- **Fondo claro:** `#d8e5d0` / `#eaf7ef`
- **Sidebar:** `#c8ddc0` / `#e7f7ec`
- **Bordes:** `#222222`
- **Texto:** `#222222`

### Fuente:
- **Courier New**, monospace (estilo brutalist/neo-brutalism)

## Características Implementadas

✅ Todas las páginas HTML convertidas a FXML
✅ Controllers creados para cada vista
✅ CSS adaptado para JavaFX
✅ Sistema de navegación centralizado (ViewNavigator)
✅ Menú de prueba para acceder a todas las vistas
✅ Responsive design con property bindings
✅ Iconos y recursos gráficos
✅ Footer con enlaces
✅ Headers consistentes en todas las vistas

## Próximos Pasos

- [ ] Agregar más vistas (Picked, In Process, Submitted, Reviews)
- [ ] Implementar funcionalidad backend
- [ ] Agregar validación de formularios
- [ ] Implementar sistema de autenticación real
- [ ] Conectar con base de datos
- [ ] Agregar más interactividad a las tarjetas
- [ ] Implementar búsqueda y filtros funcionales

## Cómo Ejecutar

1. Abre el proyecto en IntelliJ IDEA
2. Asegúrate de tener JavaFX configurado
3. Ejecuta `HelloApplication.java`
4. O ejecuta `Main.java` / `Launcher.java` según tu configuración

## Navegación Recomendada para Testing

1. **Cover Page** → Click "Get Started"
2. **Role Selection** → Elige Student o Evaluator
3. **Login** → Ingresa credenciales y haz login
4. **Dashboard** → Explora las diferentes secciones
5. **Scholarship Matches / Applications** → Ve los detalles

O usa el **View Test Menu** para acceder directamente a cualquier vista.
