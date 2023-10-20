package assembleia.service;

import assembleia.domains.entity.Associado;
import assembleia.domains.entity.SessaoVotacao;
import assembleia.domains.entity.Voto;
import assembleia.domains.model.PautaDTO;
import assembleia.domains.model.SessaoVotacaoDTO;
import assembleia.domains.model.VotoDto;
import assembleia.domains.repository.RepositoryAssociado;
import assembleia.domains.repository.RepositorySessao;
import assembleia.domains.repository.RepositoryVoto;
import assembleia.enums.MensagemVoto;
import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.exception.handling.HandlerError;
import assembleia.rest.response.ResponseVoto;
import assembleia.rest.resquest.RequestVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VotoService {

    @Autowired
    private RepositoryAssociado repositoryAssociado;

    @Autowired
    private RepositorySessao repositorySessao;

    @Autowired
    private RepositoryVoto repositoryVoto;

    private LocalDateTime dataVoto(){
        return LocalDateTime.now();
    }

    private String MensagemSucesso(){

        String mensagemSucesso = "voto deletado com sucesso";
        return mensagemSucesso;

    }

    public ResponseVoto criarVoto(Long idSessaoVotacao, String cpfAssociado, RequestVoto requestVoto){

        SessaoVotacao sessao = repositorySessao.findById(idSessaoVotacao).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + cpfAssociado + " não encontrada"));

        try {
            Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

            Voto voto = new Voto();
            voto.setAssociado(associado);
            voto.setDataHoraVoto(dataVoto());
            voto.setMensagemVoto(requestVoto.getMensagemVoto());
            voto.setSessaoVotacao(sessao);
            voto = repositoryVoto.save(voto);

            if (MensagemVoto.SIM.equals(voto.getMensagemVoto())){

                sessao.getVotosSim().add(voto);
                repositorySessao.save(sessao);
            }else {
                sessao.getVotosNao().add(voto);
                repositorySessao.save(sessao);
            }
            var pauta = sessao.getPauta();

            PautaDTO pautaDTO = PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build();

            SessaoVotacaoDTO sessaoDto = SessaoVotacaoDTO
                    .builder()
                    .inicioVotacao(sessao.getInicioVotacao())
                    .fimVotacao(sessao.getFimVotacao())
                    .pauta(pautaDTO)
                    .build();

            List<VotoDto> votosDto = new ArrayList<>();
            sessaoDto.setVotosSim(votosDto);
            sessaoDto.setVotosNao(votosDto);

            ResponseVoto responseVoto = new ResponseVoto();
            responseVoto.setSessaoVotacao(sessaoDto);

            return responseVoto;

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ResponseVoto listagemVoto(Long idSessaoVotacao){

        SessaoVotacao sessao = repositorySessao.findById(idSessaoVotacao).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idSessaoVotacao + " não encontrada"));

        try {
            var pauta = sessao.getPauta();

            PautaDTO pautaDTO = PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build();

            SessaoVotacaoDTO sessaoDto = SessaoVotacaoDTO
                    .builder()
                    .inicioVotacao(sessao.getInicioVotacao())
                    .fimVotacao(sessao.getFimVotacao())
                    .pauta(pautaDTO)
                    .build();

            ResponseVoto responseVoto = new ResponseVoto();
            responseVoto.setSessaoVotacao(sessaoDto);

            List<Voto> votos = repositoryVoto.findBySessaoVotacao(sessao);
            List<ResponseVoto> responseVotos = new ArrayList<>();
            List<VotoDto> votosNao = new ArrayList<>();
            List<VotoDto> votosSim = new ArrayList<>();

            for (Voto voto : votos){

                VotoDto votoDto = VotoDto
                        .builder()
                        .mensagemVoto(voto.getMensagemVoto())
                        .cpfAssociado(voto.getAssociado().getCpf())
                        .build();

                if (MensagemVoto.SIM.equals(voto.getMensagemVoto())){

                    sessaoDto.setVotosSim(votosSim);
                    sessaoDto.getVotosSim().add(votoDto);
                }else {

                    sessaoDto.setVotosNao(votosNao);
                    sessaoDto.getVotosNao().add(votoDto);

                }
                responseVotos.add(responseVoto);
            }
            return responseVoto;

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ResponseVoto buscarDadosAssociado(String cpfAssociado, Long idSessaoVotacao){

        SessaoVotacao sessao = repositorySessao.findById(idSessaoVotacao).map(a->a)
                .orElseThrow(() -> new HandlerEntityNotFound("Entidade com id " + idSessaoVotacao + " não encontrada"));
        try {
            Associado associado = repositoryAssociado.findByCpf(cpfAssociado);
            var pauta = sessao.getPauta();

            PautaDTO pautaDTO = PautaDTO
                    .builder()
                    .id(pauta.getId())
                    .topico(pauta.getTopico())
                    .mensagem(pauta.getMensagem())
                    .build();

            SessaoVotacaoDTO sessaoDto = SessaoVotacaoDTO
                    .builder()
                    .inicioVotacao(sessao.getInicioVotacao())
                    .fimVotacao(sessao.getFimVotacao())
                    .pauta(pautaDTO)
                    .build();

            ResponseVoto responseVoto = new ResponseVoto();
            responseVoto.setSessaoVotacao(sessaoDto);

            Voto voto = repositoryVoto.findBySessaoVotacaoAndAssociado(sessao,associado);
            List<VotoDto> votosNao = new ArrayList<>();
            List<VotoDto> votosSim = new ArrayList<>();

            VotoDto votoDto = VotoDto
                    .builder()
                    .mensagemVoto(voto.getMensagemVoto())
                    .cpfAssociado(cpfAssociado)
                    .build();

            if (MensagemVoto.SIM.equals(voto.getMensagemVoto())){

                sessaoDto.setVotosSim(votosSim);
                sessaoDto.getVotosSim().add(votoDto);
            }else {

                sessaoDto.setVotosNao(votosNao);
                sessaoDto.getVotosNao().add(votoDto);
            }

            return responseVoto;

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
