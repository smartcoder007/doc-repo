package jdk7;

//String in Switch
public class SwitchStatement {

	public static void main(String args[]) {
		String state = "NEW";
		switch (state) {
		case "NEW":
			System.out.println("Order is in NEW state");
			break;
		case "CANCELED":
			System.out.println("Order is Cancelled");
			break;
		case "REPLACE":
			System.out.println("Order is replaced successfully");
			break;
		case "FILLED":
			System.out.println("Order is filled");
			break;
		default:
			System.out.println("Invalid");
		}

	}

}
