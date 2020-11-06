package br.universidade.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.universidade.app.model.Aluno;
import br.universidade.app.repository.AlunoRepository;

@Service
public class AlunoService {

	final AlunoRepository _repository;

	@Autowired
	public AlunoService(AlunoRepository respository) {
		_repository = respository;
	}

	public void inserir(Aluno aluno) {
		aluno.setId(new Long(0));
		_repository.save(aluno);
	}

	public List<Aluno> listar() {
		return _repository.findAll();
	}

	public void atualizar(Long id, Aluno aluno) {
		aluno.setId(id);
		_repository.save(aluno);
	}
	
	public Optional<Aluno> listarUm(Long Id) {
		return _repository.findById(Id);
	}

	public void excluir(Long Id) {
		_repository.deleteById(Id);

	}

}