/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.ItemDao;
import Model.CompanyVo;
import Model.ItemVo;
import Model.Model;
import View.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin3
 */
public class Controller implements ActionListener{
    private Model myModel;
    private Window myWindow;
    
    
    public void startController() {
        addEventKey();
        
        this.myWindow.bt_Search.addActionListener(this);
        this.myWindow.cb_Empresa.setModel(myModel.getCompanyBD());
        this.myWindow.setVisible(true);
    }
         
    public void setModel(Model myModel) {
        this.myModel = myModel;
    } 
    
    public void setWindow(Window myWindow) {
        this.myWindow = myWindow;
    }
    
    private Boolean validateTogether(){
        Boolean vali = true;
        
        if(!myWindow.ch_NoPart.isSelected() && !myWindow.ch_Description.isSelected() && !myWindow.ch_CodeSAT.isSelected()){
            JOptionPane.showMessageDialog(null, "Error, no hay ningun campo activado");
            vali = false;
        }           

        if(myWindow.tf_NoPart.getText().isEmpty() && myWindow.tf_Description.getText().isEmpty() && myWindow.tf_CodeSAT.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Error, todos los campos estan vacios");
            vali = false;    
        }                                         
        return vali;
    }
    
    private boolean validateSeparate (ItemVo myItemVo){
        Boolean vali = true;                    
        
        CompanyVo object = (CompanyVo) myWindow.cb_Empresa.getSelectedItem();
        Integer codigo = ((CompanyVo)object).getCodigo();
        myItemVo.setIdEmpresa(codigo);
        
        if(myWindow.ch_NoPart.isSelected()) 
            if(!myWindow.tf_NoPart.getText().isEmpty())
                myItemVo.setNoPart(myWindow.tf_NoPart.getText());                
            else 
                vali = false;
        
        if(myWindow.ch_Description.isSelected()) 
            if(!myWindow.tf_Description.getText().isEmpty())
                myItemVo.setDescription(myWindow.tf_Description.getText());                 
            else 
                vali = false;
                
        if(myWindow.ch_CodeSAT.isSelected()) 
            if(!myWindow.tf_CodeSAT.getText().isEmpty())
                myItemVo.setCodeSAT(myWindow.tf_CodeSAT.getText());                
            else 
                vali = false;
        
        if(vali == false){
            JOptionPane.showMessageDialog(null, "Error, hay un campo seleccionado vacio");
        }        
        return vali;
    }
       
    private void addEventKey(){
        Teclado mayus = new Teclado();
        CheckBox act = new CheckBox();
        
        this.myWindow.tf_NoPart.addKeyListener(mayus);
        this.myWindow.tf_CodeSAT.addKeyListener(mayus);
        this.myWindow.tf_Description.addKeyListener(mayus);
        
        this.myWindow.ch_NoPart.addItemListener(act);
        this.myWindow.ch_CodeSAT.addItemListener(act);
        this.myWindow.ch_Description.addItemListener(act);
    }
    
     public void addTableModel(DefaultTableModel model) {
       LoadTable(model);
    }
    
    public void LoadTable(DefaultTableModel model){        
        myWindow.table.setModel(model);
        ColumnsWidth();
    } 
    
    private void ColumnsWidth(){       
        myWindow.table.getColumnModel().getColumn(0).setPreferredWidth(10); 
        myWindow.table.getColumnModel().getColumn(1).setPreferredWidth(70); 
        myWindow.table.getColumnModel().getColumn(2).setPreferredWidth(200); 
        myWindow.table.getColumnModel().getColumn(3).setPreferredWidth(10);
    }
     
    public void actionPerformed(ActionEvent evento) {
        //this.modelo.eventoBoton();
        ItemVo myItem = new ItemVo();
                         
        if(validateTogether() && validateSeparate(myItem))
            myModel.queryTableModel(myItem); 
    }
    
    public class Teclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent ke) {
            char c =ke.getKeyChar();
            
            if(Character.isLowerCase(c)){
                String cad = (""+c).toUpperCase();
                c=cad.charAt(0);
                ke.setKeyChar(c);
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {}

        @Override
        public void keyReleased(KeyEvent ke) {}
               
    }
    
    public class CheckBox implements ItemListener{
    
        @Override
        public void itemStateChanged(ItemEvent e) { 

            if(e.getSource() == myWindow.ch_NoPart)  {
                if(myWindow.ch_NoPart.isSelected()){
                    myWindow.tf_NoPart.setEnabled(true);
                    myWindow.tf_NoPart.requestFocus();
                    System.out.println("Esta checado.... ");
                }
                else
                    myWindow.tf_NoPart.setEnabled(false);
            }
                           
            if(e.getSource() == myWindow.ch_Description)  {
                if(myWindow.ch_Description.isSelected()){
                    myWindow.tf_Description.setEnabled(true);
                    myWindow.tf_Description.requestFocus();
                }
                else
                    myWindow.tf_Description.setEnabled(false);
            }
            
            if(e.getSource() == myWindow.ch_CodeSAT)  {
                if(myWindow.ch_CodeSAT.isSelected()){
                    myWindow.tf_CodeSAT.setEnabled(true);
                    myWindow.tf_CodeSAT.requestFocus();
                }
                else
                    myWindow.tf_CodeSAT.setEnabled(false);
            }                     
        } 
    }
}
