package br.com.unialfa.chamadostecnicos.usuario.business;

import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import br.com.unialfa.chamadostecnicos.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service public class UsuarioBusiness {

    @Autowired private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Iterable<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public void editarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public @ResponseBody void deletarUsuario(long id) {
        usuarioRepository.deleteById(id);
    }
}
