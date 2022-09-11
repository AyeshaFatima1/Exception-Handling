package com.threads;

import java.util.Scanner;

class Account {
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
	class TransactionDeposit implements Runnable {
		int amount;
		Account accountX;
		
		TransactionDeposit(Account x, int amount) {
			accountX = x;
			this.amount = amount;
			new Thread(this).start();
		}

		public void run() {
			accountX.deposit(amount);
		}
	}

//end TransactionDeposit class
	class TransactionWithdraw implements Runnable {
		int amount;
		Account accountY;

		TransactionWithdraw(Account y, int amount) {
			accountY = y;
			this.amount = amount;
		    new Thread(this).start();
					}

		public void run() {
			accountY.withdraw(amount);
		}
	}
//end of class TransactionWithdraw
	public class BankSync {

		public static void main(String[] args) {
			Account A = new Account();
			A.balance = 1000;
			A.accountNo = 123;
			/*Scanner s=new Scanner(System.in);
			int damount=300;
			TransactionDeposit t1;
			TransactionWithdraw t2;
			t1 = new TransactionDeposit(A, damount);
			t2 = new TransactionWithdraw(A, damount);*/
			Scanner s=new Scanner(System.in);
			System.out.println("Enter amount to Deposit:");
		    int d=s.nextInt();
            System.out.println("Enter withdraw amount:");
            int w=s.nextInt();
            TransactionDeposit t1;
			TransactionWithdraw t2;
            t1 = new TransactionDeposit(A,d);
			t2 = new TransactionWithdraw(A,w);
		}

	}
