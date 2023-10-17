package assembleia.rest.response;

import assembleia.domains.model.PautaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePauta {

    private PautaDTO pautaDTO;

    public ResponsePauta(PautaDTO pautaDTO) {
        this.pautaDTO = pautaDTO;
    }
}
