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
- [Bug](#bug)





-------

## Context

Project done to provide solutions, for a company operating in the medical sector, to assign its Employees to other Departments.

***Note : An employee can only be assigned to one Department***

***Note2 : In this project, a false Department whose id equals '0' has been created to store Employees who do not have yet been assigned to a Department. In addition, for this specific Department, its attribut 'nbemployee' will not be updated.***

This EJB has some constraints that can be configured in `Server\META-INF\ejb-jar.xml`. These constraints are about the minimum and maximal age and the maximum number of employees possible inside a Department.

## Environment

This project used Glassfish and pgAdmin to work.

Furthermore, Java 8 is needed !!

To make easier the compilations and the execution of the client, bashing script are available. However notice, in case the Server is compiled again, you need to copy this new version inside `\Client\`!

Furthermore, to simplify the test with the client, a file `code.sql` contains the SQL code to create the tables used and to initialize them as well as reinitialize them if needed !



## Server

### Entity

To carry out this project, 2 entities have been created :

- Employee : represents an Employee and has several attributs as an id, an department id, its age etc..
- Department : represents a Department. As the previous entity, has several attributes as an id, the number of employees etc...

### BeanSession

### Interface

### Exception


## Client


