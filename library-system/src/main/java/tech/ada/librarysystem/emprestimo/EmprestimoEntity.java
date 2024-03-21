package tech.ada.librarysystem.emprestimo;

import jakarta.persistence.*;
import org.hibernate.mapping.ToOne;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import tech.ada.librarysystem.livro.LivroEntity;
import tech.ada.librarysystem.membro.MembroEntity;

import java.time.LocalDateTime;

@Entity
public class EmprestimoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime data;
    @OneToOne
    @JoinColumn(name = "livro_id")
    private LivroEntity livro;
    @OneToOne
    @JoinColumn(name = "membro_id")
    private MembroEntity membro;

    public EmprestimoEntity() {}

    public EmprestimoEntity(EmprestimoRequest request) {
        this.data = request.getData();
        this.livro = request.getLivro();
        this.membro = request.getMembro();
    }

    public LivroEntity getLivro() {
        return livro;
    }

    public MembroEntity getMembro() {
        return membro;
    }

    public void setLivro(LivroEntity livro) {
        this.livro = livro;
    }

    public void setMembro(MembroEntity membro) {
        this.membro = membro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

}
