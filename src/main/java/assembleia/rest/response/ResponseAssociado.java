package assembleia.rest.response;

import assembleia.domains.model.AssociadoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAssociado{

    private AssociadoDTO associadoDTO;

    public ResponseAssociado(AssociadoDTO associadoDTO) {
        this.associadoDTO = associadoDTO;
    }
}
