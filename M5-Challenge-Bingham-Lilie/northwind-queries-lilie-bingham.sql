-- What are the categories of products in the database?
use northwind;
select category
from products;

-- What products are made by Dell?
use northwind;
select *
from products 
where product_name 
like '%Dell%'
-- FIXME

-- List all the orders shipped to Pennsylvania.
use northwind;
select *
from orders
where ship_state = 'Pennsylvania';


-- List the first name and last name of all employees with last names that start with the letter W.
use northwind;
select first_name, last_name 
from employees
where last_name 
like 'W%';

-- List all customers from zip codes that start with 55.
use northwind;
select *
from customers
where postal_code 
like '55%';

-- List all customers from zip codes that end with 0.
use northwind;
select *
from customers
where postal_code 
like '%0';

-- List the first name, last name, and email for all customers with a ".org" email address.
use northwind;
select first_name, last_name, email
from customers
where email 
like '%.org';


-- List the first name, last name, and phone number for all customers from the 202 area code.
use northwind;
select first_name, last_name, phone 
from customers
where phone 
like '%(202)%';

-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
use northwind;
select first_name, last_name, phone 
from customers
where phone 
like '%(202)%'
order by last_name, first_name;



















