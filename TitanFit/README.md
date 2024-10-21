# TitanFit

TitanFit is a full-stack fitness tracking application built using Spring Boot for the backend and Thymeleaf for the frontend. The application offers role-based authentication, allowing both `ADMIN` and `USER` roles to interact with the platform. Admin users can manage workouts, workout plans, and users, while normal users can select workout plans and track their fitness progress.

## Features

### 1. Authentication
- **Login:** Registered users can log in with their email and password.
- **Role-Based Redirection:** 
  - Users with the `ADMIN` role are redirected to the Admin Dashboard.
  - Normal users are redirected to the User Dashboard.
- **Registration:** 
  - Users can register for an account by providing a name, email, and password.
  - Invalid email formats and passwords trigger error messages, displayed below the respective fields.
  - On successful registration, the user is alerted and redirected to the login page.

### 2. Admin Features
#### Admin Home Page
The Admin Home Page features three main sections:
- **Workout Library:** 
  - Displays a list of available workouts.
  - Admin can edit or delete workouts.
  - New workouts can be added using the 'Add Workout' option.
- **User Management:** 
  - Admin can add, edit, or delete users.
  - Set roles for users (either `ADMIN` or `USER`).
- **Workout Plans:** 
  - The workout plan builder dashboard allows admins to create and manage workout plans.
  - Admins can create new weekly workout plans, which become available to users.
  - Existing plans can be edited or deleted.

### 3. User Features
#### User Home Page
- Users are presented with an empty dashboard until they select a workout plan.
- Users can view available workout plans and assign a plan to their profile.
- The selected workout plan will be displayed on the user's home page for tracking.

### 4. Navigation
- Clicking the `TitanFit` brand in the navbar takes users back to the home page.
- Logging out will log the user out and redirect them to the login page.

## Technology Stack
- **Backend:** Spring Boot (Java)
- **Frontend:** Thymeleaf template engine (HTML, CSS)
- **Security:** Spring Security for role-based authentication and authorization.
- **Database:** MySQL for storing user and workout data.

## Installation and Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/titanfit.git
