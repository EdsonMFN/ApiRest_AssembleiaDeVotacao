package desafioTecnico.api.entity.associado;

public record DadosAtualizacaoAssociado(Long id, String nome) {

   public DadosAtualizacaoAssociado(Associado associado){
       this(associado.getId(),associado.getNome());
   }
}
