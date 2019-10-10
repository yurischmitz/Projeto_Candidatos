package controles;

import banco.Conexao;
import ferramentas.Formatacao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
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
 * @author Jonas Dhein
 */
public class CandidatoControle {
    
    Candidato objCandidato;
    JTable jtbCandidatos = null;
    
    public CandidatoControle(Candidato objCandidato, JTable jtbCandidatos) {
        this.objCandidato = objCandidato;
        this.jtbCandidatos = jtbCandidatos;
    } 
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            
            stmt = con.prepareStatement("INSERT INTO candidatos(nome,id_bairro,data_nascimento) VALUES(?,?,?)");
            stmt.setString(1, objCandidato.getNome());
            stmt.setInt(2, objCandidato.getId_bairro());
            stmt.setString(3, objCandidato.getData_nasc());
            
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
            stmt = con.prepareStatement("UPDATE candidatos SET nome=?, id_bairro=?, data_nascimento=? WHERE id=?");
            stmt.setString(1, objCandidato.getNome());
            stmt.setInt(2, objCandidato.getId_bairro());
            stmt.setString(3, objCandidato.getData_nasc());
            stmt.setInt(4, objCandidato.getId());
            
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
        cabecalhos.add("Nascimento");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome, data_nascimento ";
            SQL += " FROM candidatos ";
            SQL += " WHERE data_exclusao is null ";
            SQL += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(Formatacao.ajustaDataDMA(result.getString(3)));
                //linha.add(result.getString(3));
                linha.add("      X");
                
                dadosTabela.add(linha);
            }
            
            
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCandidatos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCandidatos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCandidatos.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(250);
                    break;
                case 2:
                    column.setPreferredWidth(90);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbCandidatos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Candidato buscar(String id){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, nome, id_bairro, data_nascimento ";
            SQL += " FROM candidatos ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCandidato = new Candidato();
                if(rs.next() == true)
                {
                    objCandidato.setId(rs.getInt(1));
                    objCandidato.setNome(rs.getString(2));
                    objCandidato.setId_bairro(rs.getInt(3));
                    objCandidato.setData_nasc(rs.getString(4));
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
        return objCandidato;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE candidatos SET data_exclusao = now() WHERE id=?");
            stmt.setInt(1, objCandidato.getId());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    /*
    public ArrayList<Area> listar() {

        ConnectionFactory.abreConexao();
        
        ArrayList<Area> listagem_areas = new ArrayList();
        Area area_item = null;
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome AS nomeArea ";
            SQL += " FROM area ";
            SQL += " ORDER BY nome ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                area_item = new Area();
                area_item.setId(result.getInt("id"));
                area_item.setNome(result.getString("nomeArea"));
                listagem_areas.add(area_item);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
            return null;
        }
        
        return listagem_areas;
    }
    
    
    */
}
