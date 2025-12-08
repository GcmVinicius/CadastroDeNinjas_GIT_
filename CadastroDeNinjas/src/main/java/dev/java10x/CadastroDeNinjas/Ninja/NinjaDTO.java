package dev.java10x.CadastroDeNinjas.Ninja;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    //o id logo abaixo será detalhado como id da entidade e o generated gera uma estratégia para o id

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private MissoesModel missoes;

    private String rank;
}
