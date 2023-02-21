Use northwind;
Select *
FROM Products;

--categories of products in database
SELECT DISTINCT category 
From Products;

--products made by dell
SELECT * from products WHERE product_name LIKE 'Dell%';

--all orders shipped to penn
SELECT * from orders WHERE ship_state = 'Pennsylvania';

--all first and last name of employees that start with W?
SELECT first_name, last_name from employees WHERE last_name LIKE 'W%';

--zip codes that start with 55
SELECT * from customers where postal_code LIKE '55%';

--zipcodes ending in 0
SELECT * from customers where postal_code LIKE '%0';

--first/last names and emails for customers ending in .org 
SELECT first_name, last_name, email from customers where email LIKE '%.org';

--first/last names and phone numbers with 202 area code
SELECT first_name, last_name, phone from customers where phone LIKE '%(202)%';

--first/lastnames and phone number for customers with 202 area code, ordered by lastname, first name
SELECT first_name, last_name, phone from customers where phone LIKE '%(202)%' ORDER BY last_name, first_name;