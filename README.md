READ ME

ISU Project for ICS4U - Alexander Shen and Pranav Manjunath
We have created a management system for bankers. Under it, you can create and manipulate customers and stocks. Customers can have checking, saving, debt, and stock information manipulated. Stocks can have new caps set and prices are able to be tracked and changed. If stock information were to breach the cap, it would instead refuse to act. You are also able to see a history of the stock's changes in price and import files to be read.

Notable bugs:
When adding multiple of the same stock to a customer that will be added, it will not automatically change how it will be added to the customer with respect to previous changes. Instead, it will replace it with the most recent version of the stock. As well, as a result adding it multiple times may cause issues with the stock cap that may result in it prematurely reaching the cap.

We were otherwise able to stick with the original design. We were unable to account for the addition of a graph class as we were unaware of how to do graphing. We also used more variables and methods than planned, as changes due to technical difficulties as well as for visual sake (Eg: Separating actionevent commands into individual commands rather than having it all be in actionevent).

Responsibilities:
Alex:
Line graph of stock history, non-main classes, commands pertaining to customers, interactions between stocks and customers.
Pranav:
Sorting, file reading, all graphics in the main class, commands pertaining to stocks.
