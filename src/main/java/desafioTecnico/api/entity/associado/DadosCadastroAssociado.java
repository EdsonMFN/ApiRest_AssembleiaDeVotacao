package desafioTecnico.api.entity.associado;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAssociado(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        Voto voto) {
}
