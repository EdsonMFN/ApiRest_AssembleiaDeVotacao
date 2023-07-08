package desafioTecnico.api.entity.sessaoVotacao;

import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.pauta.PautaDTO;
import desafioTecnico.api.entity.voto.VotoDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SessaoVotacaoDTO {

    private Long id;
    private LocalDateTime inicioVotacao;
    private LocalDateTime fimVotacao;
    private PautaDTO pauta;
    private List<VotoDto> votosSim;
    private List<VotoDto> votosNao;
}
