package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")// Antes do barra estarão direcionado a missoes
public class MissoesController {

//Post- mandar uma requisição para criar missoes

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criado com sucesso";
    }


//GET- mandar uma requisição para mostrar missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return"...";
    }

    @GetMapping("/todosID ")
    public String mostrarTodosOsNinjasPorID(){
        return"...";
    }

//Put- mandar uma requisição para alterar missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Alterar missao por ID";
    }

//Delete- mandar uma requisição para deletar missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletado por Id";
    }
}


