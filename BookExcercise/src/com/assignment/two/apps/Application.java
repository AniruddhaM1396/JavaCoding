package com.assignment.two.apps;

import java.util.Scanner;

import com.assignment.two.services.BookService;
import com.assignment.two.Book;

public class Application {
 public static void main(String[] args) {
	 Book book123 = new Book(101, "wings", "APJ", 400.00);


		BookService service = new BookService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Customer");

		String CustomerType = sc.next();

		double Cdiscount = service.calculateDiscount(book123);

		System.out.println( " Discount :="+ Cdiscount);

		double sdiscount = service.calculateDiscount(book123,CustomerType);

		System.out.println("Discount :="+ sdiscount);

		sc.close();
 }
}
