package assembleia.domains.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class PautaDTO {

    private Long id;
    private String topico;
    private String mensagem;
}
