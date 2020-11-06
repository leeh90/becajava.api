package br.universidade.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.universidade.app.model.Disciplina;
import br.universidade.app.model.Nota;
import br.universidade.app.repository.NotaRepository;

@Service
public class NotaService {
	
	final NotaRepository _repository;
	
	@Autowired
	public NotaService(NotaRepository repository) {
		_repository = repository;
	}	
	
	public void inserir(Nota nota) {
		nota.setId(new Long(0));
		_repository.save(nota);		
	}
	
	public List<Nota> listar(){	
		return _repository.findAll();
	}

	public void atualizar(Long id, Nota nota) {
		nota.setId(id);
		_repository.save(nota);
	}
	public Optional<Nota> listarUm(Long Id) {
		return _repository.findById(Id);
	}

	public void excluir(Long Id) {
		_repository.deleteById(Id);

	}
}
