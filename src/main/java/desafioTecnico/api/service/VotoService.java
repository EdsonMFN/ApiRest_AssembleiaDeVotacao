package desafioTecnico.api.service;

import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.entity.associado.MensagemVoto;
import desafioTecnico.api.entity.pauta.PautaDTO;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacao;
import desafioTecnico.api.controller.resquest.RequestVoto;
import desafioTecnico.api.controller.response.ResponseVoto;
import desafioTecnico.api.entity.sessaoVotacao.SessaoVotacaoDTO;
import desafioTecnico.api.entity.voto.Voto;
import desafioTecnico.api.entity.voto.VotoDto;
import desafioTecnico.api.repository.RepositorySessao;
import desafioTecnico.api.repository.RepositoryAssociado;
import desafioTecnico.api.repository.RepositoryVoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseVoto criarVoto(Long idSessaoVotacao, String cpfAssociado, RequestVoto requestVoto){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);
        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);
        Voto voto = new Voto();
        voto.setAssociado(associado);
        voto.setDataHoraVoto(dataVoto());
        voto.setMensagemVoto(requestVoto.getMensagemVoto());
        voto.setSessaoVotacao(sessao.get());
        voto = repositoryVoto.save(voto);

        if (MensagemVoto.SIM.equals(voto.getMensagemVoto())){

            sessao.get().getVotosSim().add(voto);
            repositorySessao.save(sessao.get());
        }else {
            sessao.get().getVotosNao().add(voto);
            repositorySessao.save(sessao.get());
        }

        PautaDTO pautaDto = new PautaDTO();
        pautaDto.setId(sessao.get().getPauta().getId());
        pautaDto.setTopico(sessao.get().getPauta().getTopico());
        pautaDto.setMensagem(sessao.get().getPauta().getMensagem());

        SessaoVotacaoDTO sessaoDto = new SessaoVotacaoDTO();
        sessaoDto.setId(sessao.get().getId());
        sessaoDto.setFimVotacao(sessao.get().getFimVotacao());
        sessaoDto.setInicioVotacao(sessao.get().getInicioVotacao());
        sessaoDto.setPauta(pautaDto);

        List<VotoDto> votoDto = new ArrayList<>();
        sessaoDto.setVotosSim(votoDto);
        sessaoDto.setVotosNao(votoDto);

        ResponseVoto responseVoto = new ResponseVoto();
        responseVoto.setSessaoVotacao(sessaoDto);



        return responseVoto;
    }
    public ResponseVoto listagemVoto(Long idSessaoVotacao){

        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);

        PautaDTO pautaDto = new PautaDTO();
        pautaDto.setId(sessao.get().getPauta().getId());
        pautaDto.setTopico(sessao.get().getPauta().getTopico());
        pautaDto.setMensagem(sessao.get().getPauta().getMensagem());

        SessaoVotacaoDTO sessaoDto = new SessaoVotacaoDTO();
        sessaoDto.setId(sessao.get().getId());
        sessaoDto.setFimVotacao(sessao.get().getFimVotacao());
        sessaoDto.setInicioVotacao(sessao.get().getInicioVotacao());
        sessaoDto.setPauta(pautaDto);

        ResponseVoto responseVoto = new ResponseVoto();
        responseVoto.setSessaoVotacao(sessaoDto);

        List<Voto> votos = repositoryVoto.findBySessaoVotacao(sessao.get());
        List<ResponseVoto> responseVotos = new ArrayList<>();
        List<VotoDto> votosNao = new ArrayList<>();
        List<VotoDto> votosSim = new ArrayList<>();

        for (Voto voto : votos){

            VotoDto votoDto = new VotoDto();
            votoDto.setMensagemVoto(voto.getMensagemVoto());
            votoDto.setCpfAssociado(voto.getAssociado().getCpf());

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
    }

    public ResponseVoto buscarDadosAssociado(String cpfAssociado, Long idSessaoVotacao){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);
        Optional<SessaoVotacao> sessao = repositorySessao.findById(idSessaoVotacao);

        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setId(sessao.get().getPauta().getId());
        pautaDTO.setMensagem(sessao.get().getPauta().getMensagem());
        pautaDTO.setTopico(sessao.get().getPauta().getTopico());

        AssociadoDTO associadoDTO = new AssociadoDTO();
        associadoDTO.setCpf(associado.getCpf());

        SessaoVotacaoDTO sessaoDTO = new SessaoVotacaoDTO();
        sessaoDTO.setId(sessao.get().getId());
        sessaoDTO.setPauta(pautaDTO);

        ResponseVoto responseVoto = new ResponseVoto();
        responseVoto.setSessaoVotacao(sessaoDTO);

        List<Voto> votos = repositoryVoto.findBySessaoVotacaoAndAssociado(sessao.get(),associado);
        List<ResponseVoto> responseVotos = new ArrayList<>();
        List<VotoDto> votosNao = new ArrayList<>();
        List<VotoDto> votosSim = new ArrayList<>();

        for (Voto voto : votos){

            VotoDto votoDto = new VotoDto();
            votoDto.setMensagemVoto(voto.getMensagemVoto());
            votoDto.setCpfAssociado(cpfAssociado);

            if (MensagemVoto.SIM.equals(voto.getMensagemVoto())){

                sessaoDTO.setVotosSim(votosSim);
                sessaoDTO.getVotosSim().add(votoDto);
            }else {

                sessaoDTO.setVotosNao(votosNao);
                sessaoDTO.getVotosNao().add(votoDto);
            }
            responseVotos.add(responseVoto);
        }
        return responseVoto;
    }
}
