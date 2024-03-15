package tech.ada.librarysystem.membro;

import jakarta.persistence.*;

@Entity
public class MembroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cidade;
    private String estado;
    private String contato;

    public MembroEntity() {}

    public MembroEntity(MembroRequest request) {
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.senha = request.getSenha();
        this.endereco = request.getEndereco();
        this.cidade = request.getCidade();
        this.estado = request.getEstado();
        this.contato = request.getContato();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = String.valueOf(email);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
