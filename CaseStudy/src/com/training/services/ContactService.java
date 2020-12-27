package com.training.services;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Address;
import com.training.entity.Contact;

public class ContactService {
       public boolean writeToTextFile(Contact contact,File file) {
		 
		 boolean result = false;
		 
		 try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
			
			 writer.println(contact);
			 //writer.print(l1+",");
			 result =true;
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	      return result;
       }
       public boolean writeObjToTextFile(Object contact,File file) {
  		 
  		 boolean result = false;
  		 
  		 try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
  			
  			 writer.println(contact);
  			 //writer.print(l1+",");
  			 result =true;
  			 
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	      return result;
         }
       
       public void clearTheFile(File file) {
    	   try (PrintWriter writer = new PrintWriter(new FileWriter(file,false))){
           writer.flush();
           writer.close();
           //fwOb.close();
    	   } catch (IOException e) {
   			e.printStackTrace();
   		}
       }
       
       public List<Object> readFromTextFile(File file) {
			
			//Contact[] list = new Contact[1];
    	   List<Object> ContactAddress =new ArrayList<Object>();
			String line =null;
			//Contact details = new Contact();
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			
				int i = 0;
				while( (line = reader.readLine())!=null) {
					
					String[] values = line.split(",");
					
					Contact details = new Contact(values[0],Integer.parseInt(values[1]), 
							  values[2],LocalDate.parse(values[3]), values[4],values[5]);
					Address address = new Address(Integer.parseInt(values[6]),values[7],values[8],values[9]);
							ContactAddress.add(details);
							ContactAddress.add(address);
					i++;
				}

			}catch(IOException e) {
				 e.printStackTrace();
			}
			System.out.println(ContactAddress);
			return ContactAddress ;
			
       }	
}