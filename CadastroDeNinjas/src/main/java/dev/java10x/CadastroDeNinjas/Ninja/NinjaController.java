package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Encontrar ninja por ID(READ)
    @GetMapping("/listar/{id} ")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
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
