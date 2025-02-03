package com.example.demo.model.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.repository.entity.Cliente;
import com.example.demo.repository.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO implements UserDetails {

    private Long id;
    private String contrasenya;
    private String email;

    public static UsuarioDTO convertToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .contrasenya(usuario.getContrasenya())
                .email(usuario.getEmail())
                .build();
    }

    public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return Cliente.builder()
                .id(usuarioDTO.getId())
                .contrasenya(usuarioDTO.getContrasenya())
                .email(usuarioDTO.getEmail())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.contrasenya;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
