package com.example.cadastrolivros.controller;
import com.example.cadastrolivros.model.Autor;
import com.example.cadastrolivros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/Autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    @GetMapping
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }
    @PostMapping
    public Autor criarFabricante(@RequestBody Autor Autor) {
        return autorRepository.save(Autor);
    }

}
