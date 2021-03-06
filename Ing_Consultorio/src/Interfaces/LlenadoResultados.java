package Interfaces;


import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */
public class LlenadoResultados extends javax.swing.JDialog {

    /**
     * Creates new form LlenadoResultados
     */
    public LlenadoResultados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modelo.addColumn("CODIGO");
        modelo.addColumn("COD. EXAMEN");
        modelo.addColumn("TIPO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("RESULTADO");
        jTable1.setModel(modelo);
        
         pnlFondo fondo = new pnlFondo(650, 650); 
       this.add(fondo,BorderLayout.CENTER);
       this.pack();
       
        fondo.setVisible(true);
       
    }
    String CILab="1805037619";
    public LlenadoResultados(java.awt.Frame parent, boolean modal,String CI) {
        super(parent, modal);
        initComponents();
        CILab=CI;
        modelo.addColumn("CODIGO");
        modelo.addColumn("COD. EXAMEN");
        modelo.addColumn("TIPO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("RESULTADO");
        jTable1.setModel(modelo);
        
         pnlFondo fondo = new pnlFondo(650, 650); 
       this.add(fondo,BorderLayout.CENTER);
       this.pack();
       
        fondo.setVisible(true);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDetalle = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneResultado = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabelDetCliente = new javax.swing.JLabel();
        jButtonDetCancelar = new javax.swing.JButton();
        jButtonDetAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCI = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelNomCli = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTextPaneResultado);

        jLabel3.setText("EXAMEN:");

        jLabelDetCliente.setText(".");
        jLabelDetCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButtonDetCancelar.setText("Cancelar");
        jButtonDetCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetCancelarActionPerformed(evt);
            }
        });

        jButtonDetAceptar.setText("Aceptar");
        jButtonDetAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogDetalleLayout = new javax.swing.GroupLayout(jDialogDetalle.getContentPane());
        jDialogDetalle.getContentPane().setLayout(jDialogDetalleLayout);
        jDialogDetalleLayout.setHorizontalGroup(
            jDialogDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialogDetalleLayout.createSequentialGroup()
                        .addGap(0, 211, Short.MAX_VALUE)
                        .addComponent(jButtonDetAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDetCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogDetalleLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDetCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(23, 23, 23))
        );
        jDialogDetalleLayout.setVerticalGroup(
            jDialogDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelDetCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDetCancelar)
                    .addComponent(jButtonDetAceptar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CI:");

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loupe.png"))); // NOI18N
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("CLIENTE:");

        jLabelNomCli.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "COD. EXAMEN", "TIPO", "EXAMEN", "RESULTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/writing.png"))); // NOI18N
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNomCli, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jTextFieldCI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelNomCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        limpiadoTabla();
        BusLlenadoExamenes();
       
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
         // TODO add your handling code here:
          String fil=codCon();
          
        if(fil.equals("-1")){
            JOptionPane.showMessageDialog(this, "Seleccione un examen");
        }else{
             jDialogDetalle.setVisible(true);
        jDialogDetalle.setSize(400, 400);
        jLabelDetCliente.setText(jLabelNomCli.getText()+"-"+ExaSelect());
        jTextPaneResultado.setText(ResuSelect());
        }
        
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonDetAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetAceptarActionPerformed
        // TODO add your handling code here:
        int fil = jTable1.getSelectedRow();
        modelo.setValueAt(jTextPaneResultado.getText(), fil, 4);
        jDialogDetalle.setVisible(false);
        
    }//GEN-LAST:event_jButtonDetAceptarActionPerformed

    private void jButtonDetCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetCancelarActionPerformed
        // TODO add your handling code here:
        jDialogDetalle.setVisible(false);
    }//GEN-LAST:event_jButtonDetCancelarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed
   Conexion com = new Conexion();
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        int filas= modelo.getRowCount();
        int con=0;
        for (int i = 0; i < filas; i++) {
            String resultado="";
            try{
                resultado=modelo.getValueAt(i, 4).toString();
            }catch(NullPointerException e){
                resultado="";
            }
            if(resultado.equals("")){
                
            }else{
                String cod=modelo.getValueAt(i, 0).toString();
                String codExa=modelo.getValueAt(i, 1).toString();
                
                if(com.insetarResultado(cod, resultado,codExa)){
                 con++;   
                }else{
                    
                }
                
            }
        }
        JOptionPane.showMessageDialog(this, "Se an inngresado exitosamente "+con+" resultados");
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void limpiadoTabla() {
        int fill = modelo.getRowCount() - 1;
        //  Limpiado del jTable de paciente
        if (fill > 0) {
            for (int j = fill; j >= 0; j--) {
                modelo.removeRow(modelo.getRowCount() - 1);
                
            }
        }
    }
    private String codCon() throws NumberFormatException {
        // TODO add your handling code here:
        String cod;
        TableModel model = jTable1.getModel();
        int a = jTable1.getSelectedRow();
        if (a == -1) {
          cod="-1";
        } else {

            cod=model.getValueAt(a, 0).toString();
        }
        return cod;
    }
    private String ExaSelect() throws NumberFormatException {
        // TODO add your handling code here:
        String cod;
        TableModel model = jTable1.getModel();
        int a = jTable1.getSelectedRow();
        if (a == -1) {
          cod="-1";
        } else {

            cod=model.getValueAt(a, 3).toString();
        }
        return cod;
    }
    private String ResuSelect() throws NumberFormatException {
        // TODO add your handling code here:
        String cod;
        TableModel model = jTable1.getModel();
        int a = jTable1.getSelectedRow();
        if (a == -1) {
          cod="-1";
        } else {
            try{
                cod=model.getValueAt(a, 4).toString();
            }catch(NullPointerException e){
                cod="";
            }
            
        }
        return cod;
    }
   Conexion con = new Conexion();
   DefaultTableModel modelo=new DefaultTableModel();
    private void BusLlenadoExamenes() throws HeadlessException {
        // TODO add your handling code here:
        ResultSet resCon= con.BusExamenesNull(jTextFieldCI.getText(),CILab);
        
        Object[] datos= new Object[5];
        try {
            while(resCon.next()){
                String nom=resCon.getString(1)+" "+resCon.getString(2);
                jLabelNomCli.setText(nom);
                datos[0]=resCon.getString(3);
                datos[1]=resCon.getString(7);
                datos[2]=resCon.getString(4);
                datos[3]=resCon.getString(5);
                datos[4]=resCon.getString(6);
                
                
                modelo.addRow(datos);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LlenadoResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LlenadoResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LlenadoResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LlenadoResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LlenadoResultados dialog = new LlenadoResultados(new javax.swing.JFrame(), false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDetAceptar;
    private javax.swing.JButton jButtonDetCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JDialog jDialogDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDetCliente;
    private javax.swing.JLabel jLabelNomCli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCI;
    private javax.swing.JTextPane jTextPaneResultado;
    // End of variables declaration//GEN-END:variables
}
