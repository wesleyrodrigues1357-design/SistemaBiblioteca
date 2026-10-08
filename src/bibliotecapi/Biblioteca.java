package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Livro;
import model.Usuario;

public class Biblioteca {

    // Cadastrar Livro
    public void cadastrarLivro(Livro livro) {

        try (Connection conn = Conexao.getConnection()) {

            String sql = "INSERT INTO livro "
                    + "(idLivro, titulo, autor, disponivel) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, livro.getIdLivro());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getAutor());

            // Método corrigido
            stmt.setBoolean(4, livro.disponivel());

            stmt.executeUpdate();

            System.out.println(
                    "Livro cadastrado no banco: "
                    + livro.getTitulo()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cadastrar Usuário
    public void cadastrarUsuario(Usuario usuario) {

        try (Connection conn = Conexao.getConnection()) {

            String sql = "INSERT INTO usuario "
                    + "(idUsuario, nome, email) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());

            stmt.executeUpdate();

            System.out.println(
                    "Usuário cadastrado no banco: "
                    + usuario.getNome()
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Emprestar Livro
    public void emprestarLivro(int idLivro, int idUsuario) {

        try (Connection conn = Conexao.getConnection()) {

            // Atualiza livro para não disponível
            String updateSql =
                    "UPDATE livro "
                    + "SET disponivel = false "
                    + "WHERE idLivro = ?";

            PreparedStatement updateStmt =
                    conn.prepareStatement(updateSql);

            updateStmt.setInt(1, idLivro);

            updateStmt.executeUpdate();

            // Registra empréstimo
            String insertSql =
                    "INSERT INTO emprestimo "
                    + "(idLivro, idUsuario, dataInicio, dataFim) "
                    + "VALUES (?, ?, CURDATE(), "
                    + "DATE_ADD(CURDATE(), INTERVAL 14 DAY))";

            PreparedStatement insertStmt =
                    conn.prepareStatement(insertSql);

            insertStmt.setInt(1, idLivro);
            insertStmt.setInt(2, idUsuario);

            insertStmt.executeUpdate();

            System.out.println(
                    "Livro emprestado para usuário ID "
                    + idUsuario
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Devolver Livro
    public void devolverLivro(int idLivro) {

        try (Connection conn = Conexao.getConnection()) {

            String updateSql =
                    "UPDATE livro "
                    + "SET disponivel = true "
                    + "WHERE idLivro = ?";

            PreparedStatement updateStmt =
                    conn.prepareStatement(updateSql);

            updateStmt.setInt(1, idLivro);

            int rows = updateStmt.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Livro devolvido com sucesso! ID: "
                        + idLivro
                );

            } else {

                System.out.println(
                        "Livro não encontrado ou já disponível."
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}