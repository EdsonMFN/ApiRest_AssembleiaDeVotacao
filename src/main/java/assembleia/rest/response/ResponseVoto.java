package assembleia.rest.response;

import assembleia.domains.model.SessaoVotacaoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVoto {

    private SessaoVotacaoDTO sessaoVotacao;
}
