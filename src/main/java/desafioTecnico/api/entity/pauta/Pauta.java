package desafioTecnico.api.entity.pauta;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pauta")
@Entity (name = "Pauta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pauta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topico;
    private String mensagem;

    public Pauta(DadosCadastroPauta dados) {

        this.id = dados.id();
        this.topico = dados.topico();
        this.mensagem = dados.mensagem();
    }

    public void atualizarInfoPauta(DadosAtualizacaoPauta dados) {

        this.id = dados.id();
        this.topico = dados.topico();
        this.mensagem = dados.mensagem();
    }
}
