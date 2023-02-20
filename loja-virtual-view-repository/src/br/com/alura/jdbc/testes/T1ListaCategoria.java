package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class T1ListaCategoria {

	public static void main(String[] args) throws SQLException {
		
		try (Connection conn = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				
			});
		}
	}
}