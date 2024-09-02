class Account:
    def __init__(self, account_number, holder_name, balance=0.0):
        self.__account_number = account_number
        self.__holder_name = holder_name
        self.__balance = balance

    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount
            print(f"Deposited {amount}. New balance: {self.__balance}")
        else:
            print("Invalid deposit amount.")

    def withdraw(self, amount):
        if 0 < amount <= self.__balance:
            self.__balance -= amount
            print(f"Withdrew {amount}. New balance: {self.__balance}")
        else:
            print("Invalid or insufficient amount for withdrawal.")

    def get_balance(self):
        return self.__balance

    def display_details(self):
        print(f"Account Number: {self.__account_number}")
        print(f"Holder Name: {self.__holder_name}")
        print(f"Balance: {self.__balance}")


class SavingsAccount(Account):
    def __init__(self, account_number, holder_name, balance=0.0, interest_rate=0.02):
        super().__init__(account_number, holder_name, balance)
        self.__interest_rate = interest_rate

    def apply_interest(self):
        interest = self.get_balance() * self.__interest_rate
        self.deposit(interest)
        print(f"Applied interest: {interest}. New balance: {self.get_balance()}")


class CheckingAccount(Account):
    def __init__(self, account_number, holder_name, balance=0.0, overdraft_limit=500):
        super().__init__(account_number, holder_name, balance)
        self.__overdraft_limit = overdraft_limit

    def withdraw(self, amount):
        if 0 < amount <= self.get_balance() + self.__overdraft_limit:
            new_balance = self.get_balance() - amount
            if new_balance < 0:
                print(f"Overdraft used. New balance: {new_balance}")
            super().withdraw(amount)
        else:
            print("Invalid or insufficient amount for withdrawal (including overdraft limit).")


# Example usage
savings_account = SavingsAccount(account_number="SA123", holder_name="John Doe", balance=1000)
checking_account = CheckingAccount(account_number="CA123", holder_name="Jane Doe", balance=500)

savings_account.deposit(500)
savings_account.apply_interest()
savings_account.withdraw(300)
savings_account.display_details()

checking_account.deposit(200)
checking_account.withdraw(800)
checking_account.display_details()
