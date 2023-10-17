package assembleia.rest.response;


import assembleia.domains.model.SessaoVotacaoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSessao{

    private SessaoVotacaoDTO sessaoVotacaoDTO;

    public ResponseSessao(SessaoVotacaoDTO sessaoVotacaoDTO) {
        this.sessaoVotacaoDTO = sessaoVotacaoDTO;
    }
}
