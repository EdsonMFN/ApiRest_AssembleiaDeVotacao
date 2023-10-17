package assembleia.domains.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
public class AssociadoDTO {

    private Long idAssociado;
    private String cpf;
    private String nome;
}
