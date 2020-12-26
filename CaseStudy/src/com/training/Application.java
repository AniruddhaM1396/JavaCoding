package com.training;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.training.services.ProfessorService;
import com.training.daos.ContactDaoImpl;
import com.training.entity.Address;
import com.training.entity.Contact;
import com.training.ifaces.DataAccess;


public class Application {

	public static void main(String[] args) {
		File textFile = new File("DoctorAdd.txt");
		//DoctorService service = new DoctorService();
		ProfessorService service = new ProfessorService();
        int  key=5;

        DataAccess<Contact,Address> dao = new ContactDaoImpl();

		switch (key) {
		case 1:
			Contact details = new Contact("Apurv", 13249,"image4.jpg", 
					    LocalDate.of(1998, Month.OCTOBER, 27),"apurv@gmail","Personal Friend");
			Address address = new Address(13249,"Vayalikaval", "Bijapur","Karnataka");
			int ContactAdded =dao.add(details,address);
			System.out.println("Row Added :="+ ContactAdded);
			List<Object> l1 =new ArrayList<Object>();
			l1.add(details);
			l1.add(address);
			for(Object o1 : l1) {
			System.out.println("Is added :=" +service.writeToTextFile(o1, textFile));
			}
			break;
		
	case 2:
		int rowDeleted = dao.remove(1672432);
		System.out.println("Row deleted :="+ rowDeleted);
		break;
	case 3:
		  dao.findAll().stream().forEach(System.out::println);
		break;
	case 4:
		dao.ListNameCity();
		break;
	case 5:
		service.clearTheFile(textFile);
		List<Object> l2 = dao.Birthday("October");
		for(Object o1 : l2) {
		System.out.println("Is added :=" +service.writeToTextFile(o1, textFile));
		}
		break;
	case 6:
		dao.displayAsc();
		break;
	default:
		break;
		}
	}
}
