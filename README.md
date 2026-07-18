# Document Approval Management System (DAMS)

# Project Overview
Document Approval Management System (DAMS) is a system that helps to manage day-to-day and frequently exchanged documents.

The system allows employees to submit different types of documents and  allows managers to approve or reject those documents

The main purpose of this project is to demonstrate Java programming concepts and the practical use of data structures to manage a document approval workflow.

# Objectives
The objectives of this project are:
- To simulate a simple document approval process in an office environment.
- To apply programming concepts using Java.
- To represent the proper use of different data structures.
- To manage document submission and approval operations efficiently using FIFO(First in first out).

# System Workflow
The document approval process follows these steps:
1. Employee submits a document request.
2. The document is added to the end of the pending approval queue (FIFO).
3. Manager views the next pending document (the front of the queue.)
4. Manager approves or rejects that document.
5. The processed document is removed from the queue.
6. Employee checks the final document status.


# User Roles and Features

# Employee
The Employee module allows employees to:
- Submit new document requests.
- Select a document type from predefined categories.
- Enter employee information and document details.
- Receive a unique document ID automatically (for personal reference).
- View all their submitted documents.
- Check the current approval status.
- View rejection reasons when a request is rejected.

Available document types:
- Leave Request
- Short Leave Pass
- Purchase Request
- Event Proposal
- Expense Reimbursement Request
- Maintenance Request
- Budget Request
- Attendance Correction Request
- Equipment Request
- Complaint Report


# Manager
The Manager module allows managers to:
- View all pending documents in queue order (oldest first).
- Process the next document at the front of the queue (FIFO — no document selection by ID).
- Approve the next pending document.
- Reject the next pending document with a reason.
- View the approval history (most recent action shown first).

Document statuses used in the system:
- Pending
- Approved
- Rejected


# Data Structures Used

This project implements three different data structures to manage the document approval workflow.

## 1. Queue
The Queue is used to store documents waiting for manager approval in FIFO (First In, First Out) order.

Java `Queue` interface with `LinkedList` implementation is used.

- `add()` — enqueues a new document when submitted.
- `peek()` — previews the document at the front of the queue without removing it.
- `poll()` — dequeues and returns the front document for processing.

Example:
If Employee A submits a document at 9:00 AM and Employee B submits one at 9:05 AM, the manager will always review Employee A's document first, regardless of document type or employee name.


# 2. ArrayList
Purpose:
The ArrayList is used to store all submitted documents and maintain their current information across the program's lifetime.

Java `ArrayList<Document>` is used.

- `add()` — adds a document when submitted.
- Iteration with enhanced for-loop — used to filter documents by employee name.

Example:
When a manager approves or rejects a document, the document object's status is updated directly. Since the ArrayList holds a reference to the same object, employees can instantly see the updated status when they view their documents.

# 3. Stack
The Stack is used to store the manager's approval and rejection history.

Java `Stack<String>` is used.
- `push()` — adds a new history entry after each approve/reject action.
- `pop()` — used when displaying history (from top to bottom, most recent first).

Example:
If the manager approves D001, then rejects D002, the history stack will show D002 (Rejected) on top, followed by D001 (Approved) below it — reflecting the most recent action first.

Main classes:
## Document Class
For store document details.
Contains:
- Document ID (auto-generated, for employee reference)
- Employee name
- Document type
- Description
- Status (Pending / Approved / Rejected)
- Rejection reason

## DAMS Class
For manage the main system operations.
Functions include:
- `submitDocument()` — adds a document to the ArrayList and enqueues it in the Queue.
- `viewEmployeeDocuments()` — filters the ArrayList by employee name.
- `viewPendingDocuments()` — displays all documents in the Queue in order.
- `peekNextDocument()` — previews the next document at the front of the Queue.
- `processNextDocument()` — polls the front of the Queue and approves or rejects it, then pushes to the Stack.
- `viewHistory()` — pops and displays the Stack history from most recent to oldest.

# Main Class
Responsible for:
- Starting the application.
- Displaying user menus.
- Handling user input with validation.
- Allowing users to select their role (Employee or Manager).

# Technologies Used
- Programming Language: Java
- Object-Oriented Programming
- Data Structures (Queue, ArrayList, Stack)

# Project Structure

The project contains the following files:
- Main.java
  - Controls program execution and user interaction.

- DAMS.java
  - Handles document submission, FIFO queue processing, approval, rejection, and workflow management.

- Document.java
  - Represents document objects and stores document information.

- README.md
  - Contains project information and setup instructions.

# How to Run the Project

# Requirements

Before running the project, make sure the following requirements are available:

- Java Development Kit (JDK) installed.
- Java-supported development environment or command prompt.

Recommended Java version:

- JDK 21 or later.


# Running Using Command Prompt
1. Open the project folder.

2. Compile the Java files:

javac Main.java DAMS.java Document.java

3. Run the application:

java Main

# Running Using an IDE
1. Open the project using an IDE such as:
- IntelliJ IDEA
- Eclipse
- Visual Studio Code

2. Make sure Java is configured correctly.

3. Run the Main.java file.

# Conclusion
The Document Approval Management System demonstrates how Java programming concepts and data structures can be applied to create a realistic workflow management system.

By using Queue (FIFO pending processing), ArrayList (all-document storage and status tracking), and Stack (LIFO history), the application efficiently manages document submission, fair approval processing, and approval history while maintaining a simple and understandable design.

The Queue is the core data structure of this system — documents are always processed in submission order, ensuring fairness and a true First In, First Out workflow.