package com.gustavoj.cadastroveiculos;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavoj.cadastroveiculos.domain.Veiculo;
import com.gustavoj.cadastroveiculos.repositories.VeiculoReposity;

@SpringBootApplication
public class CadastroveiculosApplication implements CommandLineRunner {

	@Autowired
	private VeiculoReposity veiculoReposity;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroveiculosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Veiculo veiculo = new Veiculo(null ,"Fiesta", "Ford", 2009, "Carro de alta qualidade", false);
		Veiculo veiculo2 = new Veiculo(null ,"New Fiesta", "Ford", 2021, "Carro de alta qualidade", false);

		veiculoReposity.saveAll(Arrays.asList(veiculo, veiculo2));
	}

}
