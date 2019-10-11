/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.Candidato_Escola_Controle;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Formatacao;
import ferramentas.Validacao;
import modelos.Candidato_Escola;

/**
 *
 * @author yuris
 */
public class DialogCandidatos_Escolas extends javax.swing.JDialog {

    Candidato_Escola objCandidato_Escola;
    Candidato_Escola_Controle objCandidato_Escola_Controle;
    Combos cbBairro;
    
    /**
     * Creates new form DialogCandidatos_Escolas
     */
    public DialogCandidatos_Escolas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        limparTela();
    }

    private void atualizarTabela(){
        try{
            
            objCandidato_Escola_Controle = new Candidato_Escola_Controle(null, jtbCandidatos_Escola);
            objCandidato_Escola_Controle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }   
    
    private void preencherCampos(){
        try{
            cbBairro.SetaComboBox(String.valueOf(objCandidato_Escola.getId_candidato()));
            cbBairro.SetaComboBox(String.valueOf(objCandidato_Escola.getId_escola()));
            txtData_Ingresso.setText(Formatacao.ajustaDataDMA(objCandidato_Escola.getData_ingresso()));
                
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
    
    private void limparTela(){
        try{
            //cbBairro.SetaComboBox(String.valueOf(""));
            txtData_Ingresso.setText("");
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbCandidato = new javax.swing.JComboBox<>();
        jcbEscola = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblData_Ingresso = new javax.swing.JLabel();
        lblCandidato = new javax.swing.JLabel();
        txtData_Ingresso = new javax.swing.JTextField();
        lblEscola = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCandidatos_Escola = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCandidatoActionPerformed(evt);
            }
        });
        getContentPane().add(jcbCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        getContentPane().add(jcbEscola, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 130, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro de Candidatos Escolas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 21, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 41, 470, -1));

        lblData_Ingresso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblData_Ingresso.setText("Data de Ingresso");
        getContentPane().add(lblData_Ingresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 84, -1, 10));

        lblCandidato.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCandidato.setText("Candidato");
        getContentPane().add(lblCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, -1, 10));
        getContentPane().add(txtData_Ingresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 140, 30));

        lblEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEscola.setText("Escola");
        getContentPane().add(lblEscola, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 84, -1, 10));

        jtbCandidatos_Escola.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCandidatos_Escola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCandidatos_EscolaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCandidatos_Escola);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 460, 100));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-save-close-24.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-erase-24.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 130, 30));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 140, 30));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        setSize(new java.awt.Dimension(516, 331));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbCandidatos_EscolaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCandidatos_EscolaMousePressed
        try{
            int linhaSelecionada = jtbCandidatos_Escola.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCandidatos_Escola.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 3 = EXCLUIR
            if(jtbCandidatos_Escola.isColumnSelected(3)){
                try{
                    objCandidato_Escola_Controle = new Candidato_Escola_Controle(null, null);
                    objCandidato_Escola = objCandidato_Escola_Controle.buscar(codigo);
                    if (objCandidato_Escola != null && objCandidato_Escola.getId() > 0){
                        preencherCampos();
                    }else{
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                    }
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        objCandidato_Escola = new Candidato_Escola();
                        objCandidato_Escola.setId(Integer.parseInt(lblId.getText()));

                        objCandidato_Escola_Controle = new Candidato_Escola_Controle(objCandidato_Escola, null);
                        boolean wControle = objCandidato_Escola_Controle.excluir();
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

                objCandidato_Escola_Controle = new Candidato_Escola_Controle(null, null);
                objCandidato_Escola = objCandidato_Escola_Controle.buscar(codigo);
                if (objCandidato_Escola != null && objCandidato_Escola.getId() > 0){
                    preencherCampos();
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
                }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbCandidatos_EscolaMousePressed

    private void jcbCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCandidatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCandidatoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;

            //validar os campos
            /*if(txtNome.getText().trim().length() == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro corretamente", 'a');
                return;
            }*/

            if(!Validacao.validarData(txtData_Ingresso.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe outra data!");
                return;
            }

            objCandidato_Escola = new Candidato_Escola();
            
            Combos c = (Combos) jcbCandidato.getSelectedItem();
            objCandidato_Escola.setId_candidato(Integer.parseInt(c.getCodigo()));
            
            c = (Combos) jcbEscola.getSelectedItem();
            objCandidato_Escola.setId_escola(Integer.parseInt(c.getCodigo()));

            String data = Formatacao.ajustaDataAMD(txtData_Ingresso.getText());
            objCandidato_Escola.setData_ingresso(data);

            if(!lblId.getText().equals("ID")){
                objCandidato_Escola.setId(Integer.parseInt(lblId.getText()));
                objCandidato_Escola_Controle = new Candidato_Escola_Controle(objCandidato_Escola, null);
                retorno = objCandidato_Escola_Controle.alterar();
            }else{
                objCandidato_Escola_Controle = new Candidato_Escola_Controle(objCandidato_Escola, null);
                retorno = objCandidato_Escola_Controle.incluir();
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

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogCandidatos_Escolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos_Escolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos_Escolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogCandidatos_Escolas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogCandidatos_Escolas dialog = new DialogCandidatos_Escolas(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jcbCandidato;
    private javax.swing.JComboBox<String> jcbEscola;
    private javax.swing.JTable jtbCandidatos_Escola;
    private javax.swing.JLabel lblCandidato;
    private javax.swing.JLabel lblData_Ingresso;
    private javax.swing.JLabel lblEscola;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtData_Ingresso;
    // End of variables declaration//GEN-END:variables
}
