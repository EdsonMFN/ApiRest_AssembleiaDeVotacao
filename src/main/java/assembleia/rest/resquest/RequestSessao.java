package assembleia.rest.resquest;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestSessao {

    private Long idVoto;
    private LocalDateTime inicioVotacao;
    private LocalDateTime fimVotacao;
    private Long idPauta;
}
