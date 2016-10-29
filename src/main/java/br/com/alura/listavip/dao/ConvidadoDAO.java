package br.com.alura.listavip.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.alura.listavip.model.Convidado;



@Repository
public class ConvidadoDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Convidado> findAll() {
		return manager.createQuery("select c from Convidado c", Convidado.class).getResultList();
	}

	public void save(Convidado convidado) {
		manager.merge(convidado);		
	}

}