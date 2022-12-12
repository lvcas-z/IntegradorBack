package com.ZL.Integrador.service;

import com.ZL.Integrador.entity.Usuario;
import com.ZL.Integrador.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPass(), new ArrayList<>(usuario.getAuthorities()));
    }

    public Usuario guardar(Usuario usuario) {
        Usuario usuarios = new Usuario(usuario.getNombre(),usuario.getEmail(), passwordEncoder.encode(usuario.getPass()),usuario.getRol());
        return usuarioRepository.save(usuarios);
    }

}
