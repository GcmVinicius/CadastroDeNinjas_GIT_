package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")// Antes do barra estarão direcionado a missoes
public class MissoesController {

//Post- mandar uma requisição para criar missoes

    MissaoService missaoService;

    public MissoesController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missao){
        return missaoService.criarMissao(missao);
    }


//GET- mandar uma requisição para mostrar missoes
    @GetMapping("/listarTodos")
    public List<MissoesModel> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping("/listarId/{id} ")
    public MissoesModel mostrarTodosOsNinjasPorID(@PathVariable Long id){
        return missaoService.listarMissaoPorId(id);
    }

//Put- mandar uma requisição para alterar missoes
    @PutMapping("/alterar/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoNova ){
        return missaoService.atualizarMissao(id, missaoNova);
    }

//Delete- mandar uma requisição para deletar missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletado por Id";
    }
}


