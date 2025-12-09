package dev.java10x.CadastroDeNinjas.Missoes;


import dev.java10x.CadastroDeNinjas.Ninja.NinjaMapper;
import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;


    public MissaoService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar Todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }


    //Listar por ID
    public MissoesDTO listarMissaoPorId(long id){
        Optional<MissoesModel> missaoPorID = missoesRepository.findById(id);
        return missaoPorID.map(missoesMapper::map).orElse(null);
    }

    //Criar missoes
    public  MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missao = missoesMapper.map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //remover missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Alterar missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO novosDadosDTO){
        Optional<MissoesModel> missaoExistenteOpt = missoesRepository.findById(id);

        if (missaoExistenteOpt.isPresent()){
            MissoesModel missaoParaAtualizar = missaoExistenteOpt.get();
            MissoesModel missaoComNovosDados = missoesMapper.map(novosDadosDTO);

            missaoParaAtualizar.setNome(missaoComNovosDados.getNome());
            missaoParaAtualizar.setDificuldade(missaoComNovosDados.getDificuldade());
            missaoParaAtualizar.setNinjas(missaoComNovosDados.getNinjas());

            MissoesModel missaoSalva = missoesRepository.save(missaoParaAtualizar);
            return missoesMapper.map(missaoSalva);
        }

        return null;
    }
}


