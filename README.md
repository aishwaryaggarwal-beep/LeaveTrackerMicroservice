# LeaveTrackerMicroservice
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
