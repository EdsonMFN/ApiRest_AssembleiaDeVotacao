package desafioTecnico.api.controller.response;

import desafioTecnico.api.entity.pauta.Pauta;

public record ResponsePauta(Long id, String topico, String mensagem) {

    public ResponsePauta(Pauta pauta){
        this(pauta.getId(), pauta.getTopico(), pauta.getMensagem());
    }
}
