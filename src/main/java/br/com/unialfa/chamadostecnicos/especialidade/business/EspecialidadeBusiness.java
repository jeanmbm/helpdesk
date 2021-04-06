package br.com.unialfa.chamadostecnicos.especialidade.business;

import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;
import br.com.unialfa.chamadostecnicos.especialidade.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class EspecialidadeBusiness {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public void cadastrarEspecialidade(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    public Iterable<Especialidade> listarEspecialidade() {
        return especialidadeRepository.findAll();
    }

    public void editarEspecialidade(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    public @ResponseBody void deletarEspecialidade(long id) {
        especialidadeRepository.deleteById(id);
    }


}
