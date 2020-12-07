package example;

public class MobileBill {

	
	private String custName;
	private String mobNumber;
	private int amount;
	
	public static final String planName  = "Airtel";
	
	public MobileBill() {
		}
	
	public MobileBill(String custName, String mobNumber) {
		
		this(custName,mobNumber,0);
		
		this.custName = custName;
		this.mobNumber = mobNumber;
	}

	public MobileBill(String custName, String mobNumber, int amount) {
		super();
		this.custName = custName;
		this.mobNumber = mobNumber;
		this.amount = amount;
	}

	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getMobNumber() {
		return mobNumber;
	}


	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	
	
}
