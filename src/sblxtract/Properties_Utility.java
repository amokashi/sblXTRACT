package sblxtract;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Amr El-Shimy
 */
public class Properties_Utility {
    
    Properties Dbparameters;
    Properties Dbsql;
    InputStream input1 ;
    InputStream input2 ;

    public Properties_Utility() {
        
        Dbparameters = new Properties();
        Dbsql = new Properties();
        input1 = null;
        input2 = null;
    }
//******************************************************************************       
    public String getDB_parametrs(String Key){
        
            String Dboutput = "";
            
        try {
                 Dbparameters.load(Properties_Utility.class.getResourceAsStream("DB_Parameters.properties"));
                 
		Dboutput = Dbparameters.getProperty(Key).toString();
 
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input1 != null) {
			try {
				input1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        return Dboutput;    
        }
//****************************************************************************	
    
 public String getSQL(String SQL){
     
     String sqlResults = "";
     
     try {        
               Dbsql.load(Properties_Utility.class.getResourceAsStream("SQL.properties"));
		sqlResults = Dbsql.getProperty(SQL).toString();
 
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input2 != null) {
			try {
				input2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}       
     return sqlResults;
     }         
//******************************************************************************************************
public boolean createScripsContainer(){
 

 
 
return true; 
 }
 
//******************************************************************************************************   
}
