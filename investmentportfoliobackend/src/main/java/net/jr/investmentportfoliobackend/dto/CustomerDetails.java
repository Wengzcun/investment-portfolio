package net.jr.investmentportfoliobackend.dto;

public class CustomerDetails {
	private static int customerID;
	private static String customerEmail;
	private static long customerPhone;
	private static String customerPAN;
	private static String customerPWD;
	private static boolean isActive=false;
	public static int getCustomerID() {
		return customerID;
	}
	public static void setCustomerID(int customerID) {
		CustomerDetails.customerID = customerID;
	}
	public static String getCustomerEmail() {
		return customerEmail;
	}
	public static void setCustomerEmail(String customerEmail) {
		CustomerDetails.customerEmail = customerEmail;
	}
	public static long getCustomerPhone() {
		return customerPhone;
	}
	public static void setCustomerPhone(long customerPhone) {
		CustomerDetails.customerPhone = customerPhone;
	}
	public static String getCustomerPAN() {
		return customerPAN;
	}
	public static void setCustomerPAN(String customerPAN) {
		CustomerDetails.customerPAN = customerPAN;
	}
	public static String getCustomerPWD() {
		return customerPWD;
	}
	public static void setCustomerPWD(String customerPWD) {
		CustomerDetails.customerPWD = customerPWD;
	}
	public static boolean isActive() {
		return isActive;
	}
	public static void setActive(boolean isActive) {
		CustomerDetails.isActive = isActive;
	}
	
	
	

}