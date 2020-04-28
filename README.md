# DBMS_Store
Dbms online grocery store management system                         

--> follow the instructions to simulate DBMS_store

1)Download all the files and put them in the same folder.

2)install JDBC

3)comment the package line if not using eclipse ide.

4)run 

==>javac grocery_store.java

==>java grocery_store


Application: 
The domain our team has decided to work on is an online grocery store management system. We aim to work on building a realistic and useful version of this application that can be of use to all our stakeholders.

Stakeholders:
The four stakeholders in our application will be the consumers, the admin of the store, the supplier of the grocery, and the delivery partners.

Assumptions:
1. A user can login as a stakeholder and the system will then take him through the work path for that particular stakeholder. Once exited the program stops and needs to be run again for another log in.
2. The supplier has a unique id, which being confidential can be used as a secure system for logging in. Thus for a supplier to log in, the supplier id must be entered correctly and the portal will be unlocked.
3.  The delivery executive uses his unique id as a login id, and the unique photo id number (e.g. Aadhar number, pan card number etc) are used as the password.

Tables:
1. Products: this table holds detail of all the grocery items in the store and acts as the inventory of the database.
2. Customer: this table holds details of all the customers and helps the admin keep check of the people using the store for their groceries.
3. Supplier: this table holds all the information about the suppliers of groceries in the store.
4. Delivery executive: this table holds details regarding the delivery executives associated with the store for delivery of the groceries to the customer.
5. Invoice: this invoice table contains details about the billings of each order.
6. Orders: this table contains details of each order placed by a customer.
7. Order items: this table contains details about the items present in each order.
8. Admin: this table contains the details of the admin of the store.
9. Cart: this table allows the customers to create a cart and add several items to it.
10. Feedback: the customer can give feedback to the store regarding the quality of the products supplied to him.
11: Return order: customers have an option to return their orders, this table contains this date.
12. Categories: All groceries are divided into certain categories. This table reflects that data.

Bonus Implementation:
1. Customer Loyalty Program.
In a real world scenario, most online portals have some form of an online point system. Where reward points are added to a customer virtual wallet after every purchase. These points are redeemable in any succeeding purchase. In order to make our system as close to the real world as possible, we implemented a similar system in our online grocery store portal. After registering, every customer has 0 points in their wallet. After every purchase, points equals to the checkout value of the order is added to the points. At every succeeding order, before checkout the customer is asked whether or not he wants to redeem those points. 10% of the value of the points is deducted from the checkout value, and the new checkout value is added to the points in the customer wallet. This is the very common examples of customer loyalty programs that a lot of companies use to give customer an incentive to use their portal more often.

2. Sentiment Analysis. 
Sentiment analysis is a technique used by a number of e-commerce portals to get more in depth feedback from the customer regarding the product. This method asks the user for a feedback (in words) and perform analysis of that written feedback to give an output of whether the feedback was positive, negative, or neutral. We have exploited this technique using the NLP library in java to perform the functionalities. Example of one of the feedback on the product-
Sentiment score = 1%,       Sentiment type = Negative%
Very positive = 2%,             Positive = 12%
Neutral = 25% ,                  
Negative = 52%,                  very negative = 10%
