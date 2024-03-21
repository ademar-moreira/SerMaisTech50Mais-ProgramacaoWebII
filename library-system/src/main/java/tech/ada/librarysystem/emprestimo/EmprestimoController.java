package tech.ada.librarysystem.emprestimo;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tech.ada.librarysystem.membro.MembroEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emprestimos")
@ControllerAdvice
public class EmprestimoController {

    private EmprestimoService service;

    public EmprestimoController (EmprestimoService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/{idLivro}/{idMembro}")
    public ResponseEntity<EmprestimoRequest> salvarEmpretimo(@Valid @RequestBody EmprestimoRequest emprestimo, @PathVariable Integer idLivro, @PathVariable Integer idMembro) {
        service.salvarEmprestimo(emprestimo, idLivro, idMembro);
        return ResponseEntity.ok(emprestimo);
    }

    @GetMapping
    public Iterable<EmprestimoDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/nome/{membroNome}")
    public ResponseEntity<List<EmprestimoDTO>> getLoansByMemberName(@PathVariable String membroNome) {
        List<EmprestimoDTO> loans = service.searchLoansByMemberName(membroNome);
        return ResponseEntity.ok(loans);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
