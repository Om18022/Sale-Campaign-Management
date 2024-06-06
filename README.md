Sale Campaign Management Using Sprin Boot 

Developed using Spring Boot and MySQL, this Sale Campaign Management. 

It employs Intellij for development and Postman for API testing. 

This ecosystem streamlines e-commerce operations efficiently.

To set up a new MySQL database named "sales", follow these steps:

1. Open IntelliJ IDEA and open your project.
2. Navigate to the folder named "Demo."
3. Locate the following path: `demo > src > main > resources > application.properties`.
4. In the `application.properties` file, find the property `spring.datasource.url` and set it to `jdbc:mysql://localhost:3306/sales`.
5.In the `application.properties` file, find the property `spring.datasource.username`, `spring.datasource.password` and write your username and password.
6. Save the changes.

To run the application:

1. Find the file named `SaleApplication.java`.
2. It should be located at `demo > src > main > java > com.example.demo > SaleApplication`.
3. Right-click on `SaleApplication.java` and select "Run" to start the application.

Ensure that your MySQL server is running on `localhost` and listening on port `3306`. This setup will connect your Spring Boot application to the MySQL database named "sales".

To follow the given APIs in Postman, perform the following steps:
1. Add a new product: Send a POST request to http://localhost:8080/saveall with the required product details in the request body.

2. Retrieve all products: Send a GET request to http://localhost:8080/getall with the following parameters:

page: The page number to retrieve (e.g., 1, 2, 3, etc.)
pageSize: The number of products to display per page (e.g., 10, 20, 50, etc.)
Example: http://localhost:8080/products?page=1&pageSize=10


3. Create a new campaign: Send a POST request to http://localhost:8080/campaigns with the required campaign details in the request body.

startDate: The start date of the campaign (e.g., "2023-03-01")
endDate: The end date of the campaign (e.g., "2023-03-31")
title: The title of the campaign (e.g., "Spring Sale")
discount: The discount percentage or amount (e.g., 10 or 10.00)
JSON Format :
{
  "startDate": "2023-03-01",
  "endDate": "2023-03-31",
  "title": "Spring Sale",
  "discount": 10
}

*Note* that when creating a campaign, you must ensure that the start date is today's date or a future date, as the scheduler annotation is used to update prices accordingly. If the start date is not today's date or a future date, the campaign will be created, but the prices will not be updated.


Ensure that your Spring Boot application is running on `localhost` at port `8080` while testing these APIs in Postman. Adjust the request parameters and method types accordingly for each endpoint.

print all products using page and page size parameter in GET Parameters options

campaign create api using startdate, enddate, title, and discount using POST api
	 
