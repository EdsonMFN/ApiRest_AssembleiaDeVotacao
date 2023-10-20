package assembleia.rest.response;


import assembleia.domains.model.SessaoVotacaoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSessao{

    private SessaoVotacaoDTO sessaoVotacaoDTO;

    public ResponseSessao(SessaoVotacaoDTO sessaoVotacaoDTO) {
        this.sessaoVotacaoDTO = sessaoVotacaoDTO;
    }
    public String msgDelet() {
        return "Sessão deletada com sucesso";
    }
}
