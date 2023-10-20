package assembleia.domains.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "pauta")
@Entity (name = "Pauta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pauta {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pauta")
    @PrimaryKeyJoinColumns(value = {@PrimaryKeyJoinColumn})
    private Long id;

    @Column(name = "topico",nullable = false)
    private String topico;

    @Column(name = "mensagem",nullable = false)
    private String mensagem;


}
