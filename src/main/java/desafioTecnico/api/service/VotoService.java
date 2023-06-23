package desafioTecnico.api.service;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.service.resquest.RequestVoto;
import desafioTecnico.api.service.response.ResponseVoto;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.repository.RepositoryAssociado;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    @Autowired
    private RepositoryAssociado repositoryAssociado;

    @Autowired
    private RepositorySessao repositorySessao;

    @Autowired
    private RepositoryVoto repositoryVoto;

    private LocalDateTime dataVoto(){
        return LocalDateTime.now();
    }

    public ResponseVoto cadastroVoto(Long idSessaoVotacao, RequestVoto requestVoto){

        Associado associado = repositoryAssociado.findByCpf(requestVoto.getCpf());
        LocalDateTime dataVoto = dataVoto();
        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);
        Voto voto = new Voto();
        voto.setAssociado(associado);
        voto.setDataHoraVoto(dataVoto);
        voto.setMensagemVoto(requestVoto.getMensagemVoto());
        voto.setSessaoVotacao(sessao.get());
        voto = repositoryVoto.save(voto);


        if (voto.getMensagemVoto() == MensagemVoto.SIM){

            sessao.get().getVotosSim().add(voto);
            repositorySessao.save(sessao.get());

        }else {

            sessao.get().getVotosNao().add(voto);
            repositorySessao.save(sessao.get());

        }
        return new ResponseVoto(voto);
    }
    public List<ResponseVoto> listagemVoto(){

        List<Voto> votos = repositoryVoto.findAll();

        return votos.stream().map(ResponseVoto::new).toList();
    }
}
