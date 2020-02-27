package br.com.etec.projetoum.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.projetoum.model.Cliente;
import br.com.etec.projetoum.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/todos")
	public List<Cliente> listarTodos(){
		return clienteService.listarTodosClientes();
	}
	
	@GetMapping()
	public Page<Cliente> pesquisarNome(@RequestParam(required = false, 
			defaultValue = "")String nome, Pageable pageable){
		return clienteService.pesquisarNome(nome, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id){
		Cliente cliente = clienteService.findCliente(id);
		return ResponseEntity.ok().body(cliente);
		}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Cliente cliente) {
		cliente = clienteService.insert(cliente);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Integer id){
		clienteService.update(cliente);
		return ResponseEntity.noContent().build();
	}

}
