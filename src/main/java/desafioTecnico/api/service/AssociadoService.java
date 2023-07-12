package desafioTecnico.api.service;


import desafioTecnico.api.controller.response.ResponseAssociado;
import desafioTecnico.api.controller.resquest.RequestAssociado;
import desafioTecnico.api.entity.associado.Associado;
import desafioTecnico.api.entity.associado.AssociadoDTO;
import desafioTecnico.api.repository.RepositoryAssociado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AssociadoService {

    @Autowired
    private RepositoryAssociado repositoryAssociado;

    public ResponseAssociado criarAssociado(RequestAssociado requestAssociado){

        Associado associado = new Associado();
        associado.getId();
        associado.setCpf(requestAssociado.getCpf());
        associado.setNome(requestAssociado.getNome());
        repositoryAssociado.save(associado);

        AssociadoDTO associadoDTO = new AssociadoDTO();
        associadoDTO.setIdAssociado(associado.getId());
        associadoDTO.setCpf(associado.getCpf());
        associadoDTO.setNome(associado.getNome());

        ResponseAssociado responseAssociado = new ResponseAssociado();
        responseAssociado.setAssociadoDTO(associadoDTO);

        return responseAssociado;
    }
    public ResponseAssociado buscarAssociado(String cpfAssociado){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

        AssociadoDTO associadoDTO = new AssociadoDTO();
        associadoDTO.setIdAssociado(associado.getId());
        associadoDTO.setCpf(associado.getCpf());
        associadoDTO.setNome(associado.getNome());

        ResponseAssociado responseAssociado = new ResponseAssociado();
        responseAssociado.setAssociadoDTO(associadoDTO);

        return responseAssociado;
    }
    public List<ResponseAssociado> listarAssociado(){
        List<Associado> associados = repositoryAssociado.findAll();
        List<ResponseAssociado> responseAssociados = new ArrayList<>();

        for (Associado associado : associados){

            if (associado != null ){
                AssociadoDTO associadoDTO = new AssociadoDTO();
                associadoDTO.setIdAssociado(associado.getId());
                associadoDTO.setCpf(associado.getCpf());
                associadoDTO.setNome(associado.getNome());

                ResponseAssociado responseAssociado = new ResponseAssociado();
                responseAssociado.setAssociadoDTO(associadoDTO);

                responseAssociados.add(responseAssociado);
            }else break;
        }
        return responseAssociados;
    }
    public ResponseAssociado alterarAssociado (Long idAssociado, RequestAssociado requestAssociado){

        Associado associado = new Associado();
        associado.setId(idAssociado);
        associado.setNome(requestAssociado.getNome());
        associado.setCpf(requestAssociado.getCpf());
        repositoryAssociado.save(associado);

        AssociadoDTO associadoDTO = new AssociadoDTO();
        associadoDTO.setIdAssociado(associado.getId());
        associadoDTO.setCpf(associado.getCpf());
        associadoDTO.setNome(associado.getNome());

        ResponseAssociado responseAssociado = new ResponseAssociado();
        responseAssociado.setAssociadoDTO(associadoDTO);

        return responseAssociado;
    }
    public ResponseAssociado deletarAssociado(String cpfAssociado){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);
        repositoryAssociado.delete(associado);

        ResponseAssociado responseAssociado = new ResponseAssociado();
        responseAssociado.setMensagemSucesso(responseAssociado.getMensagemSucesso());

        return responseAssociado;
    }
}
