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
 * @author Jonas Dhein
 */
public class Candidato_Escola_Controle {
    
    Candidato_Escola objCandidato_Escola;
    JTable jtbCandidatos_Escolas = null;
    
    public Candidato_Escola_Controle(Candidato_Escola objCandidato_Escola, JTable jtbCandidatos_Escolas) {
        this.objCandidato_Escola = objCandidato_Escola;
        this.jtbCandidatos_Escolas = jtbCandidatos_Escolas;
    } 
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            
            stmt = con.prepareStatement("INSERT INTO candidatos_escolas(id,id_candidato,id_escola,data_ingresso) VALUES(?,?,?,?)");
            stmt.setInt(1, objCandidato_Escola.getId_candidato());
            stmt.setInt(2, objCandidato_Escola.getId_escola());
            Date data_nasc = Date.valueOf(objCandidato_Escola.getData_ingresso());
            stmt.setDate(3, data_nasc);
            
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
            stmt = con.prepareStatement("UPDATE candidatos_escolas SET id_candidato=?, id_escola=?, data_ingresso=? WHERE id=?");
            stmt.setInt(1, objCandidato_Escola.getId_candidato());
            stmt.setInt(2, objCandidato_Escola.getId_escola());
            Date data_nasc = Date.valueOf(objCandidato_Escola.getData_ingresso());
            stmt.setDate(3, data_nasc);
            
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
        cabecalhos.add("Candidato");
        cabecalhos.add("Escola");
        cabecalhos.add("Ingresso");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, id_candidato, id_escola, data_ingresso ";
            SQL += " FROM candidatos_escolas ";
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
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
            
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCandidatos_Escolas.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCandidatos_Escolas.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCandidatos_Escolas.getColumnModel().getColumn(i);
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
        
        jtbCandidatos_Escolas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Candidato_Escola buscar(String id){
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id, id_candidato, id_escola, data_ingresso ";
            SQL += " FROM candidatos_escolas ";
            SQL += " WHERE id = '" + id + "'";
            SQL += " AND data_exclusao is null";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCandidato_Escola = new Candidato_Escola();
                if(rs.next() == true)
                {
                    objCandidato_Escola.setId(rs.getInt(1));
                    objCandidato_Escola.setId_candidato(rs.getInt(2));
                    objCandidato_Escola.setId_escola(rs.getInt(3));
                    objCandidato_Escola.setData_ingresso(rs.getString(4));
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
        
        System.out.println ("Executou buscar candidato_escola com sucesso");
        return objCandidato_Escola;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE candidatos_escolas SET data_exclusao = now() WHERE id=?");
            stmt.setInt(1, objCandidato_Escola.getId());
                        
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


