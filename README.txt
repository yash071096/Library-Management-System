Library Management System (LMS) for a university
Technologies
Spring, DI, AOP, MVC, ORM, transactions.

Tools
IntelliJ, Maven, MySQL, Jenkins, Apache Tomcat

Requirements implemented
Functional Requirements
This app manages many aspects of a university library system, including cataloging, search, circulation, and waiting list. The interface is web based, and the server needs to be hosted on the cloud, and is accessible from anywhere with Internet connection.

Users and Authentication
There are two roles of users, librarian and patron.

A librarian manages cataloging, and can assist circulation as well.
A patron is a customer of the library. He can search for books, borrow and returns books.
For simplicity, we allow any user with any email address to be able to create his account using an email as the username, and password of his choice. The user also needs to provide a university ID of 6 digits.
App sends an email to the user with a verification code. The user needs to use that verification code to complete his account registration. A registered user cannot really use features in the system until his account is verified. A confirmation email must be sent to the user after completion of account verification.
For simplicity, we only and automatically register any user with an SJSU email account (@sjsu.edu) to be a librarian. A librarian cannot be a patron, which means he has to use a different email to register if he needs a patron account as well.
No two patrons can have the same university ID, neither can two librarians.

Cataloging
A librarian is able to manage the catalog of the books.

A book item contains the following properties:

Author
Title
Call number
Publisher
Year of publication
Location in the library;
Number of copies
Current status
Keywords
Coverage image

A librarian is able to search, add, update, and delete books.
Search capability functions as a superset of search features to be described below for patrons.
Search has the apability to search for books created or updated by a particular librarian.
Update and deletion works together with search, i.e., a librarian has the capability to find a book through search, then decide to update/delete it.
A book cannot be deleted if it’s checked out by a patron.
Deleting a book also removes the waiting list for it, if there is any.
Integrated with external APIs to simplify the input the book info based on ISBN.


Circulation

A patron is able to check out up to 5 books in any day.
Each check out transaction can handle up to 5 books.
A book is due in 30 days from checking out.
The checkout screen shows the due date.

A confirmation email is sent to the patron for each checkout transaction with the details, including the book info, the transaction date and time, and the due day.
The total number of books a user can keep at any given time cannot exceed 10.
If a book is due within 5 days, daily alerts will be sent to the patron; and the patron can renew the book for another 30 days before the book is overdue. A book can be renewed twice, which means a maximum of 90 days in total from checked out. If, however, there is a waiting list for the book, it can no longer be renewed.
A patron is able to return up to 10 books in one transaction.
Upon returning, an email confirmation is sent to the patron with the detail of the transaction.
If any book is overdue, a fine of $1 per day is enforced.
If the overdue period is not more than 24 hours, it is counted as one day
If it is more than 24 hours, but not more than 48, it is counted as two days. So on and so forth.

Waiting list
A patron can add himself to a waiting list if the book he is interested in is currently checked out by somebody else. There is no limit on how many people can be added to a waiting list, yet the order in the waiting is preserved. You cannot add the same person to the same list twice for the same book.
When a book becomes available, the first person on the waiting list is notified about its availability, and the person is removed from the waiting list. The book is reserved for this person for three days, during which only this person can check out this book. After these three days, the reservation is cancelled, and the next person in the waiting list (if there is any) is notified about the availability, and a three-day reservation is created for him as well. So on and so forth.

Testing Assistance
For ease of testing, the capability for a librarian to set the current date and time for the app has been provided. This way it is easier to test features like due date and waiting lists. This interface for setting the date and time has been positioned at the top right corner of the main UI pages, and the resulted date and time is clearly displayed along with the time setting interface as well.