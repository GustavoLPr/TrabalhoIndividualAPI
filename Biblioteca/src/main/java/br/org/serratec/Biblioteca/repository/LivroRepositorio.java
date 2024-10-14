package br.org.serratec.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.Biblioteca.domain.Livro;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long>{
    
}
