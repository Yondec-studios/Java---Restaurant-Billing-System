## Introduction

Hello everyone,
This is a restaurant billing system using Java. This system has mainly three funtianalities.
- System User Login
- System User Create Account
- Manager Login

If the system user is a new user, then he/she have to add their First Name, Last Name, Email, and Password. After that the user will redirect to the billing function. In that case user can add customers add billed items. 
In Manager Login section, managers can see details about system users, old bills and edit prices, add new items to the system.

`Special thing is I add GRAPHICAL USER INTERFACE by using Java SWING`

Also, I used databases for store data. Manager can download details in an Excel file.


## Structure

I used 15 classes and 2 interfaces for this system.

`Classes`
  - Background
  - Login
  - CreateOne
  - BillingBackground
  - Items
  - Customers
  - FinalBackground
  - Employee
  - Manager
  - SystemUser
  - CheckBills
  - EditPrices
  - AddExtraItems
  - Main


`Interfaces`
  - dataBaseQuaries
  - AbstractClasses




> Anyone who need to use code, please you have to add Spire.Xls jar file to the project file. Also, you have to add your database url, username, password  to your code.
- Create your own database in localhost or any online host
- Get username, password and database name from it.
- Go to the dataBaseQuaries Interface.
- You can see, variable to add those got details.
- Finaly, you should add your database name and url like this. jdbc:mysql://`host link (Ex - localhost:3306)`/`database name(Ex - sql12601094)`


> Best Regards,
> Yondec Studios
> Coder: Tharanga Sandun

## THANK YOU
