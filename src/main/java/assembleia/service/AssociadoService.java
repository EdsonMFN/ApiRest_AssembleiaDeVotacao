package assembleia.service;


import assembleia.exception.handling.HandlerEntityNotFound;
import assembleia.exception.handling.HandlerError;
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

        try {
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
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ResponseAssociado buscarAssociado(String cpfAssociado){

        try {
            Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

            return new ResponseAssociado(AssociadoDTO
                    .builder()
                    .idAssociado(associado.getId())
                    .cpf(associado.getCpf())
                    .nome(associado.getNome())
                    .build());

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public List<ResponseAssociado> listarAssociado(){
        try {
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

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public ResponseAssociado alterarAssociado (String cpfAssociado, RequestAssociado requestAssociado){

        try {
            Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

            associado.setNome(requestAssociado.getNome());
            associado.setCpf(requestAssociado.getCpf());
            repositoryAssociado.save(associado);

            return new ResponseAssociado(AssociadoDTO
                    .builder()
                    .idAssociado(associado.getId())
                    .cpf(associado.getCpf())
                    .nome(associado.getNome())
                    .build());

        }catch (HandlerEntityNotFound ex){
            throw new HandlerEntityNotFound(ex.getMessage());
        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
    public String deletarAssociado(String cpfAssociado){

        try {
            Associado associado = repositoryAssociado.findByCpf(cpfAssociado);

            repositoryAssociado.delete(associado);

            return new ResponseAssociado(null).msgDelet();

        }catch (Exception ex){
            throw new HandlerError(ex.getMessage());
        }
    }
}
