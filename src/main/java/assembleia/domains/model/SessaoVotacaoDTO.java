package assembleia.domains.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SessaoVotacaoDTO {

    private Long id;
    private LocalDateTime inicioVotacao;
    private LocalDateTime fimVotacao;
    private PautaDTO pauta;
    private List<VotoDto> votosSim;
    private List<VotoDto> votosNao;
}
