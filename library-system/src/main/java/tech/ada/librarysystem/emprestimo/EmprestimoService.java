package tech.ada.librarysystem.emprestimo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tech.ada.librarysystem.livro.LivroEntity;
import tech.ada.librarysystem.livro.LivroRepository;
import tech.ada.librarysystem.membro.MembroEntity;
import tech.ada.librarysystem.membro.MembroRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {
    private EmprestimoRepository repository;
    private LivroRepository livroRepository;
    private MembroRepository membroRepository;

    private EmprestimoService (EmprestimoRepository repository, LivroRepository livroRepository, MembroRepository membroRepository) {
        this.repository = repository;
        this.livroRepository = livroRepository;
        this.membroRepository = membroRepository;
    }

    public void salvarEmprestimo(EmprestimoRequest emprestimo, Integer idLivro, Integer idMembro){
        LivroEntity livro = livroRepository.findById(idLivro).orElseThrow(EntityNotFoundException::new);
        emprestimo.setLivro(livro);
        MembroEntity membro = membroRepository.findById(idMembro).orElseThrow(EntityNotFoundException::new);
        emprestimo.setMembro(membro);
        repository.save(new EmprestimoEntity(emprestimo));
    }

    public Iterable<EmprestimoDTO> getAll() {
        return converterEntidadeParaDTO();
    }

    private List<EmprestimoDTO> converterEntidadeParaDTO() {
        List<EmprestimoDTO> listaDeDTOs = new ArrayList<>();
        repository.findAll().forEach(item -> {
            listaDeDTOs.add(new EmprestimoDTO(item));
        });
        return listaDeDTOs;
    }

    public List<EmprestimoDTO> searchLoansByMemberName(String memberName) {
        List<EmprestimoEntity> emprestimoEntities = repository.findByMembro_NomeContainingIgnoreCase(memberName);
        return mudarEntidadeParaDTO(emprestimoEntities);
    }

    private List<EmprestimoDTO> mudarEntidadeParaDTO(List<EmprestimoEntity> entities) {
        List<EmprestimoDTO> listaDeDTOs = new ArrayList<>();
        entities.forEach(item -> {
            listaDeDTOs.add(new EmprestimoDTO(item));
        });
        return listaDeDTOs;
    }
}
