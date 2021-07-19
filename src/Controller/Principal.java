/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.ConnectDB;
import Model.CompanyVo;
import Model.Model;
import View.Window;

/**
 *
 * @author Martin3
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        ConnectDB con = new ConnectDB();       
        
        if(con.getConnection() != null){ 
            
            Controller myController;
            Model myModel;
            Window myView;            
                                    
            myController = new Controller();
            myModel = new Model();            
            myView = new Window();
            
            myController.setModel(myModel);
            myController.setWindow(myView);
            
            myController.startController();
            
            myModel.setController(myController);
           // myView.setController(myController);                       
        }       
    }
    
}
