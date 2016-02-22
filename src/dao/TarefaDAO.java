package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Tarefa;

@Repository
public class TarefaDAO {
	private Connection connection;
	
	@Autowired
	public TarefaDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public void insere(Tarefa tarefa) {
		String sql = "INSERT INTO tarefa(descricao, finalizado"
				+ ", dataFinalizacao) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, tarefa.getDataFinalizacao() == null ? null : new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na inser��o. Erro: " + e.getMessage());
		}
	}
	
	public List<Tarefa> lista() {
		List<Tarefa> tarefas = new ArrayList<>();
		String sql = "SELECT * FROM tarefa";
		try (PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Tarefa t = new Tarefa();
				t.setId(rs.getLong("id"));
				t.setDescricao(rs.getString("descricao"));
				t.setFinalizado(rs.getBoolean("finalizado"));
				if (rs.getDate("dataFinalizacao") != null) {
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					t.setDataFinalizacao(data);
				}
				tarefas.add(t);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro na listagem. Erro: " + e.getMessage());
		}
		return tarefas;
	}
	
	public void exclui(Long id) {
		String sql = "DELETE FROM tarefa WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na remo��o. Erro: " + e.getMessage());
		}
	}
	
	public Tarefa buscaPorId(Long id) {
		Tarefa tarefa = new Tarefa();
		String sql = "SELECT * FROM tarefa WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					tarefa.setId(id);
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setFinalizado(rs.getBoolean("finalizado"));
					if (rs.getDate("dataFinalizacao") != null) {
						Calendar data = Calendar.getInstance();
						data.setTime(rs.getDate("dataFinalizacao"));
						tarefa.setDataFinalizacao(data);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro na listagem. Erro: " + e.getMessage());
		}
		return tarefa;
	}
	
	public void altera(Tarefa tarefa) {
		String sql = "UPDATE tarefa SET descricao=?, finalizado=?"
				+ ", dataFinalizacao=? WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, tarefa.getDataFinalizacao() == null ? null : new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na inser��o. Erro: " + e.getMessage());
		}
	}
	
	public void finaliza(Long id) {
		String sql = "UPDATE tarefa SET finalizado=?"
				+ ", dataFinalizacao=? WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(3, id);
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro na finaliza��o de tarefa. Erro: " + e.getMessage());
		}
	}
			
}
