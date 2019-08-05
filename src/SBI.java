import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author venbatchu
 *
 */
interface Bank {
	public void setFirstName();

	public void setLastName();

	public void setPhoneNumber();

	public void setEmployeeId();

	public void setAddress();

	public boolean getLoanEligibility();

	public void setCurrentBal();

	public void setParentsBal();

}

public class SBI implements Bank {

	String firstname;
	String lastname;
	long phoneNumber;
	long employeeid;
	List address;
	long currentBalance;
	long parentsBalance;
	Scanner sc = new Scanner(System.in);

	@Override
	public void setFirstName() {
		// TODO Auto-generated method stub
		System.out.print("Enter first name: ");
		this.firstname = sc.next();
	}

	@Override
	public void setLastName() {
		// TODO Auto-generated method stub
		System.out.print("Enter last name: ");
		this.lastname = sc.next();
	}

	@Override
	public void setPhoneNumber() {
		// TODO Auto-generated method stub
		System.out.print("Enter phone number: ");
		this.phoneNumber = sc.nextLong();
	}

	@Override
	public void setEmployeeId() {
		// TODO Auto-generated method stub
		System.out.print("Enter employee id: ");
		this.employeeid = sc.nextLong();
	}

	@Override
	public void setAddress() {
		// TODO Auto-generated method stub
		address = new ArrayList();
		System.out.print("Enter city: ");
		String city = sc.next();
		System.out.print("Enter House No: ");
		String houseNo = sc.next();
		System.out.print("Enter pincode: ");
		long pincode = sc.nextLong();
		System.out.print("Enter area: ");
		String area = sc.next();
		System.out.print("Enter street: ");
		String street = sc.next();

		address.add(city);
		address.add(houseNo);
		address.add(pincode);
		address.add(area);
		address.add(street);

	}

	@Override
	public boolean getLoanEligibility() {
		// TODO Auto-generated method stub
		System.out.print("Enter loan amount: ");
		long loanAmount = sc.nextLong();
		if (loanAmount > 10000000) {
			System.out.println("Loan cannot be granted for amount greater than 1 crore");
		}
		System.out.print("Enter loan type (Home, Education, Personal, Travel): ");
		String type = sc.next();
		switch (type) {
		case "Home": {
			if (this.currentBalance >= 1000000) {
				System.out.println("Loan has been granted at a compund interest rate 6%");
				return true;
			} else {
				System.out.println("Loan request denied");
				return false;
			}
		}
		case "Education": {
			if (this.parentsBalance >= 500000) {
				System.out.println("Loan has been granted at a compund interest rate 8%");
				return true;
			} else {
				System.out.println("Loan request denied");
				return false;
			}
		}
		case "Personal": {
			System.out.println("Loan has been granted at a compund interest rate 5%");
			return true;
		}
		default: {
			if (this.currentBalance >= 5000000) {
				System.out.println("Loan has been granted at a simple interest rate 1%");
				return true;
			} else {
				System.out.println("Loan request denied");
				return false;
			}
		}
		}
	}

	@Override
	public void setCurrentBal() {
		// TODO Auto-generated method stub
		System.out.print("Enter current balance: ");
		long bal = sc.nextLong();
		this.currentBalance = bal;
	}

	@Override
	public void setParentsBal() {
		// TODO Auto-generated method stub
		System.out.print("Enter current balance: ");
		long bal = sc.nextLong();
		this.parentsBalance = bal;
	}

}