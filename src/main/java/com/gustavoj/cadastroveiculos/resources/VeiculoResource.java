package com.gustavoj.cadastroveiculos.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavoj.cadastroveiculos.domain.Veiculo;
import com.gustavoj.cadastroveiculos.dto.VeiculoDTO;
import com.gustavoj.cadastroveiculos.services.VeiculoService;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<List<VeiculoDTO>> findAll(){
		List<Veiculo> list = veiculoService.findAll();
		List<VeiculoDTO> listDto = list.stream().
				map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Veiculo> find(@PathVariable Integer id){
		Veiculo obj = veiculoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VeiculoDTO objDto){
		Veiculo obj = veiculoService.fromDto(objDto);
		System.out.println(obj.toString());
		obj = veiculoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody VeiculoDTO objDto, @PathVariable Integer id){
		Veiculo obj = veiculoService.fromDto(objDto);
		obj.setId(id);
		obj = veiculoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		veiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
