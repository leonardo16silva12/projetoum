package br.com.etec.projetoum.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.projetoum.service.exceptions.ObjectNotFoundException;
import br.com.etec.projetoum.model.Cliente;
import br.com.etec.projetoum.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> pesquisarNome(String nome, Pageable pageable) {
		 return clienteRepository.findByNomeContaining(nome, pageable);
	}	
	
	public Cliente findCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
		"Cliente não encontrado(a)!!! Id: " + id + " Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Integer id) {
		findCliente(id);
		clienteRepository.deleteById(id);
	}
	
	public Cliente update(Cliente cliente){
		findCliente(cliente.getId());
		return clienteRepository.save(cliente);
	}

}
