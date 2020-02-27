package br.com.etec.projetoum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.projetoum.service.exceptions.ObjectNotFoundException;
import br.com.etec.projetoum.model.Cidade;
import br.com.etec.projetoum.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listarTodasCidades(){
		return cidadeRepository.findAll();
	}
	
	public Page<Cidade> pesquisarNome(String nome, Pageable pageable) {
		 return cidadeRepository.findByNomeContaining(nome, pageable);
	}
	
	public Cidade findCidade(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException(
		"Cidade não encontrada!!! Id: " + id + " Tipo: " + Cidade.class.getName()));
	}
	
	public Cidade insert(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public void delete(Integer id) {
		findCidade(id);
		cidadeRepository.deleteById(id);
	}
	
	public Cidade update(Cidade cidade){
		findCidade(cidade.getId());
		return cidadeRepository.save(cidade);
	}
	
	

}
