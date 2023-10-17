package assembleia.domains.model;

import assembleia.enums.MensagemVoto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class VotoDto {

    private String cpfAssociado;
    private MensagemVoto mensagemVoto;
}
