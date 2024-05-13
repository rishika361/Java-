import java.util.*;
import java.text.*;

class Account {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00");
	private int CN;
	private int PN;
	private double CB = 2000;
	private double SB = 1000;

	void setCustomerNumber(int a) {
		CN = a;
	}

	void setPinNumber(int b) {
		PN = b;
	}

	int getCustomerNumber() {
		return CN;
	}

	int getPinNumber() {
		return PN;
	}

	double getCurrentBalance() {
		return CB;
	}

	double getSavingBalance() {
		return SB;
	}

	void getCurrentWithdrawInput() {
		System.out.println("Your current account balance : " + df.format(CB));
		System.out.println("Please enter the amount");
		double amount = sc.nextDouble();

		if ((CB - amount) >= 0) {
			calcCurrentWithdraw(amount);
			System.out.println("your new current account balance is :" + df.format(CB));
		} else {
			System.out.println("your balance is insufficient for this transaction");
		}

	}

	double calcCurrentWithdraw(double amount) {
		CB = CB - amount;
		return CB;
	}

	void getCurrentDepositInput() {
		System.out.println("Your current account balance : " + df.format(CB));
		System.out.println("Please enter the amount you want to deposit");
		double amount = sc.nextDouble();
		if ((CB + amount) >= 0) {
			calcCurrentDeposit(amount);
			System.out.println("Your new current account balance is:" + df.format(CB));
		} else {
			System.out.println("Please enter the valid amount");
		}

	}

	double calcCurrentDeposit(double amount) {
		CB = CB + amount;
		return CB;
	}

	void getSavingWithdrawInput() {
		System.out.println("Your current account balance : " + df.format(SB));
		System.out.println("Please enter the amount");
		double amount = sc.nextDouble();

		if ((SB - amount) >= 0) {
			calcSavingWithdraw(amount);
			System.out.println("your new current account balance is :" + df.format(SB));
		} else {
			System.out.println("your balance is insufficient for this transaction");
		}

	}

	double calcSavingWithdraw(double amount) {
		SB = SB - amount;
		return SB;
	}

	void getSavingDepositInput() {
		System.out.println("Your current account balance : " + df.format(SB));
		System.out.println("Please enter the amount you want to deposit");
		double amount = sc.nextDouble();
		if ((SB + amount) >= 0) {
			calcSavingDeposit(amount);
			System.out.println("Your new current account balance is:" + df.format(SB));
		} else {
			System.out.println("Please enter the valid amount");
		}
	}

	double calcSavingDeposit(double amount) {
		SB = SB + amount;
		return SB;
	}

}

class Optionmenu extends Account {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00");

	void getLogin() {
		int x = 1;
		do {
			try {
				hm.put(11111, 111);
				hm.put(22222, 222);
				hm.put(33333, 333);
				hm.put(44444, 444);
				hm.put(55555, 555);

				System.out.println("welcome to MSBECL ATM" + "\n");
				System.out.print("Enter your customer number : ");
				setCustomerNumber(sc.nextInt());
				System.out.print("Enter your PIN number : ");
				setPinNumber(sc.nextInt());

				int p = getCustomerNumber();
				int q = getPinNumber();
				if (hm.containsKey(p) && hm.get(p) == q) {
					getAccountType();
				} else {
					System.out.println("Please enter the valid customer and pin number.");
				}

				getCustomerNumber();
				getPinNumber();

			} catch (InputMismatchException e) {
				System.out.println("\n" + "Please enter only numbers" + "\n" + "Characters and symbols not allowed");
				x = 2;
			}
		} while (x == 1);
	}

	void getAccountType() {
		System.out.println("\n" + "Select the account type you want to access");
		System.out.println("Type 1 - Current account");
		System.out.println("Type 2 - Saving account");
		System.out.println("Type 3 - Exit");
		System.out.print("Enter your choice");
		int choice = sc.nextInt();
		switch (choice) {
			case 1: {
				getCurrent();
				break;
			}
			case 2: {
				getSaving();
				break;
			}
			case 3: {
				System.out.println("Thank you for visiting.Visit again");
				break;
			}
			default: {
				System.out.println("Invalid choice.Please enter the valid choice");
				break;
			}
		}
	}

	void getCurrent() {
		// Current account
		System.out.println("Current account");
		System.out.println("\n" + "Type 1 - View balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Deposit funds");
		System.out.println("Type 4 -Exit");
		System.out.print("Enter your choice");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
			case 1: {
				System.out.println("Your current account balance : " + df.format(getCurrentBalance()));
				getAccountType();
				break;
			}
			case 2: {
				getCurrentWithdrawInput();
				break;
			}
			case 3: {
				getCurrentDepositInput();
				break;
			}
			case 4: {
				System.out.println("Thank you for visiting");
				break;
			}
			default: {
				System.out.println("Invalid input");
				break;
			}
		}
	}

	void getSaving() {
		// Saving account
		System.out.println("Saving account");
		System.out.println("\n" + "Type 1 - View balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Deposit funds");
		System.out.println("Type 4 -Exit");
		System.out.print("Enter your choice");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
			case 1: {
				System.out.println("Your current account balance : " + df.format(getSavingBalance()));
				getAccountType();
				break;
			}
			case 2: {
				getSavingWithdrawInput();
				break;
			}
			case 3: {
				getSavingDepositInput();
				break;
			}
			case 4: {
				System.out.println("Thank you for visiting");
				break;
			}
			default: {
				System.out.println("Invalid input");
				break;
			}
		}
	}
}

public class ATM extends Optionmenu {

	public static void main(String[] args) {
		Optionmenu op = new Optionmenu();
		op.getLogin();

	}

}
