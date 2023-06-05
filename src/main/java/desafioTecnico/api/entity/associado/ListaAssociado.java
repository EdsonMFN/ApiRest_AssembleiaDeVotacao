package desafioTecnico.api.entity.associado;

public record ListaAssociado(Long id, String nome, String voto) {

    public ListaAssociado (Associado associado){

        this(associado.getId(), associado.getNome(), associado.getVoto());
    }
}
