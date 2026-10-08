package model;

public class Livro {

    private int id_livro;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(int id_livro, String titulo, String autor) {
    this.id_livro = id_livro;
    this.titulo = titulo;
    this.autor = autor;
    this.disponivel = true;
}

    public int getIdLivro() {
        return id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean disponivel() {
        return disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}