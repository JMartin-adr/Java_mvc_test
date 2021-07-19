/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martin3
 */
public class Window extends JFrame{

    private JPanel PBase;
    
    private JPanel PHeader;
    private JPanel PBody;
    private JPanel PFoot;
    
    public JComboBox cb_Empresa;
    public JButton bt_Search;
    
    public JTextField tf_NoPart;
    public JTextField tf_CodeSAT; 
    public JTextField tf_Description; 
    
    public JCheckBox ch_NoPart;
    public JCheckBox ch_CodeSAT;
    public JCheckBox ch_Description;
    
    public JTable table;
            
    public Window(){   
        ConfigureWindow();
          
        header();
        body();
        footer();
        
        panelBase();
    }
    
    private void ConfigureWindow(){
       setTitle("Busca Clave SAT");
       setSize(600, 330);
       setLocationRelativeTo(null);
    }
        
    private void panelBase(){      
        PBase = new JPanel(new BorderLayout());
        PBase.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        getContentPane().add(PBase);      
        
        PBase.add(PHeader, BorderLayout.NORTH);
        PBase.add(PBody, BorderLayout.CENTER);
        PBase.add(PFoot, BorderLayout.SOUTH); 
                                 
        addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent evt) {               
                System.out.println("Sale de window...");
               // conexion.desconectar();
                System.exit(0);
            }
        }); 
    }
    
    private void header(){
        PHeader = new JPanel(new BorderLayout());
        PHeader.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        JPanel PLeft = new JPanel(new GridLayout(3, 1));
        JPanel PButton = new JPanel(new BorderLayout());
        FlowLayout space = new FlowLayout(FlowLayout.LEFT);
        
        space.setVgap(2);
        
        JPanel PSub_floor1 = new JPanel(new BorderLayout());
        JPanel PSub_floor2 = new JPanel(space);
        JPanel PSub_floor3 = new JPanel(space);      
        
        PSub_floor1.setLayout(null);
        PButton.setLayout(null);
        
        PHeader.add(PLeft, BorderLayout.WEST);
        PHeader.add(PButton, BorderLayout.CENTER);
        
        PLeft.add(PSub_floor1);
        PLeft.add(PSub_floor2);              
        PLeft.add(PSub_floor3);    
        
        //  *******************************************************************
        
        JLabel lb_Empresa = new JLabel("Empresa:");
        lb_Empresa.setBounds(44, 3, 100, 20);
        
        cb_Empresa = new JComboBox();
        cb_Empresa.setBounds(107, 4, 110, 20);
        cb_Empresa.removeAllItems();        
        
        ch_NoPart = new JCheckBox ("No. de Parte:");
        ch_CodeSAT = new JCheckBox ("Clave SAT:");
        ch_Description = new JCheckBox ("Descripcion:");
        
        tf_NoPart = new JTextField(12);
        tf_CodeSAT = new JTextField(7);
        tf_Description = new JTextField(28);
        
        //*********************************************************************
        
        PSub_floor1.add(lb_Empresa);
        PSub_floor1.add(cb_Empresa);
        
        PSub_floor2.add(ch_Description, BorderLayout.WEST);
        PSub_floor2.add(tf_Description, BorderLayout.WEST);
        
        PSub_floor3.add(ch_NoPart, BorderLayout.WEST);
        PSub_floor3.add(tf_NoPart, BorderLayout.WEST);
        PSub_floor3.add(ch_CodeSAT, BorderLayout.WEST);
        PSub_floor3.add(tf_CodeSAT, BorderLayout.WEST);       
          
        bt_Search = new JButton ();
        bt_Search.setBounds(30, 7, 40, 40);
        PButton.add(bt_Search); 
        
        ImageIcon img_boton = new ImageIcon("buscar8.png");                   //  bt_Search.getWidth(), bt_Search.getHeight()
        bt_Search.setIcon(new ImageIcon(img_boton.getImage().getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)));
    }
    
    private void body(){
        PBody = new JPanel(new BorderLayout());
        PBody.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        String[] columns = {"SubGrupo", "No. Parte", "Descripcion", "ClaveSAT"};
        Object[][] data = {  };
                             
        table = new JTable(data, columns); 
       // Table.setModel(model);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10); 
        table.getColumnModel().getColumn(1).setPreferredWidth(70); 
        table.getColumnModel().getColumn(2).setPreferredWidth(200); 
        table.getColumnModel().getColumn(3).setPreferredWidth(10);
        
        // Render ren = new Render();
        // Table.setDefaultRenderer(Object.class, ren);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
                      
        PBody.setLayout(new GridLayout(1, 0)); 
        PBody.add(scroll);
    }
       
    private void footer(){ 
        PFoot = new JPanel(new BorderLayout());
        PFoot.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        FlowLayout space = new FlowLayout(FlowLayout.CENTER);
        space.setVgap(6);
        PFoot.setLayout(space);
        
        JButton bt_Cancel = new JButton("Cancelar");
        bt_Cancel.setPreferredSize(new Dimension(95,30));
        
        PFoot.add(bt_Cancel, BorderLayout.WEST); 
        
        bt_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent evento){ 
                // conexion.desconectar();
                System.out.println("Sale Boton.... ");
                System.exit(0);
            }
        });
    }
}
