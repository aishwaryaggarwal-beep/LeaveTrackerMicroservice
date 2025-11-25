# LeaveTrackerMicroservice
Leave Tracker Application

Leave Tracker is a web-based application designed to streamline the leave management process within an organization. It allows employees to apply for leave, track their leave history, and view official holidays. Managers can efficiently monitor and manage team leave requests, approve or reject pending requests, and access team leave history.

The application uses a microservices architecture with separate services for authentication, leave management, and holidays, providing scalability, security, and maintainability. Authentication is handled using JWT tokens to ensure secure access for both employees and managers.

Key Features

For Employees:

Apply for leave with start date, end date, type, and reason.
View leave history to track past and upcoming leaves.
Access the list of official holidays.

For Managers:
View pending leave requests from team members.
Approve or reject leave requests with one click.
Monitor team leave history and leave trends.
Apply leave for themselves (optional).
View the organizational holiday calendar.

Technical Highlights:
Frontend: React with reusable components and role-based dashboards.
Backend: Spring Boot microservices for LeaveService, UserService, and HolidayService.
Authentication: JWT-based secure login and role-based access.
Database: MySQL for persistent storage of users, leave requests, and holidays.
This system improves transparency in leave management, reduces manual workload, and ensures timely approval of leave requests.
          ┌─────────────┐
          │   Employee  │
          └─────┬───────┘
                │
       ┌────────▼─────────┐
       │ React Frontend    │
       │ Employee Dashboard│
       └────────┬─────────┘
                │
        ┌───────▼─────────┐
        │ LeaveController  │
        └───┬─────────────┘
            │
      ┌─────▼───────────┐
      │ LeaveService     │
      │ Business Logic   │
      └─────┬───────────┘
            │
       ┌────▼─────┐
       │ Database │
       └──────────┘

-----------------------------------------

          ┌─────────────┐
          │   Manager   │
          └─────┬───────┘
                │
       ┌────────▼─────────┐
       │ React Frontend    │
       │ Manager Dashboard │
       └────────┬─────────┘
                │
  ┌─────────────▼─────────────┐
  │ LeaveController / Feign    │
  │ - GET /leave/pending       │
  │ - POST /leave/approve/{id} │
  │ - GET /leave/history       │
  └─────────────┬─────────────┘
                │
          ┌─────▼───────────┐
          │ LeaveService     │
          │ Business Logic   │
          └─────┬───────────┘
                │
           ┌────▼─────┐
           │ Database │
           └──────────┘

-----------------------------------------

          ┌─────────────┐
          │ UserService │
          └─────┬───────┘
                │
       ┌────────▼─────────┐
       │ Auth & Registration│
       │ User Details       │
       └────────┬─────────┘
                │
           ┌────▼─────┐
           │ Database │
           └──────────┘
