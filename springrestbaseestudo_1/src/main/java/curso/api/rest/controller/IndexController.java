package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController //Arquitetura Rest
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Carregando lista de Usuários pelo ID
	@GetMapping(value = "/{id}")
	public Optional<Usuario> init(@PathVariable(value = "id") Long id){
		
		return usuarioRepository.findById(id);
	}
	
	//Carregando lista de Usuários
	@GetMapping(value = "/")
	public List<Usuario> usuario(){
		
		return (List<Usuario>) usuarioRepository.findAll(); 
		
	}
	
	//Salvar Usuários
	@PostMapping(value = "/")
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	//Atualizar Usuários
	@PutMapping(value = "/")
	public Usuario atualizar(@RequestBody Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}
	
	//Deletar Usuários
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		
		usuarioRepository.deleteById(id);
		
	}
	

}
