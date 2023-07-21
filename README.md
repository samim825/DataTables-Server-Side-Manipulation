# CRUD Application with Server-Side Pagination, Sorting, and Searching
This is a CRUD (Create, Read, Update, Delete) application built using Spring Boot. It provides server-side pagination, sorting, and searching capabilities for a datatable.

### Features
 - Create: Add new records to the datatable.
 - Read: Retrieve and display records from the datatable.
 - Update: Modify existing records in the datatable.
 - Delete: Remove records from the datatable.
 - Server-side Pagination: Display datatable records in smaller, paginated chunks in server side.
 - Sorting: Sort datatable records based on specific columns in server side.
 - Searching: Search and filter datatable records based on specific criteria on the server side.
### Technologies Used
 - Java
 - Spring Boot
 - Spring Data JPA
 - JSP (as frontend templating engine)
 - HTML, CSS, and JavaScript
## Getting Started
To get the application up and running on your local machine, follow these steps:

### 1. Prerequisites:

 - Java JDK (version 1.8) installed
 - Maven build tool installed
 - Database (PostgreSQL) installed and configured
### 2. Clone the repository:
```
git clone https://github.com/samim825/DataTables-Server-Side-Manipulation.git

```

### 3. Configure the database:

 - Create a new database in your chosen database management system.
 - Update the database configuration properties in application.properties file with your database connection details.
### 4. Build and run the application:
```
cd DataTables-Server-Side-Manipulation
mvn spring-boot:run

```
### 5. Access the application:

Open your web browser and navigate to http://localhost:8090 to access the application.

## Usage
#### 1. Create a new record:

 - Click on the "Add new" button to navigate to the create form.
 - Fill in the necessary details and submit the form to add a new record to the datatable.
#### 2.  Read records:

 - The datatable displays a paginated list of records.
 - Use the navigation buttons or page numbers to browse through the pages.
 - Click on the column headers to sort the datatable based on that column.
#### 3. Update a record:

 - Click on the "Edit" button next to a record to navigate to the edit form.
 - Modify the desired fields and submit the form to update the record in the datatable.
#### 4. Delete a record:

 - Click on the "Delete" button next to a record to remove it from the datatable.
#### 5. Searching:

 - Use the search box to search for specific records based on the given criteria.
 - The datatable will display the filtered results automatically.


#### DataTable Server side Processing

 - DataTable sent some parameters
 - After working based on the parameters its expect some data
To know about this , You can follow following url : 
https://datatables.net/manual/server-side
