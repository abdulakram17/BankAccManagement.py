<h1>BankAccManagement.py</h1>
Bank Account Simulation is a Python project that models a basic banking system, allowing users to perform essential operations such as deposits, withdrawals, and balance inquiries. The simulation uses Object-Oriented Programming (OOP) principles to create a realistic and flexible framework for managing different types of accounts.
Key Features
Object-Oriented Design: The project utilizes Python’s OOP capabilities to create a modular and reusable code structure. It features a base Account class and two specialized subclasses: SavingsAccount and CheckingAccount.
Encapsulation: Sensitive data, such as account balances, is protected using encapsulation techniques to prevent unauthorized access and modification.
Polymorphism: The withdraw method is overridden in both SavingsAccount and CheckingAccount classes, demonstrating polymorphic behavior based on account type.
Interest Calculation for Savings Accounts: The SavingsAccount class includes functionality for applying interest, enhancing the realism of the simulation.
Overdraft Protection for Checking Accounts: The CheckingAccount class supports overdraft limits, allowing withdrawals beyond the current balance up to a specified limit.
User-Friendly Operations: The code is designed to be simple and intuitive, making it easy for users to perform common banking operations and view account details.
How to Use
Clone the repository to your local machine.
Run the bank_simulation.py file using Python.
Follow the prompts to create accounts, deposit or withdraw funds, and check balances.
This project is ideal for those interested in learning OOP in Python or simulating basic banking operations. Contributions and suggestions for improvements are welcome!
