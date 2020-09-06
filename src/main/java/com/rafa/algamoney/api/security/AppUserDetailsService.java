package com.rafa.algamoney.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rafa.algamoney.api.model.Usuario;
import com.rafa.algamoney.api.repository.UsuarioRepository;

//Esta classe que diz como o usuário será carregado, logado.
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarios;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioOptional = usuarios.findByEmail(email);
		//Pega os valores do obj. Se n existir, lança exceção 
		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos.") );
//		return new User(email, usuario.getSenha(), getPermissoes(usuario) );
		return new UsuarioSistema(usuario, getPermissoes(usuario) );
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();	
		usuario.getListaPermissoes().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
		
		return authorities;
		
	}

}
