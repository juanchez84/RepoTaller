package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OperacionCadenaController {
	@RequestMapping(path="/operacion-cadena/{operacion}/cadena/{cadena}")
	public ModelAndView operacionCadena (@PathVariable String operacion, @PathVariable String cadena) {
		String resultado = "";
		String textoResultadoCompleto = "";

		if(operacion.equals("pasarAMayuscula")){
			resultado = cadena.toUpperCase();
		} if(operacion.equals("pasarAMinuscula")){
			resultado = cadena.toLowerCase();
			}
		
		textoResultadoCompleto = "El resultado de " + operacion + " sobre " + cadena + " es " + resultado;

		ModelMap modelo = new ModelMap();
		modelo.put("texto", textoResultadoCompleto);

		return new ModelAndView("operacion-cadena", modelo);	

	}

}