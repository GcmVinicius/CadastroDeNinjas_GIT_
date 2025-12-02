package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota";
    }

    //Adiciona um novo ninja(CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado com sucesso";
    }



    //Mostrar todos os ninjas(READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return"...";
    }

    //Encontrar ninja por ID(READ)
    @GetMapping("/todosID ")
    public String mostrarTodosOsNinjasPorID(){
        return"...";
    }

    //altera dados do ninjas(UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjasPorID(){
        return "Alterar ninja por ID";
    }

    //Deletar um ninja(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado por Id";
    }
}
