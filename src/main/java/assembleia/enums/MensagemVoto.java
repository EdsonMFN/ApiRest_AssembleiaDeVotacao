package assembleia.enums;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum MensagemVoto {

    SIM(1,"sim"),
    NAO(2,"nao");

    private Integer id;
    private String descricao;

    MensagemVoto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static MensagemVoto findById(Integer id){
        return Stream.of(MensagemVoto.values())
                .filter(value -> value.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Mensagem %s not found",id)));
    }
    public static MensagemVoto findByDescricap(String descriacao){
        return Stream.of(MensagemVoto.values())
                .filter(value -> value.getDescricao().equals(descriacao))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Mensagem %s not found",descriacao)));
    }
}
