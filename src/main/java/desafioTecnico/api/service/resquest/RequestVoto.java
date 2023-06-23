package desafioTecnico.api.service.resquest;

import desafioTecnico.api.entity.associado.MensagemVoto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVoto {

    private String cpf;

    private MensagemVoto mensagemVoto;

    private Long idSessaoVotacao;

}