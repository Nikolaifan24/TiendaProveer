package com.mintic.tienda.repositories;


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
	
	@Query(value = "SELECT * from Usuarios p where p.nombreUsuario= :nombreUsuario and p.password=:password", nativeQuery = true)
	Usuario findByNombreUsuarioAndPassword(@Param("nombreUsuario") String nombreUsuario,
			@Param("password") String password);
	
	@Query(value = "SELECT * FROM Usuarios p where p.perfil=:perfil", nativeQuery = true)
	Usuario buscarUsuarioPorPerfil(@Param("perfil") Long perfil);

	@Query(value = "SELECT * FROM Usuarios p where p.nombreUSuario=:nombreUsuario", nativeQuery = true)
	Usuario buscarUsuarioPorNombre(@Param("nombreUsuario") Long perfil);
}
