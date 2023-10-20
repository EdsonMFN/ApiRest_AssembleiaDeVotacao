package assembleia.rest.response;

import assembleia.domains.model.PautaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponsePauta {

    private PautaDTO pautaDTO;

    public ResponsePauta(PautaDTO pautaDTO) {
        this.pautaDTO = pautaDTO;
    }
    public String msgDelet() {
        return "Pauta deletada com sucesso";
    }
}
