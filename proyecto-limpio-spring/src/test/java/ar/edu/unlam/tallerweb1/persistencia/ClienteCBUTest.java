package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.CBU;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import static org.assertj.core.api.Assertions.assertThat;

public class ClienteCBUTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void usuarioCBUTest() {

		// creo CBU
		CBU cbu1 = new CBU("1231231230000000123");

		// Creo Cliente
		Cliente cliente = new Cliente();
		// asigno nombre y cbu al cliente
		cliente.setNombre("nombreCliente");
		cliente.setCbu(cbu1);

		// creo el objeto
		Session session = getSession();
		// guardo el cliente
		session.save(cliente);

		// creo un objeto cliente buscado y lo igualo al cliente que creamos recien,
		// buscandolo por id
		Cliente clienteBuscado = session.get(Cliente.class, cliente.getId());
		// veo que el cliente buscado no sea nulo
		assertThat(clienteBuscado).isNotNull();
		// veo que el CBU del cliente no sea nulo
		assertThat(clienteBuscado.getCbu().getId()).isNotNull();

	}
}
