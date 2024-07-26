package dio.my_first_web_api.controller;

import dio.my_first_web_api.model.Usuario;
import dio.my_first_web_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    //listar todos os usuários
    @GetMapping()
    public List<Usuario> getUsers(){
        return repository.findAll();

    }

    //buscar apenas 1 usuario
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }


    //Delete
    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    //Post
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    //Put
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

}
