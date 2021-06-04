package br.com.unialfa.chamadostecnicos.usuario.service;

import br.com.unialfa.chamadostecnicos.usuario.business.UsuarioBusiness;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {


    @Autowired private UsuarioBusiness usuarioBusiness;


    @PostMapping(path = "/add")
    public ResponseEntity<?> cadastarUsuario(@RequestBody Usuario usuario) {
        try {
            usuarioBusiness.cadastrarUsuario(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Usuario> listarUsuario() {
        return usuarioBusiness.listarUsuario();
    }

    @GetMapping(path="/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable (name = "idUsuario") long id) {
        return usuarioBusiness.buscarUsuarioPorId(id);
    }

    @PutMapping(path = "/edit")
    public void editarUsuario(@RequestBody Usuario usuario) {      // Não poderá ser editado email, cpf e nome
        usuarioBusiness.editarUsuario(usuario);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarUsuario(@PathVariable(name = "id") long id){
        usuarioBusiness.deletarUsuario(id);
    }

}
