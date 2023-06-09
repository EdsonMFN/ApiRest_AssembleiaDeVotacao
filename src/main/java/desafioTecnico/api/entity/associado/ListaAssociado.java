package desafioTecnico.api.entity.associado;

import desafioTecnico.api.entity.voto.Voto;

public record ListaAssociado(Long id, String nome, String cpf, Voto voto) {

    public ListaAssociado (Associado associado){

        this(associado.getId(), associado.getNome(),associado.getCpf(), associado.getVoto());
    }
}
