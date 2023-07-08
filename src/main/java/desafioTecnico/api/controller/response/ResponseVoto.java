package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVoto  {

    private SessaoVotacaoDTO sessaoVotacao;

}
