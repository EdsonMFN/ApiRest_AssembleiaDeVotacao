package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.entity.voto.Voto;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseSessao(Long id,LocalDateTime inicioVotacao, LocalDateTime fimVotacao, List<Voto> votosSim, List<Voto> votosNao) {

    public ResponseSessao (SessaoVotacao sessao){
        this(sessao.getId(), sessao.getInicioVotacao(),sessao.getFimVotacao(),sessao.getVotosSim(),sessao.getVotosNao());
    }
}
