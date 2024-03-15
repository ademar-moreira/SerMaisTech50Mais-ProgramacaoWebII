package tech.ada.librarysystem.membro;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/membros")
@ControllerAdvice
public class MembroController {

    private MembroService service;

    public MembroController (MembroService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MembroRequest> salvarMembro(@Valid @RequestBody MembroRequest membro) {
        service.salvarMembro(membro);
        return ResponseEntity.ok(membro);
    }

    @GetMapping
    public Iterable<MembroDTO> getAllMembros() {
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