# Question:
```
Write a JAVA Menu driven program that does the following:
You can ONLY have the below variables as global variables
Account Number
Account Holder Name
Account Balance
You MUST have the below as functions
To initialize the customer
To deposit money
To withdraw money
To print the transactions
To print account summary
Your menu will have the following operations once the customer is created
To deposit money
To withdraw money
To print the transactions
To print account summary
You need to draw a flowchart and structure your results and program description, and other details in README.md.
Before working on the code, write the logic (algorithm/flowchart) in your observation note.
```

# Flow Chart


## How to Run the program:
```
--> To compile the program, type "javac Lab4.java".
--> To run the program, type "java Lab4"
```

## Constraints:
```
--> The amounts cannot contain any character in it.
--> It should be an Integer or a decimal point value only.
--> The customer can be initialized only once.
```

## Sample Output:
```
=================================================================================
Enter the Name of the Customer:Karan Punjabi
Enter the Account Number of the Customer:22122140
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:3
=================================================================================
=================================================================================
=================================================================================
No Transactions to print.
=================================================================================
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:1
=================================================================================
=================================================================================
Enter the amount you want to deposit:1000
=================================================================================
=================================================================================
Deposit Successfull
Updated Balance: 1000.0
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:3
=================================================================================
=================================================================================
DateTime:2023-02-22 12:25:39.596 Previous Balance:0.0 Updated Balance: 1000.0 Type: Deposit Amount: 1000.0 Status: Success
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:2
=================================================================================
=================================================================================
Enter the amount you want to withdraw:2000
=================================================================================
=================================================================================
Error! Insufficient Balance.
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:2
=================================================================================
=================================================================================
Enter the amount you want to withdraw:699
=================================================================================
=================================================================================
Withdraw Successfull
Updated Balance: 301.0
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:3
=================================================================================
=================================================================================
DateTime:2023-02-22 12:25:39.596 Previous Balance:0.0 Updated Balance: 1000.0 Type: Deposit Amount: 1000.0 Status: Success 
DateTime:2023-02-22 12:26:15.119 Previous Balance:1000.0 Updated Balance:301.0 Type: Withdraw Amount: 699.0 Status: Success=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:1
=================================================================================
=================================================================================
Enter the amount you want to deposit:140
=================================================================================
=================================================================================
Deposit Successfull
Updated Balance: 441.0
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:3
=================================================================================
=================================================================================
DateTime:2023-02-22 12:25:39.596 Previous Balance:0.0 Updated Balance: 1000.0 Type: Deposit Amount: 1000.0 Status: Success 
DateTime:2023-02-22 12:26:15.119 Previous Balance:1000.0 Updated Balance:301.0 Type: Withdraw Amount: 699.0 Status: SuccessDateTime:2023-02-22 12:26:45.622 Previous Balance:301.0 Updated Balance: 441.0 Type: Deposit Amount: 140.0 Status: Success 
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:4
=================================================================================
=================================================================================
Account Holder Name: Karan Punjabi
Account Number: 22122140
Total Balance: 441.0
=================================================================================
=================================================================================
1) Deposit Money.
2) Withdraw Money.
3) Print Transactions.
4) Print Account Summary.
5) Exit.
=================================================================================
Please Enter your choice:5
=================================================================================
```