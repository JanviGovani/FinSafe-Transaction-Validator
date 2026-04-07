FinSafe Transaction Validator 🛡️💰
FinSafe is a robust, console-based digital wallet application built with Java. It addresses the business challenge of "Overdraft" errors by implementing real-time transaction validation, custom exception handling, and secure data management.

🚀 Business Case
Digital wallets often face synchronization issues where users spend more than their actual balance. FinSafe solves this by:

Enforcing Strict Encapsulation of account data.

Implementing Custom Exception Handling to block unauthorized overdrafts.

Maintaining a Sliding Window History (last 5 transactions) for audit purposes.

🛠️ Features
Secure Deposits: Validates that only positive amounts are added.

Safe Withdrawals: Prevents overdrafts using a custom InSufficientFundsException.

Transaction Guard: Uses IllegalArgumentException to block negative or zero-value inputs.

Mini Statement: Displays a history of the last 5 successful withdrawals using the Java Collections Framework.

💻 Tech Stack & Concepts Used
Language: Java 17+

OOP Principles: * Encapsulation: Used private access modifiers and public getters to protect sensitive financial data.

Abstraction: Leveraged clear method signatures to hide complex validation logic from the end-user.

Collections: Utilized ArrayList for dynamic transaction tracking.

Error Handling: Implemented try-catch blocks and custom Throwable classes.

📂 Project Structure
Plaintext
├── Account.java                   # Core logic and data management
├── InSufficientFundsException.java # Custom business-logic exception
└── FinSafeApp.java                # Main entry point and User Interface
📸 Screenshots / Demo
Note to Janvi: Run your program in the VS Code terminal and take 2-3 screenshots:

A successful withdrawal.

An error message when you try to withdraw more than your balance.

The Mini Statement after 6 transactions (to show only 5 remain).
Paste the images here in your GitHub repo!

⚙️ How to Run
Clone this repository.

Open the folder in VS Code.

Compile and run FinSafeApp.java.

Follow the on-screen menu to perform banking operations.