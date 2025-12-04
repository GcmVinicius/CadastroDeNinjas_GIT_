package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missaoRepository) {
        this.missoesRepository = missaoRepository;
    }

    //Listar Todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }


    //Listar por ID
    public MissoesModel listarMissaoPorId(long id){
        Optional<MissoesModel> missaoPorID = missoesRepository.findById(id);
        return missaoPorID.orElse(null);
    }

    //Criar missoes
    public  MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //remover missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Alterar missao
    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada){
        if (missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }


}


