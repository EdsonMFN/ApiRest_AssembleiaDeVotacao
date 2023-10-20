package assembleia.rest.response;

import assembleia.domains.model.AssociadoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseAssociado{

    private AssociadoDTO associadoDTO;

    public ResponseAssociado(AssociadoDTO associadoDTO) {
        this.associadoDTO = associadoDTO;
    }
    public String msgDelet() {
        return "Associado deletado com sucesso";
    }
}
