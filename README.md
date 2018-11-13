# Data-Table
Simple data table using elements from JSF, JSP and JavaScript with database integration

This is a project I made during my internship with the CRM department of Turkcell. This code was not written all by me, I have used methods
that I found on the Internet or had help from other people but for the most part I did the coding.

I made use of the MVC pattern so there are the control and model Java classes and the view side is in the WebContent folder. 
In the model classes there are the definitions of the components of the Customer and Worker objects. 
The control class OrderBean has all of the methods using these objects for the view side. 
Finally the view side is the interface for the user, calling the methods from the OrderBean.
The GetWorkerInfo class manages the connection with the database, which has the getting, updating and adding methods, 
as well as searching and login aspects. 
The web service provides the database management methods for the use of any client and there is a client package in the project to use 
the web service in one of the Servlets.
Servlets, I have used hand-in-hand with the JSP codes. HelloServlet provides a new screen for confirming or declining login actions. 
In DenemeServlet, I made use of the DataTables plugin for jQuery and used the servlet as a middle layer between the database 
and the client-side. There are also two filters, one controlling the logging in and out actions and the other handling the cache of 
the browser.
Finally, the DummyServlet and the Dummy class were both used for an autocomplete search screen, pulling information from the database. 
All of this back-end classes are presented to the user from the front-end web files using HTML, Javascript and of course JSF and JSP.



