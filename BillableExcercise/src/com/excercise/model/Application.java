package com.excercise.model;
import com.excercise.services.BillService;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Software eng1 = new Software("Developer",100,"Ram");
		BillService service = new BillService();
		service.print(eng1);
		Software eng2= new Software("Manager",101,"Raju");
		service.print(eng2);
		Advocate advo1= new Advocate("High Court",201,"Ram");
		service.print(advo1);
	}

}
