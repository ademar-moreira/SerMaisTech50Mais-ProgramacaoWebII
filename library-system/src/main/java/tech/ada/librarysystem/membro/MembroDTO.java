package tech.ada.librarysystem.membro;

public class MembroDTO {
    private Integer id;
    private String nome;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private String contato;

    public MembroDTO() {}

    public MembroDTO(MembroEntity Entity) {
        this.id = Entity.getId();
        this.nome = Entity.getNome();
        this.email = Entity.getEmail();
        this.endereco = Entity.getEndereco();
        this.cidade = Entity.getCidade();
        this.estado = Entity.getEstado();
        this.contato = Entity.getContato();
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
