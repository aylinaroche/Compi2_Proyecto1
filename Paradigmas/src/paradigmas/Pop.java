package paradigmas;

import Graphik.Ejecutar.Datos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static javax.swing.text.StyleConstants.Foreground;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Aylin
 */
public class Pop extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public Pop() {
        initComponents();
        String[][] data = {
            {"Mary", "Campione", "Esquiar"},
            {"Lhucas", "Huml", "Patinar"},
            {"Kathya", "Walrath", "Escalar"},
            {"Marcus", "Andrews", "Correr"},
            {"Angela", "Lalth", "Nadar"}
        };
        String[] column = {"Nombre", "Apellido",
            "Años de Practica"};
        modelo = new DefaultTableModel(Datos.tabla, Datos.titulo);//
        //  modelo = new DefaultTableModel(data, column);
        tabla.setModel(modelo);
        JTableHeader th;
        th = tabla.getTableHeader();
        Font fuente = new Font("Lucida Calligraphy", Font.PLAIN, 14);

        th.setFont(fuente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 102, 102));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tabla.setGridColor(new java.awt.Color(255, 204, 204));
        tabla.setSelectionForeground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(tabla);
        tabla.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 440, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maze.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 490, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Pop().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
