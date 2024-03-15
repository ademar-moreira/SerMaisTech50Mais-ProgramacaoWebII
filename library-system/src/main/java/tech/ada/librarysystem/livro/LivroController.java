package tech.ada.librarysystem.livro;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/livros")
@ControllerAdvice
public class LivroController {

    private LivroService service;

    public LivroController (LivroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LivroRequest> salvarLivro(@Valid @RequestBody LivroRequest livro) {
        service.salvarLivro(livro);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public Iterable<LivroDTO> getAllLivros() {
        return service.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", java.time.LocalDateTime.now());
        body.put("status", org.springframework.http.HttpStatus.BAD_REQUEST.value());
        body.put("errors", errors);

        return new ResponseEntity<>(body, org.springframework.http.HttpStatus.BAD_REQUEST);
    }
}