# EJB_Project
First Java EJB Project 3A ISMIN

## Table of Contents

- [Context](#context)
- [Environment](#context)
- [Server](#server)
  - [Entity](#entity)
  - [BeanSession](#beansession)
  - [Interface](#interface)
  - [Exception](#exception)
- [Client](#client)






-------

## Context

Project done to provide solutions, for a company operating in the medical sector, to assign its Employees to other Departments.

***Note : An employee can only be assigned to one Department***

***Note2 : In this project, a fake Department whose id equals '0' has been created to store Employees who do not have been assigned yet to a Department. In addition, for this specific Department, its attribut 'nbemployee' will not be updated.***

This EJB has some constraints that can be configured in `Server\META-INF\ejb-jar.xml`. These constraints are about the minimum and maximal age and the maximum number of employees possible inside a Department.

## Environment

This project used Glassfish and pgAdmin to work.

Furthermore, Java 8 is needed !!

Before doing any test, do not forget to configure the file `Server\META-INF\persistance.xml` ! ***(jta-data-source, properties etc..)***


To make easier the compilations and the execution of the client, bashing script are available. However notice, in case the Server is compiled again, you need to copy this new version of the .jar inside `\Client\`! Do not forget also to upload this new version on Glassfish !

Furthermore, to simplify the test with the client, a file `code.sql` contains the SQL code to create the tables used and to initialize them as well as reinitialize them if needed !

***Note : A non-exhaustive Java Documentation has been generated in the directory `Documentation` if needed.***



## Server

### Entity

To carry out this project, 2 entities have been created :

- Employee : represents an Employee and has several attributs as an id, an department id, its age etc..
- Department : represents a Department. As the previous entity, has several attributes as an id, the number of employees etc...


### BeanSession

They are divided into 3 Beans :

- AssignmentSB (Stateful) : describes the interaction about the Assignment Session :
    - Start a new session for the id_department given in input. This Department is then saved in the context.
    - Assign an employee to the id_department saved in the context
- DepartmentSB (Staless) : describes the main methods for the Department Entity :
    - Create/Remove the Department
- EmployeeSB (Stateless) : describes the main methods for the Employee Entity :
    - Create/Remove an Employee
- Infos (Stateless) : used to display results for several queries implemented in particular to display the database data into the client console.

### Interface

In order to use the methods defined in these Bean Sessions by the Clients, 4 remote interfaces have been created then :

- IAssignment : for the Assignments
- IDepartmentManagement : to handle Departments
- IEmployeeManangement : to handle Employees
- IInfos : to handle functions to display the queries' results

### Exception

In addition, custom exceptions are handled about :
- Age of the Employee to be assigned :
  - `AGEMIN`: Minimum age required to be assigned
  - `AGEMAX`: Maximum age required to be assigned
- The maximum number of Employees that can be assigned to a Department :
  - `LIMITEMP`
  
These thresholds values can be configured inside `Server\META-INF\ejb-jar.xml`.


## Client

In order to test the previous implementation , a Client has been also designed into `Client\`.

To launch the Client, open a console and then execute the `client.bat` (Windows only).

Because the code try the 3 exceptions, you may need to comment/uncomment exceptions to verify !

If an error occurs during the execution, do not forget to reinitialize the initial values in the database (see `\code.sql`) to prevent MARSHAL error due to methods on an entity that have been removed, or the creation of an entity already created !


