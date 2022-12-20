package com.mintic.tienda.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mintic.tienda.entities.Usuario;

/*
 * Aqui se realizan las opereciones crud    los parametros son la entidad  y el tipo de datos que se definio como @id en la entidad  
 * 
 * ejemplo entidad Usuario
 *	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	el id es long debe ir igual en el crud repository <Usuario, Long>
 * 
 * 
 * */
public interface IUsuario extends CrudRepository<Usuario, Long> {

	/*
	@Query("select count(*) from Usuarios as p where p.nombreUsuario= :nombreUsuario and p.password=:password")
	Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);
	*/
	
	@Query(value = "select count(*) from Usuario p where p.nombreUsuario= :nombreUsuario and p.password=:password", nativeQuery = true)
	Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);
	
	@Query(value = "SELECT * FROM Usuario c where c.perfil= :perfil", nativeQuery = true)
	List<Usuario> buscarUsuarioPorPerfil(@Param("perfil") String perfil);

	@Query(value = "SELECT * FROM Usuario p where p.nombreUsuario=:nombreUsuario", nativeQuery = true)
	Usuario buscarUsuarioPorNombre(@Param("nombreUsuario") String nombreUsuario);
}
