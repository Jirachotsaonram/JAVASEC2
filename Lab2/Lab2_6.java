package Lab2; 
// Lab 2-6 
// File name : Lab2_6.java 
// Print information from class. 

public class Lab2_6 { 
    public Lab2_6() { 
        System.out.println("Create object from Class Information" ); 
        System.out.println( "Id : 5066269999" ); 
        System.out.println( "Name : Somchai Cheingpongpan" ); 
        System.out.println( "Department : Information Technology" ); 
        System.out.println( "Class : 1RB" ); 
    } 

    public Lab2_6(String id, String name, String dept, String classes) { 
        System.out.println("Create object from Class Information" ); 
        System.out.println( "Id : " + id ); 
        System.out.println( "Name : " + name ); 
        System.out.println( "Department : " + dept); 
        System.out.println( "Class : " + classes); 
    } 
     
    /** 
     * @param args the command line arguments 
     */ 
    public static void main(String[] args) { 
        
        // create object from class Lab2_6 
        System.out.println( "===============================" ); 
        Lab2_6 info = new Lab2_6(); 
        Lab2_6 infono = new Lab2_6("676021445678","jirachot sa-onram","ITI","RB"); 
        System.out.println( "===============================" ); 
    }   
}