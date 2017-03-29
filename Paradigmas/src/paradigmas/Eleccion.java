package paradigmas;

public class Eleccion extends javax.swing.JFrame {

    public static Boolean eleccion = false;
    public static int opcion = 0;

    public Eleccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHaskell = new javax.swing.JButton();
        btnGraphik = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHaskell.setBackground(new java.awt.Color(255, 255, 255));
        btnHaskell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/has.png"))); // NOI18N
        btnHaskell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHaskellActionPerformed(evt);
            }
        });
        getContentPane().add(btnHaskell, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 155, 152));

        btnGraphik.setBackground(new java.awt.Color(255, 255, 255));
        btnGraphik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/descarga.jpg"))); // NOI18N
        btnGraphik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphikActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraphik, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 11, 152, 152));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/a.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHaskellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHaskellActionPerformed
        Atributos.lenguaje = "hk";
        this.setVisible(false);
        eleccion = true;
        Paradigmas.interfaz.continuarSegunArchivo();
    }//GEN-LAST:event_btnHaskellActionPerformed

    private void btnGraphikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphikActionPerformed
        Atributos.lenguaje = "gk";
        this.setVisible(false);
        Paradigmas.interfaz.continuarSegunArchivo();
    }//GEN-LAST:event_btnGraphikActionPerformed

 
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
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eleccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eleccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraphik;
    private javax.swing.JButton btnHaskell;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
