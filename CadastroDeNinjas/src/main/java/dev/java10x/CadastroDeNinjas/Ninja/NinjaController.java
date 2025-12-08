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
    @PostMapping("/adicionar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }



    //Mostrar todos os ninjas(READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Encontrar ninja por ID(READ)
    @GetMapping("/listar/{id} ")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){ //Path pega por id
        return ninjaService.listarNinjasPorId(id);
    }

    //altera dados do ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado ){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar um ninja(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}