package model;

import java.time.LocalDate;

public class Emprestimo {
    private int idEmprestimo;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Emprestimo(int idEmprestimo, Livro livro, Usuario usuario, LocalDate dataInicio, LocalDate dataFim) {
        this.idEmprestimo = idEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Empréstimo #" + idEmprestimo + " - Livro: " + livro +
               " | Usuário: " + usuario +
               " | Início: " + dataInicio +
               " | Fim: " + dataFim;
    }
}
