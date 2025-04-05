OOP Java

Westminster Skin Consultation System

Overview

The Westminster Skin Consultation System is a Java-based application designed for managing doctors, patients, and consultations within a skin consultation center. 
The system allows users to manage doctor information, add consultations, and handle patient details. 
It also includes functionalities such as sorting doctors, saving/loading data, and encrypting sensitive information.

Features

Design and Classes Implementation

UML Diagrams:

UML Use Case Diagram and UML Class Diagram were designed to visualize the system's architecture.

Classes Implemented:

Person Class: Represents a generic person with basic attributes like name and ID.
Doctor Class: Extends Person. Contains specific attributes for doctors such as medical license number, specialization, and availability.
Patient Class: Also extends Person. Contains patient-specific information like patient ID, health condition, and personal details.
Consultation Class: Manages the details of a consultation, including the doctor, patient, date/time, cost, and notes.
WestminsterSkinConsultationManager Interface: Provides an abstraction layer for operations related to managing doctors and consultations.

Console Menu Implementation

Doctor Management:
Add doctors with relevant information (max 10 doctors).
Remove a doctor by selecting their medical license number.
Display a list of doctors, ordered alphabetically.
Save and load the system's data to/from a file for persistence.

Consultation Management:
User can select a doctor and create a consultation.
A patient’s details can be added to the consultation.
The consultation time is checked to ensure that no doctor has multiple consultations at the same time.
The consultation cost is calculated, with the first consultation priced at £15 and subsequent ones at £25 per hour.
Notes can be added to a consultation, though image support and encryption are not fully implemented.

GUI Implementation

A GUI interface was implemented to allow users to interact with the system more easily. This includes functionalities for adding doctors, displaying the doctor list, and managing consultations.

Testing and System Validation

Test Plan: A separate test plan was created to ensure all features and functionalities work as expected.
Unit Testing: Automated unit tests were designed to test various scenarios in the console menu, ensuring the code’s robustness.
Error Handling: Error handling and input validation were applied across the system to prevent crashes and incorrect data entry.
