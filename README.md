# Cleaning Robots## ️ **Project Overview**This project implements an application to control autonomous cleaning robots in a factory. The robots navigate a rectangular grid, executing commands to clean efficiently and move accurately within the designated area.## **Rich Domain Model**The project follows a rich domain model, where business logic is encapsulated within the domain objects (`Robot`, `Position`, `Grid`, `Orientation`). This approach provides several benefits:- **High Cohesion** – Logic is close to the data it manipulates, simplifying maintenance and reducing duplication.- **Modularity** – Domain objects are independent and reusable, making the system easier to extend.- **Consistency** – Business rules are consistently enforced within domain objects, reducing potential errors.## **Architecture**- **Infrastructure Layer** – Handles input and output (`InputProcessor`).- **Application Layer** – Contains services (`CleanService`) to coordinate operations.- **Domain Layer** – Defines entities and business rules (`Robot`, `Position`, `Grid`, `Orientation`).## **Usage**1. Enter grid dimensions.2. Enter the robot's initial position and orientation. 3. Enter movement commands (`L`, `R`, `M`).4. Press `Enter` to finish.## **Example**```text5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM```the output will be```text1 3 N 5 1 E```## **Assumptions**- If you try to move the robot out of the bounds, it will do nothing.- It will throw an exception if the command is not valid (L, R or M)- I assume that you will put the commands in the correct order and the correct format.## **Improvements*** I can control if you don't put the commands well* Another improvement can be to save all the path did by the robot, just to know witch squares it cleaned.## **Technologies**- Java 23- JUnit 5