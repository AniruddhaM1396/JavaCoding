package com.training;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.training.services.ContactService;
import com.training.daos.ContactDaoImpl;
import com.training.entity.Address;
import com.training.entity.Contact;
import com.training.ifaces.DataAccess;


public class Application {

	public static void main(String[] args) {
		File textFile = new File("ContactAdd.txt");
		File File1 = new File("Birthday.txt");
		File File2 = new File("InsertData.txt");
		ContactService service = new ContactService();
        int  key=9;

        DataAccess<Contact,Address> dao = new ContactDaoImpl();

		switch (key) {
		case 1:
			Contact details = new Contact("Apurv", 1324973,"image4.jpg", 
					    LocalDate.of(1998, Month.OCTOBER, 27),"apurv@gmail","Personal Friend");
			Address address = new Address(1324973,"Vayalikaval", "Bijapur","Karnataka");
			int ContactAdded =dao.add(details,address);
			System.out.println("Row Added :="+ ContactAdded);
			List<Object> l1 =new ArrayList<Object>();
			l1.add(details);
			l1.add(address);
			for(Object o1 : l1) {
			System.out.println("Is added :=" +service.writeObjToTextFile(o1, File2));
			}
			break;
		case 2:
			Contact ExistingCon = new Contact("Apurv", 1324973,"image4.jpg", 
				    LocalDate.of(1998, Month.OCTOBER, 27),"apurv@gmail","Personal Friend");
			Address ExistingAdd = new Address(1324973,"Vayalikaval", "Bijapur","Karnataka");
			Contact UpdateCon = new Contact("Abhi", 1324973,"image5.jpg", 
				    LocalDate.of(1998, Month.AUGUST, 27),"abhi@gmail","Relative");
			Address UpdateAdd = new Address(1324973,"Lower Orchad", "Belgavi","Karnataka");
			int ContactUpdated =dao.update(ExistingCon,UpdateCon, ExistingAdd,UpdateAdd);
			System.out.println("Contact Updated :="+ ContactUpdated);
			break;
		case 3:
			int rowDeleted = dao.remove(1324973);
			System.out.println("Row deleted :="+ rowDeleted);
			break;
		case 4:
			dao.findAll().stream().forEach(System.out::println);
			break;
		case 5:
			dao.ListNameCity();
			break;
		case 6:
			service.clearTheFile(File1);
			List<Object> Bday = dao.Birthday("AUGUST");
			System.out.println(Bday);
			for(Object BdayList : Bday) {
				System.out.println("Is added :=" +service.writeObjToTextFile(BdayList,File1));
			}
			break;
		case 7:
			dao.displayAsc();
			break;
		case 8:
			List<Object> detailsFile = service.readFromTextFile(File2);
			
			int ContactAddedFromFile =dao.add((Contact) detailsFile.get(0),(Address) detailsFile.get(1));
			System.out.println("Row Added :="+ ContactAddedFromFile);
			break;
		case 9:
			
			List<Object> contactGroup=dao.findByGroup("Personal Friend");
			System.out.println(contactGroup);
			
			for(int i = 0;i<contactGroup.size();i++) {
			System.out.println("Is added :=" +service.writeToTextFile((Contact) contactGroup.get(i), textFile));
			}
			break;
			default:
			break;
		}
	}
}
