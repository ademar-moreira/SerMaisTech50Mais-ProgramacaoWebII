package tech.ada.librarysystem.emprestimo;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import tech.ada.librarysystem.livro.LivroEntity;
import tech.ada.librarysystem.membro.MembroEntity;

import java.time.LocalDateTime;

public class EmprestimoRequest {
    @NotNull(message = "data não pode estar nulo")
    private LocalDateTime data;
    private EmprestimoRequest emprestimo;
    private LivroEntity livro;
    private MembroEntity membro;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setEmprestimo(EmprestimoRequest emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void setLivro(LivroEntity livro) {
        this.livro = livro;
    }

    public void setMembro(MembroEntity membro) {
        this.membro = membro;
    }

    public LivroEntity getLivro() {
        return livro;
    }

    public MembroEntity getMembro() {
        return membro;
    }
}
