package desafioTecnico.api.controller.resquest;

import desafioTecnico.api.entity.associado.MensagemVoto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVoto {

    private String cpfAssociado;

    private MensagemVoto mensagemVoto;

    private Long idSessaoVotacao;

}
