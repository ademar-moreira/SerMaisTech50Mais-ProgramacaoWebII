package tech.ada.librarysystem.emprestimo;

import org.springframework.data.repository.CrudRepository;
import tech.ada.librarysystem.livro.LivroEntity;
import tech.ada.librarysystem.membro.MembroEntity;

import java.time.LocalDate;
import java.util.List;

public interface EmprestimoRepository extends CrudRepository<EmprestimoEntity, Integer> {
    List<EmprestimoEntity> findByMembro_NomeContainingIgnoreCase(String memberName);
}
