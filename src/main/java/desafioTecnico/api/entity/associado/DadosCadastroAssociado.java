package desafioTecnico.api.entity.associado;

import desafioTecnico.api.entity.voto.Voto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAssociado(

        Long id,
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotNull
        Voto voto) {
}
