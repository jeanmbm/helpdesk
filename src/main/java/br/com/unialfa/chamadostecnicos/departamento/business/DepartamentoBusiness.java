package br.com.unialfa.chamadostecnicos.departamento.business;

import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import br.com.unialfa.chamadostecnicos.departamento.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class DepartamentoBusiness {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void cadastrarDepartamento(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    public Iterable<Departamento> listarDepartamento() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> departamentoPorId(long id) {
        return departamentoRepository.findById(id);
    }

    public void editarDepartamento(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    public @ResponseBody void deletarDepartamento(long id) {
        departamentoRepository.deleteById(id);
    }

}
