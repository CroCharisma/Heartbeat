/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartbeat;

import java.util.*;
import java.io.*;

public class Heartbeat {

    
    public static void main(String[] args) throws Exception {
        
        String name = "";
        String email = "";
        
        //import folder containing emails to be checked
        File folder = new File( "C:\\Users\\k1330132\\Desktop\\NetBeansProjects\\Heartbeat\\src\\heartbeat\\500\\emails" );
        File[] list = folder.listFiles();
        List<String> values = new ArrayList();
        values.add( "test" );
        //imports settings
        Scanner settings = new Scanner( new File( "C:\\Users\\k1330132\\Desktop\\NetBeansProjects\\Heartbeat\\src\\heartbeat\\500\\settings.txt" ));
        
        while( settings.hasNextLine() ){
            String[] ymxtb = settings.nextLine().split("\\s+");
            if( ymxtb[1].equals( "Name:" ) ){
                name = ymxtb[2] + " " + ymxtb[3];
                //System.out.println( name );
            }
            else if( ymxtb[1].equals( "Email:") ){
                email = ymxtb[2];
                //System.out.println( email );
            }
        }
        
        //actual logic time
        for( File ahh : list ){
            String messId = "";
            Scanner f = new Scanner( ahh );
            for( String line = ""; !line.equals( "" ); line = f.nextLine() ){
                if( line.contains( "Message-ID") ){
                    String[] fuckkevinlol = line.split( "\\s+" );
                    messId = fuckkevinlol[1];
                }
                if( line.contains( "From" ) ){
                    
                }
            }
        }   
        
        //out prints the list of messages that need to be checked
        for( int i = 0; i < values.size(); i++ ){
            System.out.println( values.get( i ) );
        }
    }
    
    public static boolean containsID( String ID ) throws Exception{
        //import previous checked emails
        Scanner f = new Scanner( new File( "C:\\Users\\k1330132\\Desktop\\NetBeansProjects\\Heartbeat\\src\\heartbeat\\500\\scanned_emails.txt" ));
        
        while( f.hasNext() ){
            
            if( ID.equals( f.next() )){
                return true;
            }
            
        }
        
        return false;
        
    }
    
//    public static boolean containsWords(  ){
//        
//    }
    
}
