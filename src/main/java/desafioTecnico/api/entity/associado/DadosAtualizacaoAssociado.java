package desafioTecnico.api.entity.associado;

import desafioTecnico.api.entity.voto.Voto;

public record DadosAtualizacaoAssociado(Long id, String nome, String cpf, Voto voto) {

   public DadosAtualizacaoAssociado(Associado associado){

       this(associado.getId(),associado.getNome(), associado.getCpf(), associado.getVoto());
   }
}
