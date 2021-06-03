package com.sistelme.sistelme_info.usuarios.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistelme.sistelme_info.usuarios.model.entity.InstalacionServicio;
import com.sistelme.sistelme_info.usuarios.model.entity.ServicioInstalado;

public interface ServicioInstaladoRepository extends JpaRepository<ServicioInstalado, String> {
	@Query("Select SI from ServicioInstalado SI where SI.instalacionServicio =:instalacionServicio")
	public List<ServicioInstalado> findByInstalacionServicio(InstalacionServicio instalacionServicio);
	
	public ServicioInstalado findByIdServicioInstalado(String idServicioInstalado);
	
	public ServicioInstalado findByIp(String ip);

}


