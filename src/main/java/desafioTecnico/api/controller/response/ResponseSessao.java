package desafioTecnico.api.controller.response;


import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.MensagemSucesso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSessao extends MensagemSucesso {

    private SessaoVotacaoDTO sessaoVotacaoDTO;
}
