package desafioTecnico.api.service;

import desafioTecnico.api.controller.response.ResponseSessao;
import desafioTecnico.api.controller.resquest.RequestSessao;
import desafioTecnico.api.entity.pauta.Pauta;
import desafioTecnico.api.entity.pauta.PautaDTO;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.MensagemSucesso;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.repository.RepositoryPauta;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public ResponseSessao criarSessao (Long idPauta){

        Optional<Pauta> pauta = repositoryPauta.findById(idPauta);
        SessaoVotacao sessao = new SessaoVotacao();
        sessao.setInicioVotacao(LocalDateTime.now());
        sessao.setFimVotacao(fimVotacao());
        sessao.setPauta(pauta.get());
        sessao = repositorySessao.save(sessao);

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(sessao.getPauta().getId());
        pautaDTO.setMensagem(sessao.getPauta().getMensagem());
        pautaDTO.setTopico(sessao.getPauta().getTopico());

        SessaoVotacaoDTO sessaoDto = new SessaoVotacaoDTO();
        sessaoDto.setId(sessao.getId());
        sessaoDto.setPauta(pautaDTO);

        ResponseSessao responseSessao = new ResponseSessao();
        responseSessao.setSessaoVotacaoDTO(sessaoDto);

        return responseSessao;
    }

    public ResponseSessao buscarSessao (Long idSessaoVotacao){

        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(sessao.get().getPauta().getId());
        pautaDTO.setMensagem(sessao.get().getPauta().getMensagem());
        pautaDTO.setTopico(sessao.get().getPauta().getTopico());

        SessaoVotacaoDTO sessaoDto = new SessaoVotacaoDTO();
        sessaoDto.setId(sessao.get().getId());
        sessaoDto.setFimVotacao(sessao.get().getFimVotacao());
        sessaoDto.setInicioVotacao(sessao.get().getInicioVotacao());
        sessaoDto.setPauta(pautaDTO);

        ResponseSessao responseSessao = new ResponseSessao();
        responseSessao.setSessaoVotacaoDTO(sessaoDto);


        return responseSessao;
    }
    public List<ResponseSessao> listarSessoes() {
        List<SessaoVotacao> sessoes = repositorySessao.findAll();
        List<ResponseSessao> responseSessoes = new ArrayList<>();

        for (SessaoVotacao sessao : sessoes) {
            PautaDTO pautaDTO = new PautaDTO();
            pautaDTO.setId(sessao.getPauta().getId());
            pautaDTO.setMensagem(sessao.getPauta().getMensagem());
            pautaDTO.setTopico(sessao.getPauta().getTopico());

            SessaoVotacaoDTO sessaoDto = new SessaoVotacaoDTO();
            sessaoDto.setId(sessao.getId());
            sessaoDto.setPauta(pautaDTO);

            ResponseSessao responseSessao = new ResponseSessao();
            responseSessao.setSessaoVotacaoDTO(sessaoDto);

            responseSessoes.add(responseSessao);
        }

        return responseSessoes;
    }
    public ResponseSessao deletarSessaoVotacao(Long idSessaoVotacao){

        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);
        repositorySessao.delete(sessao.get());

        ResponseSessao responseSessao = new ResponseSessao();
        responseSessao.setMensagemSucesso(responseSessao.getMensagemSucesso());

        return responseSessao;
    }

    public Long incrementoTempoSessaoPadrao(){
        return tempoPadraoSessao;
    }
}
