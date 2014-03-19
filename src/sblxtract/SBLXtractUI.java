package sblxtract;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SBLXtractUI.java
 *
 * Created on 12/03/2014, 06:40:53 ص
 */


import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Amr El-Shimy
 */
public class SBLXtractUI extends javax.swing.JFrame {

    
    SblXTRACT Xtract;
    Properties_Utility pUtility;
    /** Creates new form SBLXtractUI */
    public SBLXtractUI() {
         Xtract =  new SblXTRACT(); 
         pUtility =  new Properties_Utility();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Siebel Extractor");
        setBackground(new java.awt.Color(153, 204, 255));
        setBounds(new java.awt.Rectangle(400, 100, 300, 300));

        jButton1.setText("Extract");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "All Scripts", "All Server Scripts", "All Browser Scripts", "All Applet Script", "Applet Browser Script", "Applet Server Script", "All Application Script ", "Application Browser Script", "Application Server Script", "All Business Component Script", "Business Component Browser Script", "Business Component Server Script", "All Business Service Script", "Business Service Browser Script", "Business Service Server Script", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.setEditable(false);

        jButton2.setText("Open Scripts Folder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear Script Folder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jButton2.setEnabled(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        String processPeriod = "";
        
        
        if(jComboBox1.getSelectedItem().toString() == null || 
                jComboBox1.getSelectedItem().toString().equals("...")){
        
            JOptionPane.showMessageDialog(rootPane, "Please Select Script", null, JOptionPane.ERROR_MESSAGE);
        
        }
//------------------------------------------------------------------------------------------------------                
        else if(jComboBox1.getSelectedItem().toString().equals("All Scripts"))  
        {           
        processPeriod = Xtract.extractAllScripts();
        
       if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");      
        
        jButton2.setEnabled(true);                
        
        }else{
        jTextArea1.append(Xtract.errorStr);
        }
//------------------------------------------------------------------------------------------------------       
   }else if(jComboBox1.getSelectedItem().toString().equals("All Browser Scripts"))
   { 
     processPeriod =  Xtract.extractAllBrowserScripts();

     if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");  
        
        jButton2.setEnabled(true);    
       }else{
        jTextArea1.append(Xtract.errorStr);
        }
//------------------------------------------------------------------------------------------------------     
   }else if(jComboBox1.getSelectedItem().toString().equals("All Server Scripts"))
   {
   
      processPeriod =  Xtract.extractAllServerScripts();

     if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");  
        
        jButton2.setEnabled(true);    
       }else{
        jTextArea1.append(Xtract.errorStr);
        }
   }
//-----------------------------------------------------------------------------------------------------
   else if(jComboBox1.getSelectedItem().toString().equals("All Applet Script")){
   
        processPeriod =  Xtract.extractAppletScripts();
        
      if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod);   
        
        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }
 }           
//-----------------------------------------------------------------------------------------------------
   else if(jComboBox1.getSelectedItem().toString().equals("Applet Browser Script")){
   
        processPeriod =  Xtract.extractAppletBrowserScripts();
        
      if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod);   
        
        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }
 }
//------------------------------------------------------------------------------------------------------
   else if(jComboBox1.getSelectedItem().toString().equals("Applet Server Script")){
   
        processPeriod =  Xtract.extractAppletServerScripts();
        
      if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod);   
        
        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }
 }
//------------------------------------------------------------------------------------------------------
   else if(jComboBox1.getSelectedItem().toString().equals("Applet Server Script")){
   
        processPeriod =  Xtract.extractAppletServerScripts();
        
      if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod);   
        
        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }
 }           
//------------------------------------------------------------------------------------------------------
else if (jComboBox1.getSelectedItem().toString().equals("All Application Script"))
   {
   
      processPeriod = Xtract.extractApplicationScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }                  
