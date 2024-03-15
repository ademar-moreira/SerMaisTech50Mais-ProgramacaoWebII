package tech.ada.librarysystem.membro;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembroService {
    private MembroRepository repository;

    private MembroService (MembroRepository repository) {
        this.repository = repository;
    }

    public void salvarMembro(MembroRequest membro) {
        repository.save(new MembroEntity(membro));
    }

    public Iterable<MembroDTO> getAll() {
        return converterEntidadeParaDTO();
    }

    private List<MembroDTO> converterEntidadeParaDTO() {
        List<MembroDTO> listaDeDTOs = new ArrayList<>();
        repository.findAll().forEach(item -> {
            listaDeDTOs.add(new MembroDTO(item));
        });
        return listaDeDTOs;
    }

    public MembroDTO getFirst() {
        MembroEntity entidade = repository.findById(1).get();
        return new MembroDTO(entidade);
    }
}
