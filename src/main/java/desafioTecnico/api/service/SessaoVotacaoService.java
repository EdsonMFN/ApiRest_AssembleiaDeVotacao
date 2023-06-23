package desafioTecnico.api.service;

import desafioTecnico.api.controller.response.ResponseSessao;
import desafioTecnico.api.controller.resquest.RequestSessao;
import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.repository.RepositoryPauta;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoVotacaoService {

    @Value("${tempo.sessao.votacao.segundos}")
    private Long tempoPadraoSessao;

    @Autowired
    private RepositorySessao repositorySessao;

    @Autowired
    private RepositoryVoto repositoryVoto;

    @Autowired
    private RepositoryPauta repositoryPauta;

    private LocalDateTime fimVotacao(LocalDateTime fimVotacao){
        return  fimVotacao == null ? LocalDateTime.now().plusSeconds(tempoPadraoSessao) : fimVotacao;
    }

    public ResponseSessao criarSessao (Long idVoto, Long idPauta, RequestSessao requestSessao, LocalDateTime fimVotacao, ResponseSessao responseSessao){

        Optional<Voto> voto = repositoryVoto.findById(requestSessao.getIdVoto());
        Optional<Pauta> pauta = repositoryPauta.findById(requestSessao.getIdPauta());
        SessaoVotacao sessao = new SessaoVotacao();
        sessao.setInicioVotacao(LocalDateTime.now());
        sessao.setFimVotacao(fimVotacao(fimVotacao));
        sessao.setPauta(pauta.get());
        sessao = repositorySessao.save(sessao);

        return new ResponseSessao(sessao);
    }

    public List<ResponseSessao> listarSessao(){

        List<SessaoVotacao> sessaoVotacaos = repositorySessao.findAll();

        return sessaoVotacaos.stream().map(ResponseSessao::new).toList();
    }

    public Long incrementoTempoSessaoPadrao(){
        return tempoPadraoSessao;
    }


}
