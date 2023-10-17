package assembleia.service;


import assembleia.rest.response.ResponseAssociado;
import assembleia.rest.resquest.RequestAssociado;
import assembleia.domains.entity.associado.Associado;
import assembleia.domains.model.AssociadoDTO;
import assembleia.domains.repository.RepositoryAssociado;
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
        associado.setCpf(requestAssociado.getCpf());
        associado.setNome(requestAssociado.getNome());
        repositoryAssociado.save(associado);

        return new ResponseAssociado(AssociadoDTO
                .builder()
                .idAssociado(associado.getId())
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build());
    }
    public ResponseAssociado buscarAssociado(String cpfAssociado){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

        return new ResponseAssociado(AssociadoDTO
                .builder()
                .idAssociado(associado.getId())
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build());
    }
    public List<ResponseAssociado> listarAssociado(){
        List<Associado> associados = repositoryAssociado.findAll();
        List<ResponseAssociado> responseAssociados = new ArrayList<>();

        for (Associado associado : associados){

            if (associado != null ){

                ResponseAssociado responseAssociado = new ResponseAssociado(AssociadoDTO
                        .builder()
                        .idAssociado(associado.getId())
                        .cpf(associado.getCpf())
                        .nome(associado.getNome())
                        .build());

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

        return new ResponseAssociado(AssociadoDTO
                .builder()
                .idAssociado(associado.getId())
                .cpf(associado.getCpf())
                .nome(associado.getNome())
                .build());
    }
    public void deletarAssociado(String cpfAssociado){

        Associado associado = repositoryAssociado.findByCpf(cpfAssociado);
        repositoryAssociado.delete(associado);
    }
}
