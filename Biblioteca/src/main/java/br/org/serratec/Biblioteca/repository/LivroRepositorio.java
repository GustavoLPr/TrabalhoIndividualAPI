package br.org.serratec.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.Biblioteca.domain.Livro;

public interface LivroRepositorio extends JpaRepository<Livro, Long>{
    
}
