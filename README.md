# Library-Database-Project
This project manages a book library database

This is one of my first projects that managed a database.

Make sure to setup the "library" database in your localserver as shown below. 

I used mysql-connector-java-5.1.46 and set up the connection as follows: 

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");

The database tables should be as follows: 

1- Employee(emp_id, emp_name, library_name)

2- Library(library_name, street, number of books)

3- Book(ICBN, title, publisher, author)

4- Publisher(id, name, country) 

5- Author(id, name) 
