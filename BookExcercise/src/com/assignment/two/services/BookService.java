package com.assignment.two.services;

import com.assignment.two.Book;

	public class BookService {
		public double calculateDiscount(Book book123) {
		 double discount;
		

		 // Objects like String should be compared with .equals and not  ==
		 if(book123.getPrice()<5000) {
			 discount = book123.getPrice() * 0.05;

			 // can also case in-sensitive comparison with ignore case
		  } else {

			 discount =  book123.getPrice() * 0.1;
		  } 

		 	 	 return discount;


	}
		
		public double calculateDiscount(Book book123,String customerType) {
			 double discount;
			

			 // Objects like String should be compared with .equals and not  ==
			 if(customerType.equals("Corporate")) {
				 discount = book123.getPrice() * 0.05;

				 // can also case in-sensitive comparison with ignore case
			  } else if(customerType.equals("Retail")){

				 discount =  book123.getPrice() * 0.1;
			  } else {
				  discount =  book123.getPrice() * 0.2;
			  }

			 	 	 return discount;


		}
}
