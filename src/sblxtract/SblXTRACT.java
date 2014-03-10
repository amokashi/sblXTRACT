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
package sblxtract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAK <mail:maksaleh@ieee.org>
 * 
 */
public class SblXTRACT {

    /**
     * @param args the command line arguments
     */
    static Connection con = null;
    static String filename = null;
    //static CSVWriter writer = null;
    static FileWriter fstream = null;
    static BufferedWriter out = null;
    static Integer iIssue = 1;
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:SSD Local Db default instance");
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Opened");
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Extraction Started");
                    xtractAppletBRW();
                    xtractAppletSRV();
                    xtractApplicationBRW();
                    xtractApplicationSRV();
                    xtractBCBRW();
                    xtractBCSRV();
                    xtractBSBRW();
                    xtractBSSRV();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Extraction Complete");
                    con.close();
                    System.out.println((new Timestamp(System.currentTimeMillis())) + " Connection Closed");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractAppletBRW() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'Applet' AS object_type, 'BRW' AS script_type, apltbrw.row_id AS script_id, apltbrw.applet_id AS object_id, applet.NAME AS object_name, apltbrw.NAME AS script_name, apltbrw.repository_id, apltbrw.procedure_name, apltbrw.script AS script FROM siebel.s_aplt_brsscrpt apltbrw INNER JOIN siebel.s_applet applet ON apltbrw.applet_id = applet.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractAppletSRV() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'Applet' AS object_type, 'SRV' AS script_type, apltsrv.row_id AS script_id, apltsrv.applet_id AS object_id, applet.NAME AS object_name, apltsrv.NAME AS script_name, apltsrv.repository_id, apltsrv.prog_lang AS script_language, apltsrv.script AS script FROM siebel.s_appl_webscrpt apltsrv INNER JOIN siebel.s_applet applet ON apltsrv.applet_id = applet.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractApplicationBRW() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'Application' AS object_type, 'BRW' AS script_type, appbrw.row_id AS script_id, appbrw.application_id AS object_id, application.NAME AS object_name, appbrw.NAME AS script_name, appbrw.repository_id, appbrw.script AS script FROM siebel.s_appl_brsscrpt appbrw INNER JOIN siebel.s_application application ON appbrw.application_id = application.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void xtractApplicationSRV() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'Application' AS object_type, 'SRV' AS script_type, appsrv.row_id AS script_id, appsrv.application_id AS object_id, application.NAME AS object_name, appsrv.NAME AS script_name, appsrv.prog_lang AS script_language, appsrv.repository_id, appsrv.script AS script FROM siebel.s_appl_script appsrv INNER JOIN siebel.s_application application ON appsrv.application_id = application.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractBCBRW() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'BC' AS object_type, 'BRW' AS script_type, bcbrw.row_id AS script_id, bcbrw.buscomp_id AS object_id, bc.NAME AS object_name, bcbrw.NAME AS script_name, bcbrw.repository_id, bcbrw.procedure_name, bcbrw.script AS script FROM siebel.s_bc_brs_scrpt bcbrw INNER JOIN siebel.s_buscomp bc ON bcbrw.buscomp_id = bc.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractBCSRV() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'BC' AS object_type, 'SRV' AS script_type, bcsrv.row_id AS script_id, bcsrv.buscomp_id AS object_id, bc.NAME AS object_name, bcsrv.NAME AS script_name, bcsrv.prog_lang AS script_language, bcsrv.repository_id, bcsrv.script AS script FROM siebel.s_buscomp_script bcsrv INNER JOIN siebel.s_buscomp bc ON bcsrv.buscomp_id = bc.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractBSBRW() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'BS' AS object_type, 'BRW' AS script_type, bsbrw.row_id AS script_id, bsbrw.NAME AS script_name, bsbrw.repository_id, bsbrw.service_id AS object_id, bs.NAME AS object_name, bsbrw.script AS script FROM siebel.s_svc_brs_scrpt bsbrw INNER JOIN siebel.s_service bs ON bsbrw.service_id = bs.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +".js";
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void xtractBSSRV() {
        try {
            /*xtract*/
            System.out.println((new Timestamp(System.currentTimeMillis())) + " Begin  Execution Issue # " + iIssue);
            String sql="SELECT 'BS' AS object_type, 'SRV' AS script_type, bssrv.row_id AS script_id, bssrv.NAME AS script_name, bssrv.prog_lang AS script_language, bssrv.repository_id, bssrv.script AS script, bssrv.service_id AS object_id, bs.NAME AS object_name FROM siebel.s_service_scrpt bssrv INNER JOIN siebel.s_service bs ON bssrv.service_id = bs.row_id;";
            Statement stmt=con.createStatement();
            ResultSet resultSet=stmt.executeQuery(sql);
            while(resultSet.next()) {
            	filename = "C:\\Temp\\dev\\scripts\\" + resultSet.getString("object_type") +"_"+ resultSet.getString("object_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"_"+ resultSet.getString("script_type") +"_"+ resultSet.getString("script_name").replaceAll("[^a-zA-Z0-9.-]", "_") +"."+ resultSet.getString("script_language");
            	fstream = new FileWriter(filename);
            	out = new BufferedWriter(fstream);
                out.write(resultSet.getString("script"));
                out.close();
                fstream.close();
            }
            System.out.println((new Timestamp(System.currentTimeMillis())) + " End    Execution Issue # " + iIssue);
            iIssue++;
        } catch (IOException | SQLException ex) {
            Logger.getLogger(SblXTRACT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}