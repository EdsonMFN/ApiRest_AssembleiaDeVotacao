package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.voto.Voto;

public record ResponseAssociado(Long id, String nome, String cpf, Voto voto) {

    public ResponseAssociado(Associado associado){

        this(associado.getId(), associado.getNome(), associado.getCpf(), associado.getVoto());
    }
}
