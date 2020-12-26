package com.training.services;

import java.io.*;
import java.util.List;

/**
 * 
 * @author vatsan
 * 
 */
public class ProfessorService {

	     
	 
	 
	 
       public boolean writeToTextFile(Object l1,File file) {
		 
		 boolean result = false;
		 
		 try (PrintWriter writer = new PrintWriter(new FileWriter(file,true))){
			
			 writer.println(l1);
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
		 
		
}