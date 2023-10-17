package assembleia.rest.resquest;

import assembleia.enums.MensagemVoto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVoto {

    private String cpfAssociado;

    private MensagemVoto mensagemVoto;

    private Long idSessaoVotacao;

}