//------------------------------------------------------------------------------------------------------
   else if (jComboBox1.getSelectedItem().toString().equals("Application Browser Script"))
   {
   
        processPeriod = Xtract.extractApplicationBrowserScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }
//------------------------------------------------------------------------------------------------------           
   else if (jComboBox1.getSelectedItem().toString().equals("Application Server Script"))
   {
   
        processPeriod = Xtract.extractApplicationServerScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }       
//------------------------------------------------------------------------------------------------------
  else if (jComboBox1.getSelectedItem().toString().equals("All Business Component Script"))
   {
   
      processPeriod = Xtract.extractBusinessComponentScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }      
      
//------------------------------------------------------------------------------------------------------
   else if (jComboBox1.getSelectedItem().toString().equals("Business Component Browser Script"))
   {
   
      processPeriod = Xtract.extractBusinessComponentBrowserScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }      
//------------------------------------------------------------------------------------------------------      
  else if (jComboBox1.getSelectedItem().toString().equals("Business Component Server Script"))
   {
   
      processPeriod = Xtract.extractBusinessComponentServerScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }
//------------------------------------------------------------------------------------------------------ 
 else if (jComboBox1.getSelectedItem().toString().equals("All Business Service Script"))
   {
   
      processPeriod = Xtract.extractBusinessServcieScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }        
//------------------------------------------------------------------------------------------------------ 
 else if (jComboBox1.getSelectedItem().toString().equals("Business Service Browser Script"))
   {
   
      processPeriod = Xtract.extractBusinessServiceBrowserScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }         
//------------------------------------------------------------------------------------------------------ 
 else if (jComboBox1.getSelectedItem().toString().equals("Business Service Server Script"))
   {
   
      processPeriod = Xtract.extractBusinessServiceServerScripts();
        
    if(!Xtract.errorStr.equals("") || Xtract.errorStr != null || !Xtract.errorStr.equals(" ")){   
        
        jTextArea1.append("Connection Started in : "+Xtract.connectionEstablshedStr + "\n");
        jTextArea1.append("Extraction Started in : "+Xtract.extractStartStr+"\n");
        jTextArea1.append("Extraction finished in : " + Xtract.extractEndStr + "\n");
        jTextArea1.append("Connection closed in : "+Xtract.connectionClosed + "\n");
        jTextArea1.append("Process took : "+processPeriod+"\n");   

        jButton2.setEnabled(true);    
        }else{
        jTextArea1.append(Xtract.errorStr);
        }  
   }         
//------------------------------------------------------------------------------------------------------        
/*
...
All Scripts
All Server Scripts
All Browser Scripts
All Applet Script
Applet Browser Script
Applet Server Script
All Application Script 
Application Browser Script
Application Server Script
All Business Component Script
Business Component Browser Script
Business Component Server Script
All Business Service Script
Business Service Browser Script
Business Service Server Script
*/       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
       try{
        File scriptsFolder = new File(pUtility.getDB_parametrs("savedFolder"));

     if (Desktop.isDesktopSupported()) {
          Desktop.getDesktop().open(scriptsFolder);
             }
          }
        catch(Exception ex){
    
              JOptionPane.showMessageDialog(rootPane, "Error in opening the target file due to : " + ex.getMessage()
                      , null, JOptionPane.ERROR_MESSAGE);
}
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().toString().equals("...")){
        
             jButton2.setEnabled(false);     
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        File scriptDir = new File("C:\\SBLScr\\dev\\scripts\\");
        if(scriptDir.isDirectory()){
            
            
          if(scriptDir.listFiles().length == 0 ){
          
          JOptionPane.showMessageDialog(rootPane, "Folder is already empty", null, JOptionPane.OK_OPTION);         
              
          }else {
          
              for(File file : scriptDir.listFiles()){
                
                file.delete();
            }
     JOptionPane.showMessageDialog(rootPane, "Folder is Clear", null, JOptionPane.NO_OPTION);                  
          }            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SBLXtractUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}