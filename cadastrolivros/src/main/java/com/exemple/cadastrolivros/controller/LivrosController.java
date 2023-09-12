package com.exemple.cadastrolivros.controller;
import com.example.cadastrolivros.model.Livros;
import com.example.cadastrolivros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173")//Endereço do front
@RestController
@RequestMapping("/veiculos")
public class LivrosController {
    @Autowired
    private LivrosRepository LivrosRepository;
    @GetMapping
    public List<Livros> listarLivros() {
        return LivrosRepository.findAll();
    }
    @PostMapping
    public Livros criarLivros(@RequestBody Livros livros) {
        return LivrosRepository.save(livros);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivros(@PathVariable Long code) {
        if (LivrosRepository.existsById(code)) {
            LivrosRepository.deleteById(code);
            return ResponseEntity.ok("Livro deletado!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livros> atualizarLivros(@PathVariable Long code, @RequestBody Livros LivrosAtualizado) {
        if (LivrosRepository.existsById(code)) {
            Livros Livros = LivrosRepository.findById(code).get();
            Livros.setAutor(LivrosAtualizado.getAutor());
            Livros.setTitulo(LivrosAtualizado.getTitulo());
            Livros.setGenero(LivrosAtualizado.getGenero());

            Livros LivrosAtualizadoBD = LivrosRepository.save(Livros);
            return ResponseEntity.ok(LivrosAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
