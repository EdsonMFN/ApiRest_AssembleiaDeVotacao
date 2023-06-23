package desafioTecnico.api.entity.voto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VotoDto {

    private String cpfAssociado;
    private MensagemVoto mensagemVoto;
}
