
package controles;

import banco.Conexao;
import ferramentas.Formatacao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.*;

/**
 *
 * @author yuris
 */
public class EscolaControle {
    Escola objEscola;
    JTable jtbEscolas = null;
    
    public EscolaControle(Escola objEscola, JTable jtbEscolas) {
        this.objEscola = objEscola;
        this.jtbEscolas = jtbEscolas;
    } 
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            System.out.println(objEscola.getVagas());
            stmt = con.prepareStatement("INSERT INTO escolas(nome,vagas,id_bairro) VALUES(?,?,?)");
            stmt.setString(1, objEscola.getNome());
            stmt.setInt(2, objEscola.getVagas());
            stmt.setInt(3, objEscola.getId_bairro());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public boolean alterar(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE escolas SET nome=?, vagas=?,id_bairro=? WHERE id=?");
            stmt.setString(1, objEscola.getNome());
            stmt.setInt(2, objEscola.getVagas());
            stmt.setInt(3, objEscola.getId_bairro());
            stmt.setInt(4, objEscola.getId());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
    
    public void preencher(){

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("Vagas");
        //cabecalhos.add("Bairro");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome, vagas ";
            SQL += " FROM escolas ";
            SQL += " WHERE data_exclusao is null ";
            SQL += " ORDER BY nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getInt(3));
                //linha.add(result.getInt(4));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
            
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbEscolas.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbEscolas.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbEscolas.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(50);
                    break;
                case 1:
                    column.setPreferredWidth(200);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbEscolas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
    
    public Escola buscar(String id){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, nome, vagas, id_bairro ";
            SQL += " FROM escolas ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objEscola = new Escola();
                if(rs.next() == true)
                {
                    objEscola.setId(rs.getInt(1));
                    objEscola.setNome(rs.getString(2));
                    objEscola.setVagas(rs.getInt(3));
                    objEscola.setId_bairro(rs.getInt(4));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar candidato com sucesso");
        return objEscola;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE escolas SET data_exclusao = now() WHERE id=?");
            stmt.setInt(1, objEscola.getId());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
}