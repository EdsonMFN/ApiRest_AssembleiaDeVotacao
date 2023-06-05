package desafioTecnico.api.entity.associado;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "associado")
@Entity (name = "Associado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Associado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String voto;

    public Associado(DadosCadastroAssociado dados) {

        this.id = dados.id();
        this.nome = dados.nome();
        this.voto = dados.voto();
    }

    public void atualizarInformacaoAssociado(DadosAtualizacaoAssociado dados) {


            this.nome = dados.nome();

    }
}
