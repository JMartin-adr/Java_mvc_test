/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.CompanyVo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin3
 */
public class ItemDao {
       
    public DefaultTableModel createTableModel(String query){              
        ConnectDB cnx_query = new ConnectDB();
        
        String[] COLUMNS = {"SubGrupo", "No.Parte", "Descripcion", "ClaveSAT"};
        String[] DATA = new String[4];
        
        DefaultTableModel TABLE = new DefaultTableModel(null,COLUMNS);
        
        try{
            Statement Instruction = cnx_query.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet Result = Instruction.executeQuery(query);
 
            while(Result.next()) {
                
                DATA[0] = Result.getString("subg_nombre");
                DATA[1] = Result.getString("art_clavearticulo");
                DATA[2] = Result.getString("art_nombreLargo");
                DATA[3] = Result.getString("art_adicional2"); 
                 
                TABLE.addRow(DATA);
            }            
            
            Instruction.close();
            cnx_query.getConnection().close();
        }    
        catch (SQLException SQLE){
            JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + SQLE.getMessage());
        }
        return TABLE;
    }
    
    public DefaultComboBoxModel queryCompany() {                  
        ConnectDB cnx_query = new ConnectDB();        
                
        String sql = "SELECT emp_clave, emp_nombreCorto FROM empresas";      
        DefaultComboBoxModel model = new DefaultComboBoxModel();
                   
        try{
            Statement st = cnx_query.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
                       
            while(rs.next()){
                model.addElement(new CompanyVo(rs.getString(2), rs.getInt(1)));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR AL CARGAR LOS DATOS DE LA BD \n ERROR : " + ex.getMessage());
        }         
        return model;
    }
}
