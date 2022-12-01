package br.com.rodrigoeduque.livraria.controller;

import br.com.rodrigoeduque.livraria.model.Autor;
import br.com.rodrigoeduque.livraria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livraria")
public class LivrariaController {

    @Autowired
    AutorRepository repository;

    @PostMapping("/autor")
    public ResponseEntity<Void> novoAutor(@RequestBody @Valid AutorRequest request) {

        Autor autor = request.toAutor();
        repository.save(autor);

        URI uri = UriComponentsBuilder.fromPath("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
