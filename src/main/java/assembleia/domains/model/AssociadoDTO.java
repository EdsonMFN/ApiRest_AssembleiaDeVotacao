package assembleia.domains.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AssociadoDTO {

    private Long idAssociado;
    private String cpf;
    private String nome;
    private String email;
}
