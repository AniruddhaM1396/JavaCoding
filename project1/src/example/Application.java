package example;

class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobileBill ramesh = new MobileBill("Ramesh","1234567890",67);
		
		System.out.println(ramesh.getCustName());
		System.out.println(ramesh.getMobNumber());
		System.out.println(ramesh.getAmount());
		
		System.out.println(" Ramesh - plan:= "+ MobileBill.planName);
	}

}
