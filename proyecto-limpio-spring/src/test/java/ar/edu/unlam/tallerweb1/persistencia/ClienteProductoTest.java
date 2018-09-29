package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Producto;
import static org.assertj.core.api.Assertions.assertThat;

public class ClienteProductoTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void GuardarClienteProductoTest() {

		Cliente cli = new Cliente();
		Producto prod = new Producto();
		prod.setCliente(cli);

		Session session = getSession();
		
		session.save(prod);

		Producto productoBuscado = session.get(Producto.class, prod.getId());
		assertThat(productoBuscado).isNotNull();
		assertThat(productoBuscado.GetCliente().getId()).isNotNull();

	}
}
