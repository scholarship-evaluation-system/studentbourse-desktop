# 📘 StudentBourse – Desktop Application

StudentBourse is a JavaFX desktop application designed to streamline scholarship discovery, application, and evaluation for students and evaluators.  
The project follows a clean MVC architecture with database-backed authentication, role-based access, and modular UI navigation.

---

## 🚀 Technologies Used

### Core Stack
- Java 17
- JavaFX 21
- Maven 3.x
- PostgreSQL 14+
- JDBC (PostgreSQL Driver)

### Architecture & Tools
- MVC pattern
- DAO layer for database access
- Role-Based Access Control (RBAC)
- Password hashing for authentication
- FXML + CSS for UI separation
- IntelliJ IDEA (recommended)

---

## 🗂️ Project Structure (Simplified)

src/

└─ main/

├─ java/

│  └─ com.studentbourse/

│     ├─ controller/

│     ├─ dao/

│     ├─ model/

│     └─ util/

└─ resources/

├─ fxml/

├─ css/

└─ assets/

---

## 🔐 Authentication & Roles

The application supports role-based navigation:

### Student
- Scholarship matches
- Picked applications
- In-process applications
- Submitted applications

### Evaluator
- Application evaluation dashboard
- Review and decision workflows

Authentication is database-backed with hashed passwords and role-aware routing.

---

## 🗄️ Database

- PostgreSQL database
- Centralized connection utility
- DAO-based queries
- Universities, users, applications, and related entities integrated
- Backend connectivity fully operational

---

## ▶️ How to Run the Project (IntelliJ)

### Prerequisites
- Java 17 installed
- PostgreSQL running
- IntelliJ IDEA (Community or Ultimate)

---

### Step 1 — Open Project
Open the project root folder in IntelliJ.

---

### Step 2 — Maven Import
Allow IntelliJ to download Maven dependencies automatically.

---

### Step 3 — Compile
In IntelliJ:


---

### Step 4 — Run JavaFX Application
In IntelliJ:


The application launches in full-screen desktop mode.

---

## 🧭 Navigation Overview

- Intro cover page
- Role selection (Student / Evaluator)
- Role-specific login and account creation
- Persistent sidebar navigation per role
- Centralized routing across pages

---

## 📊 Current Project Status

- Core UI flows completed
- Database fully connected
- Authentication and RBAC implemented
- Student and Evaluator dashboards functional
- Modular navigation across all major screens
- Backend structure in place for statistics and workflows

---

## 🔜 Upcoming Enhancements

The next iteration will include:
- Extended statistics and analytics
- Database-driven mini-stats across dashboards
- Improved routing for profile, notifications, and home actions
- Expanded scholarship application workflows with full backend integration

---

## 👥 Team Workflow

- GitHub organization repository
- Feature-based branching strategy
- Maven-based build lifecycle
- IntelliJ Git integration used throughout development

---

## 📌 Notes

This project is actively evolving and structured for scalable backend expansion and UI growth.
