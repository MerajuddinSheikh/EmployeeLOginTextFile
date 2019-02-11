package employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class LoginDetails {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		 ArrayList <String>words= new  ArrayList<String>();
		   String setNightTimeStart="09/01/19 21:30:00";
		    String setNightTimeEnd="09/01/19 22:59:45";
		    String setnightTimeBeyond="09/01/19 23:00:00";
		    int countif = 0;
			int countelse = 0;
		 
	        try{
	        FileReader fr = new FileReader("d:\\sample1.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String Lines= br.readLine();
	        //String lines= " ";
	        while (Lines  !=null){
	             //lines += Lines + " \n";
	            words.add(Lines);

	            Lines=br.readLine();

	        }
	        br.close();
	        fr.close();
	            //System.out.println(words.size());
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        

	                 String name=" "; 
	                 int count=0;
	                int empID = 0;
	 				String empName = "";
	 			    String empDepartment = " ";
	 				String empDate = " ";
	 				String empWorkedHours = " ";
	 				String empSetHours = " ";
	 				//String nullValue="";
	 				String empLoginTime = " ";
	 				String empLogoutTime = " ";
	 				String empComfirmHour = " ";
	 				int nightHour=21;
	 				int nightMinut=30;
	 				int nightEnd=23;
	 				//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
	 			   // DateFormat df = new SimpleDateFormat("HH:mm");
	 			   //Date setTime = df.parse(empSetHours);
	              for(String wk : words){

	                  StringTokenizer sz =new StringTokenizer(wk,",");
	                 
	               //   System.out.println(sz.countTokens());

	                   count =1;
	                  while(sz.hasMoreElements()){

	                      String token1=sz.nextToken();

	                     // System.out.println(token1);
	                      switch (count) {
	                         case 1: {
	                               empID = Integer.parseInt(token1); 
	                              break;
	                          }
	                          case 2: {
	                               name = token1; 
	                              break;
	                          }
	                          case 3: {
	                               empDepartment =token1; 
	                              break;
	                          }
	                          
	                          case 4: {
	                               empDate = token1; 
	                              break;
	                          }
	                          case 5: {
	                               empWorkedHours = token1;
	                              break;
	                          }
	                          case 6: {
	                               empSetHours =token1; 
	                              break;
	                          }
	                          
	                          
	                          case 7: {
	                               empLoginTime = token1; // first token is rollno
	                              break;
	                          }
	                          case 8: {
	                               empLogoutTime = token1; 
	                              break;
	                          }
	                          case 9: {
	                               empComfirmHour =token1; 
	                              break;
	                          }
	                           
	                          
	                          
	  	  				    }
	                  
	                     
	                      count++;
	                  } // while loop ends here
	                  
	                  
	                  
	                  SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	                  DateFormat stf = new SimpleDateFormat("HH:mm");
	                  /*String nightTimeStart="21:30";
	                  String nightTimeEnd="23:00";*/
	                  Date set=null;
	                  Date empExit = null;
	                  Date empWork = null;
	                  //Date d3 = null;   
	                  try {
	                	  empExit = sdf.parse(empLogoutTime);
	                	 // empIn = sdf.parse(empLoginTime);
	                	  //d3 = sdf.parse(setTime);
	                	  
	                	  empWork = stf.parse(empWorkedHours);
	                	  set = stf.parse(empSetHours);
	                  } catch (ParseException e) {
	                	  e.printStackTrace();
	                  }
	                  
	                  // Get msec from each, and subtract.
	                  //long diff = empExit.getTime() - empIn.getTime();
	                  /*long empSetTime=set.getTime()/(60 * 60 * 1000);*/
	                 // long empWorkTime=empWork.getTime()/(60 * 60 * 1000) %24;
	                  //long diffSeconds = diff / 1000 % 60;
	                 // long diffMinutes = diff / (60 * 1000) % 60;
	                 // long diffHours = empWorkTime/ (60 * 60 * 1000) %24;
	                  
	                  //System.out.println(stf.format(set));
	                  //if(empWorkTime >= empSetTime){
	                  //if(set.getTime() >= empWork.getTime()){

	                  //System.out.println("set hours are" + empExit.getHours());
	                  //System.out.println("set hours are" + empExit.getMinutes());
	                  // System.out.println("worked hours are" + empWork.getHours());	                  
	                  
	                  if(empWork.getHours()>= set.getHours()){
	                	 // System.out.println("employee is present  and worked hours are greater than 8:00 ");
	                  }
	                	   if(empExit.getHours()> nightHour && empExit.getMinutes() > nightMinut || empExit.getHours()< nightEnd ){
	                		  //System.out.println("employee worked in between and hour minutes are " +empExit.getHours()+" "+empExit.getMinutes());
	                		  countif++; 
	                	  }
	                	   else{
	                		   //System.out.println("employee worked overnight");
	                		   countelse++;
	                	   }
	                	  /*if(empExit.getHours()>= set.getHours()){
	                		  
	                		  
	                	  }*/
	              	
	                  }
	                  
	                  
	                /*  System.out.println("Time in seconds: " + diffSeconds + " seconds.");
	                  System.out.println("Time in minutes: " + diffMinutes + " minutes.");
	                  System.out.println("Time in hours: " + diffHours + " hours.");*/
	                  
	              System.out.println("ID Name Shift1 Shift2");
	                 System.out.println(empID +" " + name +"  "+countif+"  " +countelse);
	                 // System.out.println(" emp id :" + rollno );
	                 /* System.out.println("employee department " + empDepartment);
	                  System.out.println(" date of work :" + empDate );
	                  System.out.println("total hour worked " + empWorkedHours);
	                  System.out.println(" set company hour :" + empSetHours );
	                  System.out.println("employee log in time " + empLoginTime);
	                  System.out.println(" employee log out time :" + empLogoutTime );
	                  System.out.println("total hourr worked :" + empComfirmHour );*/
	              //System.out.println(countif);          
	              

                  
                  //System.out.println(countelse); 
	                  
	              } // for loop ends here 
	              
	              
	             
}


	

	        

