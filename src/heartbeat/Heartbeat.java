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
//        values.add( "donezo" );
        //imports settings
        Scanner settings = new Scanner( new File( "C:\\Users\\k1330132\\Desktop\\NetBeansProjects\\Heartbeat\\src\\heartbeat\\500\\settings.txt" ));
        
        while( settings.hasNextLine() ){
            String[] ymxtb = settings.nextLine().split("\\s+");
            if( ymxtb[1].equals( "Name:" ) ){
                name = ymxtb[2] + " " + ymxtb[3];
                System.out.println( name );
            }
            else if( ymxtb[1].equals( "Email:") ){
                email = ymxtb[2];
                System.out.println( email );
            }
        }
        
        //actual logic time
        for( File ahh : list ){
            String messId = "notastringdonttrip";
            Scanner f = new Scanner( ahh );
            //sets messId
            while( f.hasNext() ){
                String line = f.nextLine();
                if( line.equals( "" ) ){
                    break;
                }
                if( line.contains( "Message-ID" ) ){
                    String[] substring = line.split( "\\s+" );
                    messId = substring[1];
//                    System.out.println(messId);
                }                
            }
            int orka = 0;
            Scanner nova = new Scanner( ahh );
            //OK FUCKING REAL LOGIC NOW ONE SEC
            while( nova.hasNextLine() ){
                String line = nova.nextLine();
                if( line.contains("From:" ) || line.contains( "To:") ){
                    String[] asjd = line.split(" ");
                    if( line.contains( name ) ){
                        if( ! containsID( messId ) ){
                            if( containsWords( ahh ) ){
//                                System.out.println( ahh.toString() );
                                values.add( ahh.toString() );
                            }
                        }
//                        System.out.println( ahh.toString() );
                    }
//                    System.out.println( line );
//                    System.out.println( name );
//                    System.out.println( line.contains( name ));
                }               
            }
        }   
        
        //out prints the list of messages that need to be checked
        System.out.println("");
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
    
    public static boolean containsWords( File winRar ) throws Exception{
        
        Scanner f = new Scanner( winRar );
        
        String bin = "";
        
        while( ! f.nextLine().equals( "" ) ){
            //skip lul
        }
        
        while( f.hasNext() ){
            
            bin += f.next() + " ";
            
        }
        
        if( bin.contains( "CLASSIFIED" ) || bin.contains( "SECRET") || bin.contains( "EYES ONLY" ) ){
            return true;
        }
        
        
        return false;
    }
    
}
