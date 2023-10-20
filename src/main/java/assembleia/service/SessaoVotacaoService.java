package assembleia.service;

import assembleia.domains.entity.pauta.Pauta;
import assembleia.domains.entity.sessaoVotacao.SessaoVotacao;
import assembleia.domains.model.PautaDTO;
import assembleia.domains.model.SessaoVotacaoDTO;
import assembleia.domains.repository.RepositoryPauta;
import assembleia.domains.repository.RepositorySessao;
import assembleia.domains.repository.RepositoryVoto;
import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.exception.handling.HandlerError;
import assembleia.rest.response.ResponseSessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public ResponseSessao criarSessao (Long idPauta){

        Pauta pauta = repositoryPauta.findById(idPauta).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idPauta + " não encontrada"));

        try {
            SessaoVotacao sessao = new SessaoVotacao();
            sessao.setInicioVotacao(LocalDateTime.now());
            sessao.setFimVotacao(fimVotacao());
            sessao.setPauta(pauta);
            sessao = repositorySessao.save(sessao);

            PautaDTO pautaDTO = PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build();

            return new ResponseSessao(SessaoVotacaoDTO
                    .builder()
                    .inicioVotacao(sessao.getInicioVotacao())
                    .fimVotacao(sessao.getFimVotacao())
                    .pauta(pautaDTO)
                    .build());

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public ResponseSessao buscarSessao (Long idSessaoVotacao){

        SessaoVotacao sessao = repositorySessao.findById(idSessaoVotacao).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idSessaoVotacao + " não encontrada"));

        var pauta = sessao.getPauta();

       try {
           PautaDTO pautaDTO = PautaDTO
                   .builder()
                   .id(pauta.getId())
                   .topico(pauta.getTopico())
                   .mensagem(pauta.getMensagem())
                   .build();

           return new ResponseSessao(SessaoVotacaoDTO
                   .builder()
                   .inicioVotacao(sessao.getInicioVotacao())
                   .fimVotacao(sessao.getFimVotacao())
                   .pauta(pautaDTO)
                   .build());

       }catch (Exception ex){
           throw new HandlerError(ex.getMessage());
       }
    }
    public List<ResponseSessao> listarSessoes() {
        try {
            List<SessaoVotacao> sessoes = repositorySessao.findAll();
            List<ResponseSessao> responseSessoes = new ArrayList<>();

            for (SessaoVotacao sessao : sessoes) {

                var pauta = sessao.getPauta();

                PautaDTO pautaDTO = PautaDTO
                        .builder()
                        .id(pauta.getId())
                        .topico(pauta.getTopico())
                        .mensagem(pauta.getMensagem())
                        .build();

                ResponseSessao responseSessao = new ResponseSessao(SessaoVotacaoDTO
                        .builder()
                        .inicioVotacao(sessao.getInicioVotacao())
                        .fimVotacao(sessao.getFimVotacao())
                        .pauta(pautaDTO)
                        .build());


                responseSessoes.add(responseSessao);
            }

            return responseSessoes;

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public void deletarSessaoVotacao(Long idSessaoVotacao){

        SessaoVotacao sessao = repositorySessao.findById(idSessaoVotacao).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idSessaoVotacao + " não encontrada"));
        try {
            repositorySessao.delete(sessao);

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }

    public Long incrementoTempoSessaoPadrao(){
        return tempoPadraoSessao;
    }
}
