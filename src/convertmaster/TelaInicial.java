/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package convertmaster;

/**
 *
 * @author Eric Gravatá
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
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

        jTitle = new javax.swing.JLabel();
        btMoedas = new javax.swing.JButton();
        btTemperatura = new javax.swing.JButton();
        btMedidas = new javax.swing.JButton();
        joption = new javax.swing.JLabel();
        iconCoin = new javax.swing.JLabel();
        iconTemp = new javax.swing.JLabel();
        iconMeasure = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ConvertMaster - Tela inicial");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("ConvertMaster");
        getContentPane().add(jTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 300, -1));

        btMoedas.setBackground(new java.awt.Color(0, 204, 153));
        btMoedas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btMoedas.setForeground(new java.awt.Color(255, 255, 255));
        btMoedas.setMnemonic('M');
        btMoedas.setText("Moedas");
        btMoedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoedasActionPerformed(evt);
            }
        });
        getContentPane().add(btMoedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 340, 100, 25));

        btTemperatura.setBackground(new java.awt.Color(255, 51, 51));
        btTemperatura.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btTemperatura.setForeground(new java.awt.Color(255, 255, 255));
        btTemperatura.setText("Temperatura");
        btTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTemperaturaActionPerformed(evt);
            }
        });
        getContentPane().add(btTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 340, 120, 25));

        btMedidas.setBackground(new java.awt.Color(0, 153, 255));
        btMedidas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btMedidas.setForeground(new java.awt.Color(255, 255, 255));
        btMedidas.setText("Medidas");
        btMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedidasActionPerformed(evt);
            }
        });
        getContentPane().add(btMedidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 340, 100, 25));

        joption.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        joption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joption.setText("Selecione uma das opções abaixo");
        getContentPane().add(joption, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 200, 250, -1));

        iconCoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coin_70px.png"))); // NOI18N
        iconCoin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCoinMouseClicked(evt);
            }
        });
        getContentPane().add(iconCoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        iconTemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/temp_70px.png"))); // NOI18N
        iconTemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconTempMouseClicked(evt);
            }
        });
        getContentPane().add(iconTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 70, 70));

        iconMeasure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/measure_70px.png"))); // NOI18N
        iconMeasure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconMeasureMouseClicked(evt);
            }
        });
        getContentPane().add(iconMeasure, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 70, 70));

        setSize(new java.awt.Dimension(516, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btMoedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoedasActionPerformed
        new TelaConversorMoedas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btMoedasActionPerformed

    private void btTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTemperaturaActionPerformed
        new Temperatura().setVisible(true);
        dispose();
    }//GEN-LAST:event_btTemperaturaActionPerformed

    private void btMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedidasActionPerformed
        new Medidas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btMedidasActionPerformed

    private void iconCoinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCoinMouseClicked
        new TelaConversorMoedas().setVisible(true);
        dispose();        
    }//GEN-LAST:event_iconCoinMouseClicked

    private void iconTempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconTempMouseClicked
        new Temperatura().setVisible(true);
        dispose();
    }//GEN-LAST:event_iconTempMouseClicked

    private void iconMeasureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconMeasureMouseClicked
        new Medidas().setVisible(true);
        dispose();
    }//GEN-LAST:event_iconMeasureMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMedidas;
    private javax.swing.JButton btMoedas;
    private javax.swing.JButton btTemperatura;
    private javax.swing.JLabel iconCoin;
    private javax.swing.JLabel iconMeasure;
    private javax.swing.JLabel iconTemp;
    private javax.swing.JLabel jTitle;
    private javax.swing.JLabel joption;
    // End of variables declaration//GEN-END:variables
}
