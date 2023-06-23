package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.associado.Associado;

public record ResponseAssociado(Long id, String nome, String cpf) {

    public ResponseAssociado(Associado associado){

        this(associado.getId(), associado.getNome(), associado.getCpf());
    }
}
