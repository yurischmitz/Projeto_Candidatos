/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author jdhein
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        Menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuBairros = new javax.swing.JMenuItem();
        menuCandidatos = new javax.swing.JMenuItem();
        menuCandidatosEscolas = new javax.swing.JMenuItem();
        menuEscolas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuCadastro.setText("Cadastro");

        menuBairros.setText("Bairros");
        menuBairros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBairrosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuBairros);

        menuCandidatos.setText("Candidatos");
        menuCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCandidatosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCandidatos);

        menuCandidatosEscolas.setText("Candidatos das Escolas");
        menuCandidatosEscolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCandidatosEscolasActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCandidatosEscolas);

        menuEscolas.setText("Escolas");
        menuEscolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEscolasActionPerformed(evt);
            }
        });
        menuCadastro.add(menuEscolas);

        Menu.add(menuCadastro);

        setJMenuBar(Menu);

        setSize(new java.awt.Dimension(733, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuBairrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBairrosActionPerformed
        // TODO add your handling code here:
        DialogBairros dp = new DialogBairros(this, true);
        dp.setVisible(true);
    }//GEN-LAST:event_menuBairrosActionPerformed

    private void menuCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCandidatosActionPerformed
        // TODO add your handling code here:
        DialogCandidatos dp = new DialogCandidatos(this, true);
        dp.setVisible(true);
    }//GEN-LAST:event_menuCandidatosActionPerformed

    private void menuCandidatosEscolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCandidatosEscolasActionPerformed
        // TODO add your handling code here:
        DialogCandidatos_Escolas dp = new DialogCandidatos_Escolas(this, true);
        dp.setVisible(true);
    }//GEN-LAST:event_menuCandidatosEscolasActionPerformed

    private void menuEscolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscolasActionPerformed
        // TODO add your handling code here:
        DialogEscolas dp = new DialogEscolas(this, true);
        dp.setVisible(true);
    }//GEN-LAST:event_menuEscolasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem menuBairros;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCandidatos;
    private javax.swing.JMenuItem menuCandidatosEscolas;
    private javax.swing.JMenuItem menuEscolas;
    // End of variables declaration//GEN-END:variables
}
