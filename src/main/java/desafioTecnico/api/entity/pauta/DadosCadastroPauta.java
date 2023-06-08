package desafioTecnico.api.entity.pauta;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPauta(
        Long id,
        @NotBlank
        String topico,
        @NotBlank
        String mensagem) {
}
