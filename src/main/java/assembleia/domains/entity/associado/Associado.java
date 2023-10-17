package assembleia.domains.entity.associado;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "associado")
@Entity (name = "Associado")
@Data
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

}
