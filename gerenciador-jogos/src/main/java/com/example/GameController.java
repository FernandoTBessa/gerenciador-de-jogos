package com.example;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    // LISTAR (Read)
    @GetMapping
    public List<Game> listarTodos() {
        return repository.findAll();
    }

    // SALVAR (Create)
    @PostMapping
    public Game salvar(@RequestBody Game novoJogo) {
        return repository.save(novoJogo);
    }
    // ATUALIZAR (Update)
    @PutMapping("/{id}")
    public Game atualizar(@PathVariable Long id, @RequestBody Game jogoAtualizado) {
        return repository.findById(id)
                .map(game -> {
                    game.setTitulo(jogoAtualizado.getTitulo());
                    // Adicione outros campos se tiver (genero, status, etc)
                    return repository.save(game);
                }).orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
    }

    // EXCLUIR (Delete) com tratamento de erro
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            // Tenta deletar o jogo
            repository.deleteById(id);
            return ResponseEntity.ok().build(); // Retorna Status 200 (Tudo certo)
            
        } catch (DataIntegrityViolationException e) {
            // Se o banco bloquear por causa da Chave Estrangeira (desenvolvedor vinculado)
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Não é possível excluir: Este jogo já está vinculado a um desenvolvedor ou tarefa.");
                    
        } catch (Exception e) {
            // Qualquer outro erro genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao tentar excluir o jogo.");
        }
    }
}