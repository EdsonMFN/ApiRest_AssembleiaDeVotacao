package desafioTecnico.api.entity.voto;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;

import java.time.LocalDateTime;

public record ResponseVoto(Long id, Associado associado, LocalDateTime dataHoraVoto, MensagemVoto mensagemVoto, SessaoVotacao sessaoVotacao) {

    public ResponseVoto(Voto voto){

        this(voto.getId(),voto.getAssociado(),voto.getDataHoraVoto(), voto.getMensagemVoto(),voto.getSessaoVotacao());
    }
}
