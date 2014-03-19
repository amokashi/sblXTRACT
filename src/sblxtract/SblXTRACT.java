package sblxtract;

/*
 * This file is part of sblXTRACT.
 *
 * sblXTRACT is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * sblXTRACT is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with sblXTRACT.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.sql.Timestamp;
/**
 *
 * @author MAK <mail:maksaleh@ieee.org>
 * 
 */

public class SblXTRACT {

           
    DB_Utility dbUtility;
    String extractStartStr ;
    String extractEndStr;
    String connectionEstablshedStr;
    String connectionClosed;
    String errorStr;
    
    public SblXTRACT(){
            
        extractStartStr = "Extraction Started : ........";
        extractEndStr = "Extraction Completed : ......";
        connectionClosed = "Connection closed : .....";
        errorStr = "";
        dbUtility = new DB_Utility();
    }
    
//************************************ All Scripts *************************************************************     
    public String extractAllScripts(){
             
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{          
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            connectionEstablshedStr =  "Connection Opened : " + new Timestamp(System.currentTimeMillis()) ;
            extractStartStr = "Extraction Started : " + extractionStart ;
        
            Timestamp connectionStart = new Timestamp(System.currentTimeMillis());
            connectionEstablshedStr = connectionStart.toString(); 
            
            dbUtility.getCon();
            dbUtility.xtractAppletBRW();    
            //dbUtility.closeConnection();
                    dbUtility.xtractAppletSRV();
              //      dbUtility.closeConnection();
                    dbUtility.xtractApplicationBRW();
                //    dbUtility.closeConnection();
                    dbUtility.xtractApplicationSRV();
                  //  dbUtility.closeConnection();
                    dbUtility.xtractBCBRW();
                    //dbUtility.closeConnection();
                    dbUtility.xtractBCSRV();
                    //dbUtility.closeConnection();
                    dbUtility.xtractBSBRW();
                    //dbUtility.closeConnection();
                    dbUtility.xtractBSSRV();
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr =   "Extraction Complete : " + extractionEnd ;
                    dbUtility.closeConnection();
                    connectionClosed  = "Connection Closed : " + new Timestamp(System.currentTimeMillis()) ;
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         errorStr =  "Error in Extracting Data due to : "+ex.getCause();
     }         
     
    return processTime;
    }
            
//******************************************* All Browser Scripts ******************************************************   
     public String extractAllBrowserScripts(){
          
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
               
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
            System.out.println( " Extraction Started : "+extractionStart);
            
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        connectionEstablshedStr = tt.toString();
        
                    dbUtility.getCon();
                    dbUtility.xtractAppletBRW();
                    //dbUtility.closeConnection();
                    dbUtility.xtractApplicationBRW();  
                    //dbUtility.closeConnection();
                    dbUtility.xtractBCBRW();
                    //dbUtility.closeConnection();
                    dbUtility.xtractBSBRW();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }         
     
    return processTime;
    }
//************************************* All Server Script ************************************************************ 
        public String extractAllServerScripts(){
                  
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
           
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
            System.out.println( " Extraction Started : "+extractionStart);
            
                    dbUtility.getCon();
                    dbUtility.xtractAppletSRV();
                    dbUtility.xtractApplicationSRV();
                    dbUtility.xtractBCSRV();
                    dbUtility.xtractBSSRV();
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    } 
//******************************************All Applet Scripts ******************************************************* 
   public String extractAppletScripts(){
                 
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
                
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
            System.out.println( " Extraction Started : "+extractionStart);
            
                    dbUtility.getCon();
                    dbUtility.xtractAppletBRW();
                    dbUtility.xtractAppletSRV();
                  
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }           
    return processTime;
    }   
//************************************* All Application Scripts ************************************************************ 
 public String extractApplicationScripts(){         
        
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
          
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
            System.out.println( " Extraction Started : "+extractionStart);
           
                    dbUtility.getCon();
                    dbUtility.xtractApplicationBRW();
                    dbUtility.xtractApplicationSRV();

                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }         
    return processTime;
    } 
//***************************************All Business Component Scripts********************************************************** 
  public String extractBusinessComponentScripts(){
                
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
           
          extractionStart = (new Timestamp(System.currentTimeMillis()));
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
            System.out.println( " Extraction Started : "+extractionStart);
            
                    dbUtility.getCon();
                    dbUtility.xtractBCBRW();
                    dbUtility.xtractBCSRV();

                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }         
    return processTime;
    }   
//**********************************All Business Service Scripts *************************************************************** 
  public String extractBusinessServcieScripts(){
               
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;    
        String processTime = null;
        
     try{
          
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
            System.out.println( " Extraction Started : "+extractionStart);
          
                    dbUtility.getCon();
                    dbUtility.xtractBSBRW();
                    dbUtility.xtractBSSRV();
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    System.out.println(extractionEnd + " Extraction Complete");
                    dbUtility.closeConnection();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                  
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                    
     }catch(Exception ex){
     
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }         
     
    return processTime;
    } 
//************************************* Applet Browser Script ************************************************************      
  public String extractAppletBrowserScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractAppletBRW();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                  //  System.out.println(extractionEnd + " Extraction Complete");
                    //System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }   
//************************************** Applet Server Script *********************************************    
   public String extractAppletServerScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractAppletSRV();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    } 
//************************************** Application Browser Script *********************************************  
     public String extractApplicationBrowserScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractApplicationBRW();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }
  
//************************************** Application Server Script *********************************************  
     public String extractApplicationServerScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractApplicationSRV();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }
  
//************************************** Business Component Browser Script *********************************************  
      public String extractBusinessComponentBrowserScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractBCBRW();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }
  
//************************************** Business Component Server Script *********************************************  
  public String extractBusinessComponentServerScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractBCSRV();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }   
//************************************** Business Service Browser Script ********************************************* 
           public String extractBusinessServiceBrowserScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractBSBRW();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    } 
//************************************** Business Service Server Script ********************************************* 
     public String extractBusinessServiceServerScripts(){
            
        Timestamp extractionStart = null;
        Timestamp extractionEnd = null;
        Timestamp connectionClosedTime = null;
        String processTime = null;
        
     try{     
            extractionStart = (new Timestamp(System.currentTimeMillis()));
            extractStartStr = extractionStart.toString();
            
                    dbUtility.getCon();
                    dbUtility.xtractBSSRV();
                    
                    extractionEnd = (new Timestamp(System.currentTimeMillis()));
                    extractEndStr = extractionEnd.toString();
                    connectionClosedTime = new Timestamp(System.currentTimeMillis());
                    connectionClosed = connectionClosedTime.toString();
                    dbUtility.closeConnection();
                    int h =  extractionEnd.getHours() - extractionStart.getHours();
                    int m = extractionEnd.getMinutes() - extractionStart.getMinutes();
                    int s = extractionEnd.getSeconds() - extractionStart.getSeconds();   
                    processTime = h+":"+m+":"+s;
                                        
     }catch(Exception ex){
         System.out.println("Error in Extracting Data due to : "+ex.getMessage());
     }             
    return processTime;
    }       
//************************************** End of Class *********************************************         
}


