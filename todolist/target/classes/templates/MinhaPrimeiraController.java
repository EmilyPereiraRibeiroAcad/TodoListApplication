package br.com.emy.todolist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller //extrutura onde tenha paginas, templates, para maior flexibilidade

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {

    @GetMapping
    public String primeiraMensagem() {
        return "primeira rota okay";
    }

    // Mapeamento para "/primeiraRota/path"
    @GetMapping("/path")
    public String segundaMensagem() {
        return "segunda rota com path okay!";
    }

}

    /*
     * GET - BUSCA INFO
     * POST - ADICIONAR INFO
     * PUT - ALTERAR DADO OU INFO
     * DELETE - REMOVER
     * PATCH - ALTERAÇÃO EM SOMENTE UMA PARTE DA INFORMAÇÃO
     * METODO (FUNCIONALIDADE) DE UMA CLASSE
     */
    
