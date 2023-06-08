package desafioTecnico.api.entity.associado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAssociado(

        Long id,
        @NotBlank
        String nome,
        @NotNull
        Voto voto) {
}
