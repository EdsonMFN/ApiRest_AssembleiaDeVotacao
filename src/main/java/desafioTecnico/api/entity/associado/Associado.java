package desafioTecnico.api.entity.associado;

import desafioTecnico.api.entity.voto.Voto;
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

    @Column(name = "cpf")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_voto")
    private Voto voto;

    public Associado(DadosCadastroAssociado dados) {

        this.id = dados.id();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.voto = dados.voto();
    }

    public void atualizarInformacaoAssociado(DadosAtualizacaoAssociado dados) {


            this.nome = dados.nome();

    }
}
