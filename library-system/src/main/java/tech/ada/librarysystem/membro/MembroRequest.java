package tech.ada.librarysystem.membro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MembroRequest {
    @NotNull(message = "nome não pode estar nulo")
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotNull(message = "email não pode estar nulo")
    @NotBlank(message = "email não pode estar em branco")
    private String email;
    @NotNull(message = "senha não pode estar nulo")
    @NotBlank(message = "senha não pode estar em branco")
    private String senha;
    @NotNull(message = "endereço não pode estar nulo")
    @NotBlank(message = "endereço não pode estar em branco")
    private String endereco;
    @NotNull(message = "cidade não pode estar nulo")
    @NotBlank(message = "cidade não pode estar em branco")
    private String cidade;
    @NotNull(message = "estado não pode estar nulo")
    @NotBlank(message = "estado não pode estar em branco")
    private String estado;
    @NotNull(message = "contato não pode estar nulo")
    @NotBlank(message = "contato não pode estar em branco")
    private String contato;

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
        this.email = email;
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
