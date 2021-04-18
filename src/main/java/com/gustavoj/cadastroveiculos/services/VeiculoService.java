package com.gustavoj.cadastroveiculos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gustavoj.cadastroveiculos.domain.Veiculo;
import com.gustavoj.cadastroveiculos.dto.VeiculoDTO;
import com.gustavoj.cadastroveiculos.repositories.VeiculoReposity;
import com.gustavoj.cadastroveiculos.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoReposity repo;
	
	public Veiculo find(Integer id) {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
	}

	public List<Veiculo> findAll() {
		List<Veiculo> obj = repo.findAll();
		if(obj.isEmpty()) {
			throw new  ObjectNotFoundException("Objeto não encontrado!");
		}
		return obj;
	}

	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Veiculo update(Veiculo obj) {
		Veiculo veiculoNew =   find(obj.getId());
		updateData(veiculoNew, obj);
		return repo.save(obj);
	}

	private void updateData(Veiculo newobj, Veiculo obj) {
		newobj.setAno(obj.getAno());
		newobj.setDescricao(obj.getDescricao());
		newobj.setMarca(obj.getMarca());
		newobj.setVendido(obj.getVendido());
		newobj.setVeiculo(obj.getVeiculo());
		
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		
	}
	
	public Veiculo fromDto(VeiculoDTO objDto) {
		return new Veiculo(objDto.getId(), objDto.getVeiculo(), objDto.getMarca(), 
				objDto.getAno(), objDto.getDescricao(), objDto.getVendido());
	}

}
