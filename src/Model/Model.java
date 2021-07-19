/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import DataBase.ItemDao;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Martin3
 */
public class Model {
    
    private Controller myController;
    
    public void setController(Controller myController) {
        this.myController = myController;
    }
    
    public DefaultComboBoxModel getCompanyBD() {
        ItemDao dao = new ItemDao();
         
        return dao.queryCompany();
    }
    
    public void queryTableModel(ItemVo myItem){        
        String sql;
        
        sql = createQuery(myItem);
        ItemDao dao = new ItemDao();
        
        myController.LoadTable(dao.createTableModel(sql));
    }
    
    private String createQuery(ItemVo myItem) {
        String query = "";
        
        query = " SELECT subg_nombre, art_clavearticulo, art_nombreLargo, art_adicional2 "+
                "   FROM articulos, subgrupos " +
                "  WHERE art_subg_clave = subg_clave " +
                "    and art_emp_clave = "+myItem.getIdEmpresa();
        try{
        
            if (myItem.getNoPart() != null)
                query = query + " and art_clavearticulo LIKE '%"+myItem.getNoPart()+"%'";

            if (myItem.getDescription() != null)
                query = query + " and art_nombreLargo LIKE '%"+myItem.getDescription()+"%'";

            if (myItem.getCodeSAT() != null)
                query = query + " and art_adicional2 LIKE '%"+myItem.getCodeSAT()+"%'";

            query = query + " ORDER BY subg_nombre, art_clavearticulo";
        } 
        catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,"Se ha presentado un Error"+ e.getMessage());
           System.out.println("hay error de parametros");
        }       
        return query;    
    } 
    
}
