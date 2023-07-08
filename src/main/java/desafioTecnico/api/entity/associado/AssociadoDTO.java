package desafioTecnico.api.entity.associado;

import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.VotoDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AssociadoDTO {

    private String cpf;
    private VotoDto votoDto;
    private Long idSessaoVotacao;
}
