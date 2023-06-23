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

    private LocalDateTime fimVotacao(){
        return  LocalDateTime.now().plusSeconds(tempoPadraoSessao);
    }

    public ResponseSessao criarSessao (Long idPauta, RequestSessao requestSessao){

        Optional<Pauta> pauta = repositoryPauta.findById(idPauta);
        SessaoVotacao sessao = new SessaoVotacao();
        sessao.setInicioVotacao(LocalDateTime.now());
        sessao.setFimVotacao(fimVotacao());
        sessao.setPauta(pauta.get());
        sessao = repositorySessao.save(sessao);

        return new ResponseSessao(sessao);
    }

    public ResponseSessao buscarSessao (Long idSessao){

        SessaoVotacao sessaoVotacoes = repositorySessao.getReferenceById(idSessao);

        return new ResponseSessao(sessaoVotacoes);
    }

    public Long incrementoTempoSessaoPadrao(){
        return tempoPadraoSessao;
    }


}
