/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.CandidatoControle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Formatacao;
import ferramentas.Validacao;
import java.sql.SQLException;
import modelos.Candidato;

/**
 *
 * @author yuris
 */
public class DialogCandidatos extends javax.swing.JDialog {

    
    Candidato objCandidato;
    CandidatoControle objCandidatoControle;
    Combos cbBairro;
    
    public DialogCandidatos(java.awt.Frame parent, boolean modal) {
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
            
            objCandidatoControle = new CandidatoControle(null, jtbCandidatos);
            objCandidatoControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }   
    
    private void preencherCampos(){
        try{
            lblId.setText(String.valueOf(objCandidato.getId()));
            txtNome.setText(objCandidato.getNome());
            cbBairro.SetaComboBox(String.valueOf(objCandidato.getId_bairro()));
            txtDataNasc.setText(Formatacao.ajustaDataDMA(objCandidato.getData_nasc()));
                
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            lblId.setText("ID");
            txtNome.setText("");
            cbBairro.SetaComboBox(String.valueOf(""));
            txtDataNasc.setText("");
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCandidatos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblDataNasc = new javax.swing.JLabel();
        jcbBairro = new javax.swing.JComboBox<>();
        txtDataNasc = new javax.swing.JTextField();
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

        jtbCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCandidatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCandidatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 460, 140));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro de Candidatos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-erase-24.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 200, -1));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 470, -1));

        lblDataNasc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDataNasc.setText("Data de Nascimento");
        getContentPane().add(lblDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jcbBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBairroActionPerformed(evt);
            }
        });
        getContentPane().add(jcbBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 200, -1));
        getContentPane().add(txtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 120, -1));

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
            if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro corretamente", 'a');
                return;
            }

            if(!Validacao.validarData(txtDataNasc.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe outra data!");
                return;
            }

            objCandidato = new Candidato();
            objCandidato.setNome(txtNome.getText().trim());

            Combos c = (Combos) jcbBairro.getSelectedItem();
            objCandidato.setId_bairro(Integer.parseInt(c.getCodigo()));

            String data = Formatacao.ajustaDataAMD(txtDataNasc.getText());
            objCandidato.setData_nasc(data);

            if(!lblId.getText().equals("ID")){
                objCandidato.setId(Integer.parseInt(lblId.getText()));
                objCandidatoControle = new CandidatoControle(objCandidato, null);
                retorno = objCandidatoControle.alterar();
            }else{
                objCandidatoControle = new CandidatoControle(objCandidato, null);
                retorno = objCandidatoControle.incluir();
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

    private void jtbCandidatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCandidatosMousePressed
        try{
            int linhaSelecionada = jtbCandidatos.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCandidatos.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 3 = EXCLUIR
            if(jtbCandidatos.isColumnSelected(3)){
                try{
                    objCandidatoControle = new CandidatoControle(null, null);
                    objCandidato = objCandidatoControle.buscar(codigo);
                    if (objCandidato != null && objCandidato.getId() > 0){
                        preencherCampos();
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                    }
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objCandidato = new Candidato();
                        objCandidato.setId(Integer.parseInt(lblId.getText()));

                        objCandidatoControle = new CandidatoControle(objCandidato, null);
                        boolean wControle = objCandidatoControle.excluir();
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

                objCandidatoControle = new CandidatoControle(null, null);
                objCandidato = objCandidatoControle.buscar(codigo);
                if (objCandidato != null && objCandidato.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbCandidatosMousePressed

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
            java.util.logging.Logger.getLogger(DialogCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogCandidatos dialog = new DialogCandidatos(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcbBairro;
    private javax.swing.JTable jtbCandidatos;
    private javax.swing.JLabel lblBairro1;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
