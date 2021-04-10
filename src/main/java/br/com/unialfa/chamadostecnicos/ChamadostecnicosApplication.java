package br.com.unialfa.chamadostecnicos;

import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Acompanhamento;
import br.com.unialfa.chamadostecnicos.acompanhamento.domain.Avaliacao;
import br.com.unialfa.chamadostecnicos.acompanhamento.repository.AcompanhamentoRepository;
import br.com.unialfa.chamadostecnicos.acompanhamento.repository.AvaliacaoRepository;
import br.com.unialfa.chamadostecnicos.categoriaservico.domain.Categoria;
import br.com.unialfa.chamadostecnicos.categoriaservico.repository.CategoriaRepository;
import br.com.unialfa.chamadostecnicos.chamado.domain.Chamado;
import br.com.unialfa.chamadostecnicos.enuns.Status;
import br.com.unialfa.chamadostecnicos.chamado.repository.ChamadoRepository;
import br.com.unialfa.chamadostecnicos.departamento.domain.Departamento;
import br.com.unialfa.chamadostecnicos.departamento.repository.DepartamentoRepository;
import br.com.unialfa.chamadostecnicos.especialidade.domain.Especialidade;
import br.com.unialfa.chamadostecnicos.especialidade.repository.EspecialidadeRepository;
import br.com.unialfa.chamadostecnicos.enuns.Area;
import br.com.unialfa.chamadostecnicos.enuns.Prioridade;
import br.com.unialfa.chamadostecnicos.servico.domain.Servico;
import br.com.unialfa.chamadostecnicos.servico.repository.ServicoRepository;
import br.com.unialfa.chamadostecnicos.usuario.domain.Usuario;
import br.com.unialfa.chamadostecnicos.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class ChamadostecnicosApplication {


	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private AcompanhamentoRepository acompanhamentoRepository;


	public static void main(String[] args) {
		SpringApplication.run(ChamadostecnicosApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {

		Categoria categoria = new Categoria();
		categoria.setNome("Categoria este");
		categoria.setDescricao("Fusce viverra facilisis cubilia, dictum.");
		categoriaRepository.save(categoria);

		Servico servico = new Servico();
		servico.setNome("Servico teste");
		servico.setDescricao("Bibendum curabitur donec cubilia, magna.");
		servico.setPrioridade(Prioridade.BAIXA);
		servico.setCategoria(categoria);
		servico.setArea(Area.SOFTWARE);
		servicoRepository.save(servico);

		Departamento departamento = new Departamento();
		departamento.setNome("Departamento teste");
		departamento.setDescricao("Leo curabitur vehicula massa, sed.");
		departamentoRepository.save(departamento);

		Especialidade especialidade = new Especialidade();
		especialidade.setNome("Especialidade teste");
		especialidade.setDescricao("Sit platea et etiam, sem.");
		especialidade.setArea(Area.SOFTWARE);
		especialidadeRepository.save(especialidade);

		Usuario usuario = new Usuario();
		usuario.setNome("José da Silva");
		usuario.setTelefone("(62) 99999-9999");
		usuario.setCpf("111.111.111-11");
		usuario.setEmail("emailteste@gmail.com");
		usuario.setSenha("123456");
		usuario.setDepartamento(departamento);
		usuario.setTecnico(true);
		usuario.setEspecialidade(especialidade);
		usuarioRepository.save(usuario);

		Chamado chamado = new Chamado();  //só poderá ser atualizado o status
		chamado.setDataAbertura(LocalDate.now());
		chamado.setPrazoSolucao(LocalDate.now().plusDays(20));
		chamado.setDataSolucao(LocalDate.now().plusDays(10));
		chamado.setMensagem("Problema no computador");
		chamado.setServico(servico);
		chamado.setStatus(Status.ANALISE);
		chamado.setUsuario(usuario);
		chamadoRepository.save(chamado);

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setDataAvaliacao(LocalDate.now());
		avaliacao.setComentario("Ótimo atendimento");
		avaliacao.setQuantEstrelas(5);
		avaliacaoRepository.save(avaliacao);

		Acompanhamento acompanhamento = new Acompanhamento();
		acompanhamento.setChamado(chamado);
		acompanhamento.setAvaliacao(avaliacao);
		acompanhamento.setTecnico(usuario);
		acompanhamento.setChamado(chamado);
		acompanhamento.setFinalizadoTecnico(false);
		acompanhamento.setFinalizadoUsuario(false);
		acompanhamentoRepository.save(acompanhamento);

		return null;
	}

}
