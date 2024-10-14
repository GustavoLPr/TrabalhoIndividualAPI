package br.org.serratec.Biblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.Biblioteca.domain.Livro;
import br.org.serratec.Biblioteca.repository.LivroRepositorio;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepositorio livroRepositorio;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(livroRepositorio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        Optional<Livro> livroOptional = livroRepositorio.findById(id);
        if (livroOptional.isPresent()) {
            return ResponseEntity.ok(livroOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro inserir(@Valid @RequestBody Livro livro) {
        livro = livroRepositorio.save(livro);
        return livro;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
        if (!livroRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        livro.setId((id));
        livro = livroRepositorio.save(livro);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> remover (@PathVariable Long id){
        if (!livroRepositorio.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        livroRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
