package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public class UsuarioDAO {
	Connection connection;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean existeUsuario(Usuario usuario) {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			if (stmt.executeQuery().next()) {
				return true;
			}
			return false;
		} catch(SQLException e) {
			throw new RuntimeException("Erro na autenticação do usuário.", e);
		}
	}
}
