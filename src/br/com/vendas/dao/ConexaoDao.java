package br.com.vendas.dao;
import java.sql.*;
public class ConexaoDao {
    
    public static Connection conector(){
    
        //Criando as variaveis necessarias
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gerenciadorvendas";
        String user = "root";
        String password = "root";
        
        //Estabelecendo a conexão
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            System.out.println(conexao);
            return conexao;
        }catch(Exception e){
            
            System.out.println("Falha na conexao " + e);
            return null;
        }//fim conexao
        
    }
}
