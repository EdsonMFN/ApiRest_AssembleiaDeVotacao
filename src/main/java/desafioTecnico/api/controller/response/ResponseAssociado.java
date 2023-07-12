package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.voto.MensagemSucesso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAssociado extends MensagemSucesso {

    private AssociadoDTO associadoDTO;
}
