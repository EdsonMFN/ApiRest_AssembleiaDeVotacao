package assembleia.domains.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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

    @Column (name = "nome",nullable = false)
    private String nome;

    @Column(name = "cpf",nullable = false)
    @CPF
    private String cpf;

    @Column(name = "email",nullable = false)
    @Email
    private String email;

}
