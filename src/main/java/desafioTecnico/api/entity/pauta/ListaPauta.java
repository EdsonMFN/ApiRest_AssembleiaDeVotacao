package desafioTecnico.api.entity.pauta;

public record ListaPauta(Long id, String topico, String mensagem) {

    public ListaPauta(Pauta pauta){

        this(pauta.getId(),pauta.getTopico(),pauta.getMensagem());
    }
}
