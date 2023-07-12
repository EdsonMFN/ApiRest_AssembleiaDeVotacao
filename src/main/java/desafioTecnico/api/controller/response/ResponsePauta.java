package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.pauta.PautaDTO;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.MensagemSucesso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePauta extends MensagemSucesso {

    private PautaDTO pautaDTO;
}
