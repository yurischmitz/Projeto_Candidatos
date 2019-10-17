/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.EscolaControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import java.sql.SQLException;
import modelos.Escola;

/**
 *
 * @author yuris
 */
public class DialogEscolas extends javax.swing.JDialog {

    Escola objEscola;
    EscolaControle objEscolaControle;
    Combos cbBairro;
    
    public DialogEscolas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            cbBairro = new Combos(jcbBairro);
            cbBairro.PreencheCombo("SELECT id, nome FROM " + "bairros ORDER BY nome");
        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }     
        limparTela();
    }

    private void atualizarTabela(){
        try{
            
            objEscolaControle = new EscolaControle(null, jtbEscolas);
            objEscolaControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }   
    
    private void preencherCampos(){
        try{
            lblId.setText(String.valueOf(objEscola.getId()));
            txtEscola.setText(objEscola.getNome());
            txtVagas.setText(String.valueOf(objEscola.getVagas()));
            cbBairro.SetaComboBox(String.valueOf(objEscola.getId_bairro()));
                
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            lblId.setText("ID");
            txtEscola.setText("");
            txtVagas.setText("");
            cbBairro.SetaComboBox(String.valueOf(""));
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEscolas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        lblEscola = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtEscola = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblVagas = new javax.swing.JLabel();
        jcbBairro = new javax.swing.JComboBox<>();
        txtVagas = new javax.swing.JTextField();
        lblBairro1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-save-close-24.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 110, 30));

        jtbEscolas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Título 1"
            }
        ));
        jtbEscolas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbEscolasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbEscolas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 460, 140));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro de Escolas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-erase-24.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 100, 30));

        lblEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEscola.setText("Escola");
        getContentPane().add(lblEscola, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        getContentPane().add(txtEscola, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 200, -1));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 500, -1));

        lblVagas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblVagas.setText("Vagas");
        getContentPane().add(lblVagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jcbBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBairroActionPerformed(evt);
            }
        });
        getContentPane().add(jcbBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 200, -1));
        getContentPane().add(txtVagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, -1));

        lblBairro1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBairro1.setText("Bairro");
        getContentPane().add(lblBairro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        setSize(new java.awt.Dimension(516, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;

            //validar os campos
            if(txtEscola.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma escola corretamente", 'a');
                return;
            }
            
            objEscola = new Escola();
            objEscola.setNome(txtEscola.getText().trim());
            objEscola.setVagas(Integer.parseInt(txtVagas.getText()));
            System.out.println(objEscola.getVagas());

            Combos c = (Combos) jcbBairro.getSelectedItem();
            objEscola.setId_bairro(Integer.parseInt(c.getCodigo()));


            if(!lblId.getText().equals("ID")){
                objEscola.setId(Integer.parseInt(lblId.getText()));
                objEscolaControle = new EscolaControle(objEscola, null);
                retorno = objEscolaControle.alterar();
            }else{
                objEscolaControle = new EscolaControle(objEscola, null);
                retorno = objEscolaControle.incluir();
            }

            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }

            atualizarTabela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbEscolasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbEscolasMousePressed
        try{
            int linhaSelecionada = jtbEscolas.getSelectedRow();//pega a linha selecionada
            String codigo = jtbEscolas.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 3 = EXCLUIR
            if(jtbEscolas.isColumnSelected(3)){
                try{
                    objEscolaControle = new EscolaControle(null, null);
                    objEscola = objEscolaControle.buscar(codigo);
                    if (objEscola != null && objEscola.getId() > 0){
                        preencherCampos();
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                    }
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objEscola = new Escola();
                        objEscola.setId(Integer.parseInt(lblId.getText()));

                        objEscolaControle = new EscolaControle(objEscola, null);
                        boolean wControle = objEscolaControle.excluir();
                        if (wControle){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                        limparTela();
                    }
                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{

                objEscolaControle = new EscolaControle(null, null);
                objEscola = objEscolaControle.buscar(codigo);
                if (objEscola != null && objEscola.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbEscolasMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void jcbBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbBairroActionPerformed

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
            java.util.logging.Logger.getLogger(DialogEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogEscolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEscolas dialog = new DialogEscolas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbBairro;
    private javax.swing.JTable jtbEscolas;
    private javax.swing.JLabel lblBairro1;
    private javax.swing.JLabel lblEscola;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblVagas;
    private javax.swing.JTextField txtEscola;
    private javax.swing.JTextField txtVagas;
    // End of variables declaration//GEN-END:variables
}
