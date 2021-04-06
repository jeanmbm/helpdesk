package br.com.unialfa.chamadostecnicos.usuario.service;

import br.com.unialfa.chamadostecnicos.usuario.business.UsuarioBusiness;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {

    @Autowired private UsuarioBusiness usuarioBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Usuario> listarUsuario() {
        return usuarioBusiness.listarUsuario();
    }

    @PostMapping(path = "/add")
    public void cadastarUsuario(@RequestBody Usuario usuario) {
        usuarioBusiness.cadastrarUsuario(usuario);
    }

    @PutMapping(path = "/edit")
    public void editarUsuario(@RequestBody Usuario usuario) {
        usuarioBusiness.editarUsuario(usuario);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarUsuario(@PathVariable(name = "id") long id){
        usuarioBusiness.deletarUsuario(id);
    }



}
