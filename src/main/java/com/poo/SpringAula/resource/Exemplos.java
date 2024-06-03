package com.poo.SpringAula.resource;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poo.SpringAula.model.Cidade;

@RestController
@RequestMapping("/exemplos")
public class Exemplos {
	
	@PostMapping
	public String cadastraCidade(@RequestBody Cidade cidade) {
		//métodos de cadastro
		return cidade.toString();
	}
	
	@GetMapping
	public String retornaOlaMundo() {
		return "Olá mundo";
	}
	
	@GetMapping("/{nome}")
	public String mensagemComNome(@PathVariable String nome) {
		return "Olá mundo " + nome;
	}
	
	@GetMapping("/soma")
	public double soma(@RequestParam double n1, @RequestParam double n2) {
		return n1 + n2;
	}
	
	@GetMapping("/aposta")
	public String jogaDados(@RequestParam int qtd, @RequestParam int aposta) {
		if(qtd <1 || qtd > 4) {
			return "Quantidade de dados incorreta";
		}else {
			int apostaMin = qtd;
			int apostaMax = qtd * 6;
			if(aposta < apostaMin || aposta > apostaMax) {
				return "valor da aposta incorreta";
			}else {
				String ret = "Resultados da aposta</br>";
				int soma = 0;
				for(int i=0; i< qtd; i++) {
					int vl = sortearNumero();
					soma += vl;
					ret += "Dado "+ (i+1)+": "+ vl + "</br>";
				}
				ret += "</br>Soma: "+ soma;
				ret += "</br>Diferença percentual: "
				+ calcularDiferencaPercentual(aposta, soma);
				return ret;
			}
		}
	}
	
	private int sortearNumero() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
	
	public double calcularDiferencaPercentual(double valorInicial, 
			double valorFinal) {
        double diferenca = valorFinal - valorInicial;
        return (diferenca / valorInicial) * 100;
    }
	
	
}
