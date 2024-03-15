package tech.ada.librarysystem.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LivroRequest {
    @NotNull(message = "titulo não pode estar nulo")
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotNull(message = "autor não pode estar nulo")
    @NotBlank(message = "autor não pode estar em branco")
    private String autor;
    @NotNull(message = "anoPublicacao não pode estar nulo")
    @NotBlank(message = "anoPublicacao não pode estar em branco")
    private String anoPublicacao;
    @NotNull(message = "isbn não pode estar nulo")
    @NotBlank(message = "isbn não pode estar em branco")
    private String isbn;
    @NotNull(message = "quantidade não pode estar nulo")
    private Integer quantidade;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
