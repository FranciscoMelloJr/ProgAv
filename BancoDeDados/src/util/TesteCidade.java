package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteCidade {

	public static void main(String[] args) {
		
		try {
			
//			String nome = JOptionPane.showInputDialog("nome cidade");
//			String uf = JOptionPane.showInputDialog("uf");
//			
//			Cidade cidade = Cidade.builder()
//					.cidade(nome)
//					.uf(uf)
//					.build();
			
			Connection conn = Conexao.getConexao();
//			String sql = "insert into cidade(nome,UF) values(?,?)";
//			PreparedStatement preparedStatement = conn.prepareStatement(sql);
//			preparedStatement.setString(1, cidade.getCidade());
//			preparedStatement.setString(2, cidade.getUf());
//			preparedStatement.executeUpdate();
			
			String sqlSelect = "SELECT nome FROM cidade";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlSelect);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int cod = resultSet.getInt("cod");
				String cidade = resultSet.getString("nome");
				String uf = resultSet.getString("UF");
				System.out.println(cod + " " + cidade + " " + uf);
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
