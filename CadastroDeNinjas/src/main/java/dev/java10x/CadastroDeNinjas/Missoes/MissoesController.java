package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninja.NinjaModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")// Antes do barra estarão direcionado a missoes
public class MissoesController {

//Post- mandar uma requisição para criar missoes

    private final MissaoService missaoService;

    public MissoesController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova missão", description = "Rota cria uma nova missao e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criaçao da missa")
    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso, (ID)" + novaMissao.getId());
    }


//GET- mandar uma requisição para mostrar missoes
    @GetMapping("/listarTodos")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missao = missaoService.listarMissoes();
        return ResponseEntity.ok(missao);
    }

    @GetMapping("/listarId/{id} ")
    @Operation(summary = "Lista a missao por Id", description = "Rota lista uma missao pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrada")
    })
    public ResponseEntity<?> mostrarTodasMissoesPorID(@PathVariable Long id){
        MissoesDTO missao = missaoService.listarMissaoPorId(id);

        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id" + id + "nao encontrada");
        }
    }

//Put- mandar uma requisição para alterar missoes
@PutMapping("/alterar/{id}")
@Operation(summary = "Altera a missao por Id", description = "Rota altera uma missap pelo seu id")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Missao alterada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Missao nao encontrada, nao foi possivel alterar")
})
public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao ){
    MissoesDTO missaoAtualizada = missaoService.atualizarMissao(id, missao);
    if (missaoAtualizada != null) {
        return ResponseEntity.ok(missaoAtualizada);
    } else {
        return ResponseEntity.notFound().build();
    }
}

//Delete- mandar uma requisição para deletar missoes
    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if(missaoService.listarMissaoPorId(id) != null){
            missaoService.deletarMissao(id);
            return  ResponseEntity.ok("Missao deletada com sucesso, (ID)" + id);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o Id" + id + "nao encontrada");
        }
    }
}


