package br.com.vendas.model;

import br.com.vendas.dao.ConexaoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;



public class Cliente {
    private String nome;
    private String endereco;
    private String emial;
    private double limiteCredito;
    private String documento;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Cliente(){}
    
    public Cliente(String nome, String endereco, String emial, double limiteCredito, String documento) {
        this.nome = nome;
        this.endereco = endereco;
        this.emial = emial;
        this.limiteCredito = limiteCredito;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getDocumento() {
        return documento;
    }
    private void setDocumento(String documento){
        this.documento = documento;
    }

    public void alterarDocumento(){
        
        JPanel panel = new JPanel(new GridLayout(2, 2));

            // Cria rótulos e campos de texto
            JLabel userLabel = new JLabel("Usuário:");
            JTextField usuario = new JTextField();

            JLabel passwordLabel = new JLabel("Senha:");
            JPasswordField senha = new JPasswordField();

            // Adiciona os componentes ao painel
            panel.add(userLabel);
            panel.add(usuario);
            panel.add(passwordLabel);
            panel.add(senha);

            // Exibe a janela de diálogo
            int result = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            // Verifica a opção selecionada pelo usuário
            if (result == JOptionPane.OK_OPTION) {
                
                String username = usuario.getText();
                String password = new String(senha.getPassword());

                // Exibe o nome de usuário e a senha capturados (apenas para fins de demonstração)
                // Em um aplicativo real, você deve verificar as credenciais de forma segura
                System.out.println("Usuário: " + username);
                System.out.println("Senha: " + password);
                
            } else {
                System.out.println("Login cancelado");
            }
        
        
        String sql = "select * from usuarios where usuario=? and senha=?";
        
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, usuario.getText());
            String captura = new String(senha.getPassword());
            pst.setString(2, captura);
            rs = pst.executeQuery();
            
            if(rs.next()){
                setDocumento(documento);
                
                        
                        
                        
                
            }
            
            } catch (Exception e) {
            }
    }
    
    
    
    
}
