package br.com.alura.listavip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.listavip.dao.ConvidadoDAO;
import br.com.alura.listavip.model.Convidado;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoDAO convidadoDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Convidado convidado) {
		convidadoDAO.save(convidado);
//		EmailService emailService = new EmailService();
//		emailService .enviar(convidado.getNome(), convidado.getEmail());
	}
	
	public List<Convidado> findAll() {
		return convidadoDAO.findAll();
	}
}
