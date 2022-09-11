package com.threads;

class Account1 {
	public int balance;
	public int accountNo;

	void displayBalance() {
		System.out.println("Account No:" + accountNo + " Balance:"+balance);
	}

synchronized void deposit(int amount) {
		balance = balance + amount;
		System.out.println(amount + " is deposited");
		displayBalance();
	}

synchronized void withdraw(int amount) {
		balance = balance - amount;
		System.out.println(amount + " is withdraw");
		displayBalance();
	}
}
	class TransactionDeposit1 implements Runnable {
		int amount;
		Account1 accountX;
		
		TransactionDeposit1(Account1 x, int amount) {
			accountX = x;
			this.amount = amount;
			new Thread(this).start();
		}

		public void run() {
			accountX.deposit(amount);
		}
	}

//end TransactionDeposit class
	class TransactionWithdraw1 implements Runnable {
		int amount;
		Account1 accountY;

		TransactionWithdraw1(Account1 y, int amount) {
			accountY = y;
			this.amount = amount;
			new Thread(this).start();
		}

		public void run() {
			accountY.withdraw(amount);
		}
	}
//end of class TransactionWithdraw
	public class BankSync2 {

		public static void main(String[] args) {
			Account1 A = new Account1();
			A.balance = 1000;
			A.accountNo = 123;
			TransactionDeposit1 t1;
			TransactionWithdraw1 t2;
			t1 = new TransactionDeposit1(A, 500);
			t2 = new TransactionWithdraw1(A, 600);

		}

	}
