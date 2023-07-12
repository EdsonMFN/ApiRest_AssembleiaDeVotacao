package desafioTecnico.api.entity.voto;

import desafioTecnico.api.entity.associado.MensagemVoto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDto {

    private String cpfAssociado;
    private MensagemVoto mensagemVoto;
}
