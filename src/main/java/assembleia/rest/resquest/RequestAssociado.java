package assembleia.rest.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestAssociado {

    private Long idAssociado;
    private String nome;
    private String cpf;
    private String email;
}
