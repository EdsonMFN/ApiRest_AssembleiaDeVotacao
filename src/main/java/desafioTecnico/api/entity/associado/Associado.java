package desafioTecnico.api.entity.associado;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "associado")
@Entity (name = "Associado")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Associado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_associado")
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;
    @Column (name = "nome")
    private String nome;

    @Column(name = "cpf")
        private String cpf;

    public Associado(Long id, String nome, String cpf){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
}
