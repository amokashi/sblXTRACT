package sblxtract;

/*
 * To change this SBLScrlate, choose Tools | SBLScrlates
 * and open the SBLScrlate in the editor.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr El-Shimy
 */
public class DB_Utility {
    
    
    String filename = null;
    FileWriter fstream = null;
    BufferedWriter out = null;

    private Connection con;
    
    public Connection getCon() {
        
        try{
              Class.forName(pUtility.getDB_parametrs("driver"));
              con = DriverManager.getConnection(pUtility.getDB_parametrs("connection"));
              System.out.println("Connection is established successfully");
        }catch(Exception ex){
            System.out.println("Error in openeing Connection due to : "+ ex.getMessage());
        }
        
        return con;
    }
    
    public void setCon(Connection con) {   
    }
    
 //***********************************************************************   
    Properties_Utility pUtility;

    public DB_Utility() {
        
        pUtility = new Properties_Utility();
        
    }

//**********************************************************************************************   
public void closeConnection(){

    try{
     con.close();
    }catch(SQLException ex){
        System.out.println("Error while closing the connection due to : "+ex.getMessage());
    }
}    
    
//******************************* Get Applet Browser Script ***************************************************************   
   void xtractAppletBRW() {
        try {
            String sql="SELECT 'Applet' AS object_type, 'BRW' AS script_type, apltbrw.row_id AS script_id, apltbrw.applet_id AS object_id, applet.NAME AS object_name, apltbrw.NAME AS script_name, apltbrw.repository_id, apltbrw.procedure_name, apltbrw.script AS script FROM siebel.s_aplt_brsscrpt apltbrw INNER JOIN siebel.s_applet applet ON apltbrw.applet_id = applet.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
 //********************************Get Applet Server Script **************************************************************   
    void xtractAppletSRV() {
        try {
            String sql="SELECT 'Applet' AS object_type, 'SRV' AS script_type, apltsrv.row_id AS script_id, apltsrv.applet_id AS object_id, applet.NAME AS object_name, apltsrv.NAME AS script_name, apltsrv.repository_id, apltsrv.prog_lang AS script_language, apltsrv.script AS script FROM siebel.s_appl_webscrpt apltsrv INNER JOIN siebel.s_applet applet ON apltsrv.applet_id = applet.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder")+ resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//******************************* Get Application Browser Script ******************************************************************
     void xtractApplicationBRW() {
        try {
            String sql="SELECT 'Application' AS object_type, 'BRW' AS script_type, appbrw.row_id AS script_id, appbrw.application_id AS object_id, application.NAME AS object_name, appbrw.NAME AS script_name, appbrw.repository_id, appbrw.script AS script FROM siebel.s_appl_brsscrpt appbrw INNER JOIN siebel.s_application application ON appbrw.application_id = application.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//*******************************************Get Application Server Script ******************************************************    
    void xtractApplicationSRV() {
        try {
            String sql="SELECT 'Application' AS object_type, 'SRV' AS script_type, appsrv.row_id AS script_id, appsrv.application_id AS object_id, application.NAME AS object_name, appsrv.NAME AS script_name, appsrv.prog_lang AS script_language, appsrv.repository_id, appsrv.script AS script FROM siebel.s_appl_script appsrv INNER JOIN siebel.s_application application ON appsrv.application_id = application.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//*****************************************Get Business Component Browser Script********************************************************
    void xtractBCBRW() {
        try {
            String sql="SELECT 'BC' AS object_type, 'BRW' AS script_type, bcbrw.row_id AS script_id, bcbrw.buscomp_id AS object_id, bc.NAME AS object_name, bcbrw.NAME AS script_name, bcbrw.repository_id, bcbrw.procedure_name, bcbrw.script AS script FROM siebel.s_bc_brs_scrpt bcbrw INNER JOIN siebel.s_buscomp bc ON bcbrw.buscomp_id = bc.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//*********************************************Get Business Component Server Script****************************************************
   void xtractBCSRV() {
        try {
            String sql="SELECT 'BC' AS object_type, 'SRV' AS script_type, bcsrv.row_id AS script_id, bcsrv.buscomp_id AS object_id, bc.NAME AS object_name, bcsrv.NAME AS script_name, bcsrv.prog_lang AS script_language, bcsrv.repository_id, bcsrv.script AS script FROM siebel.s_buscomp_script bcsrv INNER JOIN siebel.s_buscomp bc ON bcsrv.buscomp_id = bc.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//**********************************************Get Business Servcie Browser Script ***************************************************
   void xtractBSBRW() {
        try {
            String sql="SELECT 'BS' AS object_type, 'BRW' AS script_type, bsbrw.row_id AS script_id, bsbrw.NAME AS script_name, bsbrw.repository_id, bsbrw.service_id AS object_id, bs.NAME AS object_name, bsbrw.script AS script FROM siebel.s_svc_brs_scrpt bsbrw INNER JOIN siebel.s_service bs ON bsbrw.service_id = bs.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//*********************************************Get Business Service Server Script ****************************************************
  void xtractBSSRV() {
        try {
            String sql="SELECT 'BS' AS object_type, 'SRV' AS script_type, bssrv.row_id AS script_id, bssrv.NAME AS script_name, bssrv.prog_lang AS script_language, bssrv.repository_id, bssrv.script AS script, bssrv.service_id AS object_id, bs.NAME AS object_name FROM siebel.s_service_scrpt bssrv INNER JOIN siebel.s_service bs ON bssrv.service_id = bs.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = pUtility.getDB_parametrs("savedFolder") + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//**************************************** End of Class *******************************************
}
