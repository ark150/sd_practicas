/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenring;

import Model.Proceso;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ark
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    Proceso procesoN;
    public Pantalla() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProceso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPuertoProceso = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIPCoordinador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPuertoCoordinador = new javax.swing.JTextField();
        btnPeticion = new javax.swing.JButton();
        cbxColor = new javax.swing.JComboBox<>();
        cbxProceso = new javax.swing.JComboBox<>();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Proceso");

        jLabel2.setText("Puerto");

        btnIniciar.setText("Empezar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel3.setText("Coordinador");

        jLabel5.setText("Direccion IP");

        jLabel6.setText("Puerto");

        btnPeticion.setText("Peticion");
        btnPeticion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeticionActionPerformed(evt);
            }
        });

        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un color", "black", "blue", "cyan", "green", "magenta", "orange", "pink", "red", "white", "yellow" }));

        cbxProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIPCoordinador))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtPuertoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPuertoCoordinador))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPeticion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPuertoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIPCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtPuertoCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnPeticion))
                    .addComponent(cbxColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPeticionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeticionActionPerformed
        // TODO add your handling code here:
        int d=cbxColor.getSelectedIndex();
        int [] vecColor;
        vecColor=obtenerColor(d);
        if(vecColor==null){
            JOptionPane.showMessageDialog(null, "Seleccione un color");
        }else{
            this.getContentPane().setBackground(new java.awt.Color(vecColor[0], vecColor[1],vecColor[2]));
        }
        
        
        
    }//GEN-LAST:event_btnPeticionActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        String ipDic="localhost";
        int puerto=Integer.parseInt(txtPuertoProceso.getText());
        int idProceso = cbxProceso.getSelectedIndex();
        procesoN=new Proceso(ipDic, puerto, idProceso, Integer.toString(idProceso));
        txtIPCoordinador.setEnabled(false);
        txtPuertoCoordinador.setEnabled(false);
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPeticion;
    private javax.swing.JComboBox<String> cbxColor;
    private javax.swing.JComboBox<String> cbxProceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtIPCoordinador;
    private javax.swing.JTextField txtIdProceso;
    private javax.swing.JTextField txtPuertoCoordinador;
    private javax.swing.JTextField txtPuertoProceso;
    // End of variables declaration//GEN-END:variables

    private int[] obtenerColor(int d) {
        int [] vecColo= new int[3];
        switch(d){
            case 1:
                vecColo[0]=0;
                vecColo[1]=0;
                vecColo[2]=0;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
                break;
            case 2:
                vecColo[0]=58;
                vecColo[1]=98;
                vecColo[2]=226;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 3:
                vecColo[0]=0;
                vecColo[1]=249;
                vecColo[2]=255;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 4:
                vecColo[0]=0;
                vecColo[1]=255;
                vecColo[2]=0;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 5:
                vecColo[0]=182;
                vecColo[1]=0;
                vecColo[2]=255;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 6:
                vecColo[0]=255;
                vecColo[1]=200;
                vecColo[2]=0;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 7:
                vecColo[0]=255;
                vecColo[1]=0;
                vecColo[2]=251;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 8:
                vecColo[0]=255;
                vecColo[1]=0;
                vecColo[2]=0;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 9:
                vecColo[0]=255;
                vecColo[1]=255;
                vecColo[2]=255;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            case 10:
                vecColo[0]=255;
                vecColo[1]=243;
                vecColo[2]=0;
                //this.getContentPane().setBackground(new java.awt.Color(vecColo[0], vecColo[1],vecColo[2]));
            break;
            default:
                System.out.println("color no seleccionado");
                vecColo=null;
                break;
        }
        return vecColo;
    }


}