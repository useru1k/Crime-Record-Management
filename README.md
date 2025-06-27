# Crime-Record-Management

Crime Record Management System is a Java console-based application that allows users to add, view, and manage criminal records, victims, and crime details using a text-based interface and database connectivity. 

## Features
  - User Management: Login and register users (admin/officer) with BCrypt password hashing.
  - Role-Based Access: Admins: Officers:
  - Crime Management: Add, update, delete, and view crimes.
  - Criminal/Victim Management: Add criminals and victims, link them to crimes.
  - Database: MySQL 

## Project Structure
```
CrimeRecordSystem/
├── src/
│   ├── crimerecordsystem/
│   │   ├── model/
│   │   │   ├── Person.java
│   │   │   ├── User.java
│   │   │   ├── PoliceStation.java
│   │   │   ├── Criminal.java
│   │   │   ├── Victim.java
│   │   │   ├── Crime.java
│   │   ├── view/
│   │   │   ├── UserView.java
│   │   ├── controller/
│   │   │   ├── UserController.java
│   │   │   ├── PoliceStationController.java
│   │   │   ├── CriminalController.java
│   │   │   ├── VictimController.java
│   │   │   ├── CrimeController.java
│   │   ├── util/
│   │   │   ├── DatabaseConnection.java
│   │   ├── Main.java
├── out/
├── lib/
│   ├── mysql-connector-java-8.0.33.jar
│   ├── bcrypt-0.4.jar
├── crime_record.sql
├── README.md
```

## Prerequisites
 - Java 8 or higher
 - MySQL 8.0 or higher
 - MySQL Connector/J (mysql-connector-java-8.0.33.jar)
 - jBCrypt (bcrypt-0.4.jar)

## Compile and Run:
 - Compile the project:
   ```
   javac -cp .:lib/mysql-connector-java-8.0.33.jar:lib/bcrypt-0.4.jar -d out src/crimerecordsystem/*.java src/crimerecordsystem/*/*.java
   ```
 - Run the application:
   ```
   java -cp out:lib/mysql-connector-java-8.0.33.jar:lib/bcrypt-0.4.jar crimerecordsystem.Main
   ```
---
