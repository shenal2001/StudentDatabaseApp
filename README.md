# Student Database Console App (Java + JDBC + MySQL)

## What it is
A simple console-based Java application to manage students:
- Add student
- Update student
- Delete student
- View student by id
- List all students

## Requirements
- Java 8 or later
- MySQL server
- MySQL Connector/J (JDBC driver), or use Maven

## Setup
1. Create the database and table:
   - Run `create_database.sql` in your MySQL server.
2. Edit `DBConnection.java` and set your MySQL credentials (URL, user, password).
3. Ensure the MySQL JDBC driver is available:
   - If not using Maven, download the Connector/J JAR and place in project folder.
4. Compile and run:
   - Without Maven: `javac -cp .;mysql-connector-java-8.0.33.jar *.java` (Windows)
   - Then: `java -cp .;mysql-connector-java-8.0.33.jar Main`

## Notes / assumptions
- Date of birth must be entered as `YYYY-MM-DD` (ISO format).
- Email has a UNIQUE constraint — duplicate emails will fail.
- No GUI — console only.
