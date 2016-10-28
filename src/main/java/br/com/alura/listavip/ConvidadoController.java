package br.com.alura.listavip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.dao.ConvidadoDAO;
import br.com.alura.listavip.model.Convidado;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoDAO ConvidadoDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listarConvidados(Model model) {
		List<Convidado> convidados = ConvidadoDAO.findAll();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("nome") String telefone, Model model) {
		
		Convidado convidado = new Convidado(nome, email, telefone);
		ConvidadoDAO.save(convidado);
		List<Convidado> convidados = ConvidadoDAO.findAll();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}
}
