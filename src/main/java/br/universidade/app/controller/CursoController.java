package br.universidade.app.controller;

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
import org.springframework.web.bind.annotation.RestController;

import br.universidade.app.model.Aluno;
import br.universidade.app.model.Curso;
import br.universidade.app.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	private final CursoService _service;

	@Autowired
	CursoController(CursoService service) {
		_service = service;
	}

	@PostMapping
    public ResponseEntity inserir(@RequestBody Curso curso) {
        try {
            _service.inserir(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body("Curso inserido com sucesso!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível o cadastro do curso!");
        }
    }

    @GetMapping
    public ResponseEntity listar() {
        try {
            Iterable<Curso> cursos = _service.listar();
            return ResponseEntity.status(HttpStatus.OK).body(cursos);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não existe nenhum curso!");
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Long id) {
        try {
            Optional<Curso> curso = _service.listarUm(id);
            return ResponseEntity.status(HttpStatus.OK).body(curso);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Curso não existe!");
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        try {
            _service.atualizar(id, curso);
            return ResponseEntity.status(HttpStatus.OK).body("curso atualizado com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não foi possível a atualização!");
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        try {
            _service.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("curso excluídada com sucesso!!!");
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Não é possível excluir!");
        }
    }
}
