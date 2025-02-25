package com.example.demo.model.dto;

import java.util.Base64;
import java.util.Objects;

import com.example.demo.repository.entity.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ProductoDTO {
	private Long id;
	private String nombre;
	private String imagen;
	@JsonIgnore
	private CategoriaPDTO categoriaP;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoDTO other = (ProductoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static ProductoDTO convertToDTO(Producto producto) {
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setId(producto.getId());
		productoDTO.setNombre(producto.getNombre());
		if (producto.getImagen() != null) {
			productoDTO.setImagen(Base64.getEncoder().encodeToString(producto.getImagen()));
		}
		productoDTO.setCategoriaP(CategoriaPDTO.convertToDTO(producto.getCategoriaP()));
		return productoDTO;

	}

	public static Producto convertToEntity(ProductoDTO productoDTO) {

		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setNombre(productoDTO.getNombre());
		// producto.setImagen(productoDTO.getImagen());

		if (productoDTO.getCategoriaP() != null) {
			producto.setCategoriaP(CategoriaPDTO.convertToEntity(productoDTO.getCategoriaP()));

		}
		return producto;

	}

}
