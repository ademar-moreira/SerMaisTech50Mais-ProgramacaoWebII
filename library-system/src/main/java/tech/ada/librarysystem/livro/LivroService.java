package tech.ada.librarysystem.livro;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
    private LivroRepository repository;

    private LivroService (LivroRepository repository) {
        this.repository = repository;
    }

    public void salvarLivro(LivroRequest livro) {
        repository.save(new LivroEntity(livro));
    }

    public Iterable<LivroDTO> getAll() {
        return converterEntidadeParaDTO();
    }

    private List<LivroDTO> converterEntidadeParaDTO() {
        List<LivroDTO> listaDeDTOs = new ArrayList<>();
        repository.findAll().forEach(item -> {
            listaDeDTOs.add(new LivroDTO(item));
        });
        return listaDeDTOs;
    }

    public LivroDTO getFirst() {
        LivroEntity entidade = repository.findById(1).get();
        return new LivroDTO(entidade);
    }
}