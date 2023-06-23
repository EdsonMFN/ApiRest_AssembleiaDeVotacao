package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.Voto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.function.Function;

@Getter
@Setter
public class ResponseVoto  {

    private SessaoVotacaoDTO sessaoVotacao;
    private AssociadoDTO cpfAssociadoDto;

}
