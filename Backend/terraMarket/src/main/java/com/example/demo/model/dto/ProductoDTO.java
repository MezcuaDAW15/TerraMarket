package com.example.demo.model.dto;

import java.util.Objects;

import com.example.demo.repository.entity.Producto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String imagen;
	private CategoriaPDTO categoriaPDTO;


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
       productoDTO.setImagen(producto.getImagen());
	   productoDTO.setCategoriaPDTO(CategoriaPDTO.convertToDTO(producto.getCategoriaP()));
       return productoDTO;

    }
	public static Producto convertToEntity(ProductoDTO productoDTO) {
		
		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setNombre(productoDTO.getNombre());
		producto.setImagen(productoDTO.getImagen());
		producto.setCategoriaP(CategoriaPDTO.convertToEntity(productoDTO.getCategoriaPDTO()));
		return producto;

	}
    
    
}
