package paradigmas;

//import Graphik.LexicoALS;
import Haskell.*;
import Haskell.Ejecutar.*;
import Graphik.*;
import Graphik.Ejecutar.Datos;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import static paradigmas.Eleccion.opcion;

public class Interfaz extends javax.swing.JFrame {

    public static ArrayList pestania = new ArrayList();
    public int contadorPestania = 0;
    String aux = "";
    String texto = "";
    String nombre = "";
    String ruta = "";

    public Interfaz() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        btnPublicar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnTraducir = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnCrearProyecto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 570, 350));

        btnPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.jpg"))); // NOI18N
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPublicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 50));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/less.jpg"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 50, 50));

        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/listar.jpg"))); // NOI18N
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/more.jpg"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 50));

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/open.jpg"))); // NOI18N
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 50, 50));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.jpg"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 50, 50));

        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cargar.jpg"))); // NOI18N
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        getContentPane().add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 50, 50));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono-login.jpg"))); // NOI18N
        btnLogin.setAutoscrolls(true);
        btnLogin.setName(""); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 50));

        btnTraducir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/j.png"))); // NOI18N
        btnTraducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraducirActionPerformed(evt);
            }
        });
        getContentPane().add(btnTraducir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 50, 50));

        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/como.jpg"))); // NOI18N
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarComo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 50, 50));

        btnCrearProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.jpg"))); // NOI18N
        btnCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProyectoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 50));

        txtConsola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConsolaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtConsola);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 570, 190));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/a.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        opcion = 0;
        Eleccion e = new Eleccion();
        e.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearProyectoActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
        Atributos.reporteSimbolo(Atributos.tablaSimboloHK, "HK");
        Atributos.reporteSimbolo(Atributos.tablaSimboloGK, "GK");
        imprimirConsola(">> Se ha creado el Reporte de Simbolos correctamente.");
    }//GEN-LAST:event_btnPublicarActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(".csv", ".csv");
            file.setFileFilter(filtro);
            file.showOpenDialog(this);
            File abre = file.getSelectedFile();
            ruta = abre.getAbsolutePath();
            nombre = abre.getName();
            System.out.println(ruta);
            texto = "";
            if (abre != null) {
                FileReader archivos = new FileReader(abre);

                try (BufferedReader lee = new BufferedReader(archivos)) {
                    while ((aux = lee.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }

        Datos.guardarDatos(texto);

    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        opcion = 1;
        Eleccion e = new Eleccion();
        e.setVisible(true);
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        opcion = 2;
        continuarSegunArchivo();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        opcion = 3;
        continuarSegunArchivo();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        jTabbedPane1.remove(jTabbedPane1.getSelectedIndex());
        pestania.remove(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTraducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraducirActionPerformed
        JPanel panel = (JPanel) this.jTabbedPane1.getSelectedComponent();
        JScrollPane scroll = (JScrollPane) panel.getComponent(0);
        JTextPane texto = (JTextPane) scroll.getViewport().getComponent(0);

        int ind = jTabbedPane1.getSelectedIndex();
        Pestania pes = (Pestania) pestania.get(ind);

        if ("hk".equals(pes.tipo)) {
            Atributos.tablaSimboloHK.clear();
            ReporteError.erroresHaskell.clear();
            try {
                Haskell.Analizar(texto.getText());
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex);
            }
            try {
                StringReader miReader = new StringReader(texto.getText());
                LexicoH miAnalizador = new LexicoH(miReader);

                texto.setText("");
                try {
                    Symbol s = null;
                    s = (Symbol) miAnalizador.next_token();
                    String lexema = "";
                    while (s.sym != 0) {
                        lexema = (String) s.value;
                        //System.out.println("*" + s.sym + "*");
                        if (lexema.toLowerCase().equals("if") || lexema.toLowerCase().equals("else") || lexema.toLowerCase().equals("case") || lexema.toLowerCase().equals("then")
                                || lexema.toLowerCase().equals("calcular") || lexema.toLowerCase().equals("succ") || lexema.toLowerCase().equals("decc") || lexema.toLowerCase().equals("sum")
                                || lexema.toLowerCase().equals("min") || lexema.toLowerCase().equals("max") || lexema.toLowerCase().equals("product") || lexema.toLowerCase().equals("revers")
                                || lexema.toLowerCase().equals("impr") || lexema.toLowerCase().equals("true") || lexema.toLowerCase().equals("false") || lexema.toLowerCase().equals("let")
                                || lexema.toLowerCase().equals("end") || lexema.toLowerCase().equals("par") || lexema.toLowerCase().equals("asc") || lexema.toLowerCase().equals("desc")
                                || lexema.toLowerCase().equals("length") || lexema.toLowerCase().equals("'mod'") || lexema.toLowerCase().equals("'sqrt'") || lexema.toLowerCase().equals("'pot'")) {
                            pintarAzul(lexema + " ");
                        } else if (10 == s.sym || 45 == s.sym) { //Cadena o caracter
                            pintarVerde(lexema + " ");
                        } else if ("COMENTARIO".equals(s.sym)) {
                            pintarCeleste(lexema + " ");
                        } else if (8 == s.sym) { //id
                            pintarNaranja(lexema + " ");
                        } else {
                            pintarNegro(lexema);
                        }
                        s = (Symbol) miAnalizador.next_token();
                    }
                } catch (Exception e) {
                }
            } catch (Exception ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("gk".equals(pes.tipo)) {
            Atributos.tablaSimboloGK.clear();
            ReporteError.erroresGraphik.clear();
            try {
                Graphik.Analizar(texto.getText());
                Graphik.iniciarEjecutar();
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex);
            }
            try {
                StringReader miReader = new StringReader(texto.getText());
                LexicoALS miAnalizador = new LexicoALS(miReader);
                texto.setText("");
                try {
                    Symbol s = null;
                    s = (Symbol) miAnalizador.next_token();
                    String lexema = "";
                    while (s.sym != 0) {
                        lexema = (String) s.value;
                        //System.out.println("*" + s.sym + "*");
                        if (lexema.toLowerCase().equals("hereda") || lexema.toLowerCase().equals("inicio") || lexema.toLowerCase().equals("nuevo") || lexema.toLowerCase().equals("llamar")
                                || lexema.toLowerCase().equals("llamarhk") || lexema.toLowerCase().equals("als") || lexema.toLowerCase().equals("var") || lexema.toLowerCase().equals("publico")
                                || lexema.toLowerCase().equals("privado") || lexema.toLowerCase().equals("protegido") || lexema.toLowerCase().equals("importar") || lexema.toLowerCase().equals("incluir_hk")
                                || lexema.toLowerCase().equals("vacio") || lexema.toLowerCase().equals("entero") || lexema.toLowerCase().equals("decimal") || lexema.toLowerCase().equals("cadena")
                                || lexema.toLowerCase().equals("caracter") || lexema.toLowerCase().equals("bool") || lexema.toLowerCase().equals("verdadero") || lexema.toLowerCase().equals("falso")
                                || lexema.toLowerCase().equals("imprimir") || lexema.toLowerCase().equals("si") || lexema.toLowerCase().equals("sino") || lexema.toLowerCase().equals("seleccion")
                                || lexema.toLowerCase().equals("caso") || lexema.toLowerCase().equals("defecto") || lexema.toLowerCase().equals("mientras") || lexema.toLowerCase().equals("hacer")
                                || lexema.toLowerCase().equals("para") || lexema.toLowerCase().equals("terminar") || lexema.toLowerCase().equals("continuar") || lexema.toLowerCase().equals("graphikar_funcion")
                                || lexema.toLowerCase().equals("datos") || lexema.toLowerCase().equals("procesar") || lexema.toLowerCase().equals("columna") || lexema.toLowerCase().equals("fila")
                                || lexema.toLowerCase().equals("donde") || lexema.toLowerCase().equals("dondecada") || lexema.toLowerCase().equals("verdadero") || lexema.toLowerCase().equals("dondetodo")) {
                            pintarAzul(lexema + " ");
                        } else if (57 == s.sym || 64 == s.sym) { //Cadena o caracter
                            pintarVerde(lexema + " ");
                        } else if ("COMENTARIO".equals(s.sym)) {
                            pintarCeleste(lexema + " ");
                        } else if (37 == s.sym) { //id
                            pintarNaranja(lexema + " ");
                        } else if (49 == s.sym || 50 == s.sym || 51 == s.sym || 70 == s.sym) { //id
                            pintarNegro(lexema + "\n");
                        } else {
                            pintarNegro(lexema);
                        }
                        s = (Symbol) miAnalizador.next_token();
                    }
                } catch (Exception e) {
                }
            } catch (Exception ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTraducirActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        ReporteError.reporteErrores(ReporteError.erroresHaskell, "HK");
        ReporteError.reporteErrores(ReporteError.erroresGraphik, "GK");
        imprimirConsola(">> Se ha creado el Reporte de Errores correctamente.");
    }//GEN-LAST:event_btnReportesActionPerformed

    private void txtConsolaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsolaKeyReleased
        //System.out.println("Soltó la tecla: " + KeyEvent.getKeyText(evt.getKeyCode()));
        if ("Enter".equals(KeyEvent.getKeyText(evt.getKeyCode()))) {
            //  System.out.println("Entro bitch");
            String texto[] = txtConsola.getText().split("\n");
            String linea = texto[texto.length - 1];
            System.out.println(linea);
            try {
                EjecutarHK.Analizar(linea);
            } catch (Exception ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            int ind = jTabbedPane1.getSelectedIndex();
            Pestania pes = (Pestania) pestania.get(ind);
            if ("hk".equals(pes.tipo)) {

                for (int i = 0; i < Atributos.imprimirHaskell.size(); i++) {
                    String s = ">> " + Atributos.imprimirHaskell.get(i) + "\n";
                    try {
                        txtConsola.getStyledDocument().insertString(txtConsola.getStyledDocument().getLength(), s, null);
                    } catch (BadLocationException ex) {
                        System.out.println("Error de consola = " + ex);
                    }
                }
                Atributos.imprimirHaskell.clear();
            } else {
                for (int i = 0; i < Atributos.imprimirGraphik.size(); i++) {
                    String s = ">> " + Atributos.imprimirGraphik.get(i) + "\n";
                    try {
                        txtConsola.getStyledDocument().insertString(txtConsola.getStyledDocument().getLength(), s, null);
                    } catch (BadLocationException ex) {
                        System.out.println("Error de consola = " + ex);
                    }
                }
                Atributos.imprimirGraphik.clear();
            }
        }
    }//GEN-LAST:event_txtConsolaKeyReleased

    public void imprimirConsola(String texto) {
        try {
            txtConsola.getStyledDocument().insertString(txtConsola.getStyledDocument().getLength(), texto, null);
        } catch (BadLocationException ex) {
            System.out.println("Error de consola = " + ex);
        }
    }

    public void continuarSegunArchivo() {
        switch (opcion) {
            case 0: //Nueva Pestania
                nombre = "Tab" + contadorPestania++ + "." + Atributos.lenguaje;
                JPanel p = new JPanel();
                JTextPane t = new JTextPane();
                p.setLayout(new BorderLayout());
                p.setSize(17, 50);
                t.setName(nombre);
                p.add(new JScrollPane(t));

                jTabbedPane1.addTab(nombre, null, p);
                Pestania pt = new Pestania(nombre, "", Atributos.lenguaje);
                pestania.add(pt);
                break;

            case 1: //Abrir
                try {
                    JFileChooser file = new JFileChooser();
                    FileNameExtensionFilter filtro = new FileNameExtensionFilter(Atributos.lenguaje, Atributos.lenguaje);
                    file.setFileFilter(filtro);
                    file.showOpenDialog(this);
                    File abre = file.getSelectedFile();
                    ruta = abre.getAbsolutePath();
                    nombre = abre.getName();
                    System.out.println(ruta);
                    texto = "";
                    if (abre != null) {
                        FileReader archivos = new FileReader(abre);

                        try (BufferedReader lee = new BufferedReader(archivos)) {
                            while ((aux = lee.readLine()) != null) {
                                texto += aux + "\n";
                            }
                        }
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex + ""
                            + "\nNo se ha encontrado el archivo",
                            "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
                }

                JPanel p1 = new JPanel();
                JTextPane t1 = new JTextPane();
                p1.setLayout(new BorderLayout());
                p1.setSize(17, 50);
                t1.setName(nombre);
                t1.setText(texto);
                p1.add(new JScrollPane(t1));
                jTabbedPane1.addTab(nombre, null, p1);
                Pestania pt1 = new Pestania(nombre, ruta, Atributos.lenguaje);
                pestania.add(pt1);
                break;

            case 2: //Guardar
                int i = jTabbedPane1.getSelectedIndex();
                Pestania pes = (Pestania) pestania.get(i);
                JPanel panel = (JPanel) this.jTabbedPane1.getSelectedComponent();
                JScrollPane scroll = (JScrollPane) panel.getComponent(0);
                JTextPane texto = (JTextPane) scroll.getViewport().getComponent(0);

                File archivo = new File(pes.ruta);
                BufferedWriter bw = null;

                try {
                    if (archivo.exists()) {
                        bw = new BufferedWriter(new FileWriter(archivo));
                        bw.write(texto.getText());

                    } else {
                        try {
                            JFileChooser file = new JFileChooser();
                            file.showSaveDialog(this);
                            File guarda = file.getSelectedFile();
                            ruta = guarda.getAbsolutePath();
                            if (guarda != null) {
                                try (FileWriter save = new FileWriter(guarda + "." + pes.tipo)) {
                                    save.write(texto.getText());
                                }
                                JOptionPane.showMessageDialog(null,
                                        "El archivo se a guardado exitosamente",
                                        "Información", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null,
                                    "Su archivo no se ha guardado",
                                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    bw.close();
                } catch (IOException | HeadlessException e) {
                }
                break;

            case 3: //Guardar Como
                Pestania pest = (Pestania) pestania.get(jTabbedPane1.getSelectedIndex());
                JPanel panel3 = (JPanel) this.jTabbedPane1.getSelectedComponent();
                JScrollPane scroll3 = (JScrollPane) panel3.getComponent(0);
                JTextPane texto3 = (JTextPane) scroll3.getViewport().getComponent(0);

                try {
                    JFileChooser file = new JFileChooser();
                    file.showSaveDialog(this);
                    File guarda = file.getSelectedFile();
                    ruta = guarda.getAbsolutePath();

                    if (guarda != null) {
                        FileWriter save = new FileWriter(guarda + "." + pest.tipo);
                        save.write(texto3.getText());
                        save.close();
                        JOptionPane.showMessageDialog(null,
                                "El archivo se a guardado exitosamente",
                                "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Su archivo no se ha guardado",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                pest.ruta = ruta;
                break;

            case 4:

                break;

        }
        opcion = 100;
    }

    public void importarArchivo(String nombre) {
        int ind = jTabbedPane1.getSelectedIndex();
        Pestania pes = (Pestania) pestania.get(ind);
        System.out.println("ruta = " + pes.ruta);
        String s = pes.ruta.replace("\\", "/");
        String dato[] = s.split("/");
        String path = "";
        for (int i = 0; i < dato.length - 1; i++) {
            path += dato[i] + "/";
        }
        String archivo = "";

        path += nombre + ".gk";
        System.out.println("Path = " + path);
        try {
            if (path != null) {
                FileReader archivos = new FileReader(path);
                try (BufferedReader lee = new BufferedReader(archivos)) {
                    while ((aux = lee.readLine()) != null) {
                        archivo += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            System.out.println("No encontro el archivo!!! = " + ex);
            return;
        }
        try {
            Graphik.Analizar(archivo);
        } catch (Exception ex) {
            System.out.println("Error al analizar ALS = " + ex);
        }

    }

    public void append(int r, int g, int b, String texto) {
        JPanel panel = (JPanel) this.jTabbedPane1.getSelectedComponent();
        JScrollPane scroll = (JScrollPane) panel.getComponent(0);
        JTextPane pane = (JTextPane) scroll.getViewport().getComponent(0);

        StyledDocument doc = pane.getStyledDocument();
        Style style = doc.addStyle("txt", null);

        Color color = new Color(r, g, b);
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), texto, style);
            pane.setCaretPosition(doc.getLength());
        } catch (BadLocationException ex) {
        }
    }

    public void pintarRojo(String texto) {
        append(255, 0, 0, texto);
    }

    public void pintarNegro(String texto) {
        append(0, 0, 0, texto);
    }

    public void pintarVerde(String texto) {
        append(55, 200, 0, texto);
    }

    public void pintarMorado(String texto) {
        append(165, 65, 155, texto);
    }

    public void pintarCeleste(String texto) {
        append(35, 120, 255, texto);
    }

    public void pintarAzul(String texto) {
        append(60, 15, 170, texto);
    }

    public void pintarNaranja(String texto) {
        append(250, 145, 30, texto);
    }

    public void pintarCafe(String texto) {
        append(200, 110, 5, texto);
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearProyecto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPublicar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnTraducir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane txtConsola;
    // End of variables declaration//GEN-END:variables
}
