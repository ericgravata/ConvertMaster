
package convertmaster;

import convertmaster.TelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Eric Gravatá
 */
public class TelaDeSplash extends javax.swing.JFrame {

    public TelaDeSplash() {
        initComponents();
        Carregar();
    }
    
    private Timer t;
    public void Carregar() {
        ActionListener acao = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressBar.getValue() < 100) {
                    progressBar.setValue(progressBar.getValue() + 2);
                } else {
                    t.stop();
                    dispose();
                    TelaInicial inicial = new TelaInicial();
                    inicial.setVisible(true);
                }
            }
        };
        t = new Timer(100, acao);
        t.start();
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 330, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Splash_04.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        setSize(new java.awt.Dimension(500, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeSplash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
