package tech.ada.librarysystem.emprestimo;

import tech.ada.librarysystem.livro.LivroEntity;
import tech.ada.librarysystem.membro.MembroEntity;

import java.time.LocalDateTime;

public class EmprestimoDTO {
    private LocalDateTime data;
    private LivroEntity livro;
    private MembroEntity membro;

    public EmprestimoDTO() {}

    public EmprestimoDTO(EmprestimoEntity entity) {
        this.data = entity.getData();
        this.livro = entity.getLivro();
        this.membro = entity.getMembro();

    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LivroEntity getLivro() {
        return livro;
    }

    public void setLivro(LivroEntity livro) {
        this.livro = livro;
    }

    public MembroEntity getMembro() {
        return membro;
    }

    public void setMembro(MembroEntity membro) {
        this.membro = membro;
    }
}
