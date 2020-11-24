# Persons Database
## How to run this project:
Download this application, then open it in an IDE of your choosing 
(this project was done in IntelliJ). Once there, run the main application "PersonsDatabaseApplication." 
Once this is done you can pick one of two options. 

A prompt to type on the command line should appear.
##### a.1) Web API
In your browser, check *http://localhost:8080/h2-console* to check the h2 database.
Once you log in, you can use SQL commands to see the database tables "Person" and "Address".
You can make commands to alter the Person or Address databases with any of the named methods (listed below).
##### a.2) Command-line commands
(note: the app is not case-sensitive)
From the command line, you can input a command directly, in the same fashion as in the web API.
 See below for the rest.
 
 ## Table of Contents:
 ### 1: Introduction
 ### 2: Viewing Information
 #### 2a) Online Repositories
 #### 2b) H2 Database
 #### 2c) Command-Line commands
 ### 3: File Runthrough
 #### 3a) Applications and Entities
 #### 3b)Repostories
 #### 3c)Controllers
 ##### 3d)Services
 ##### 3e)Utils, Properties and SQL
 ##### 3f)Maven Dependencies
 ### 4: Test Cases
 
 ## 1: Introduction:
 This is a console application in Java Spring to modify a database with a "Person" table and "Address" table.
 It can be accessed in one of two ways: as a command-line interface or as a web API. Both have similar functionality
  to each other.
 ## 2: Viewing Information
 ### 2a) Online Repositories
 On the web, the information of each table can be check by their respective links:
 *http://localhost:8080/person* and *http://localhost:8080/address*. The application must be running for these links to work
 but they show full information.
 ### 2b) H2 Database
 You can also see *localhost:8080/h2-console* to see the H2 database this project draws from.
 Use the credentials in this project's *application.properties* file to log into it,
 and once in, run SQL queries to see the information
 ### 2c) Command-line commands
 There are two command-line applications that can tell you about the Person table: *"List Persons"* and *"Count Persons"*.
 The former will list the names of everyone in the table; the latter will state how many are logged in there.
 
 ## 3: File Runthrough
 #### 3a) Applications and Entities
 Beyond the primary *PersonsDatabaseApplication*, there is also the *PersonsDatabaseRunner*,
 which is responsible for the command-line aspect of this application.
 
 The two entities are 'Address' and 'Person', which have simple getters and setters.
 #### 3b) Repositories
 The two repositories are *AddressRepository* and *PersonRepository*. The functions in these help with
 both functionality and testing.
 #### 3c) Controllers
 Both tables have their own controllers, with respect to the different nature of their tables and their inputs.
 This was a design decision in case the nature of their relationship was asked to be expanded upon in the future.
 The controllers do not have much internal functionality beyond pointing to the Service methods of the same name.
 #### 3d) Services
 The service implementations handle both adding, editing and deleting information in both tables.
 The inputs are looked at, type-checked and if they're all appropriate, the repositories are modified accordingly. 
 #### 3e) Utils, Properties and SQL
 The utils folder has a *PersonsDatabaseHelper* class which has helper classes for the Service objects.
 This is where inputs are type-checked, such as if a given ID is actually numeric, or if a string has regex characters.
 
 The *application.properties* file contains the information on the h2 database.
 
 *Data.sql*, at project runtime, gives a default entry to both the Person and Address tables.
 #### 3f) Maven Dependencies
 Maven dependencies for this project include:
 - H2 Database (SQL database, permanence, online adjustments)
 - Spring Boot DevTools (auto-restart, live-reload, global settings)
 - Hamcrest (unit testing API)
 - lombok (boilerplate code, general convenience)
 - Sping Web (Apache Tomcat, web aspect)
 - JPA (JPA repositories)

## 4: Test Cases
There are test cases in this project covering the basic functionality of the project. 
Adding/editing/deleting entries have tests to confirm they work when they should, while adding/editing
have tests to show error when such is expected.
 
Test cases were supplemented by the Hamcrest plugin.
