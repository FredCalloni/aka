package com.example.cadastrolivros.repository;


import com.example.cadastrolivros.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LivrosRepository extends JpaRepository<Livros, Long> {
}

