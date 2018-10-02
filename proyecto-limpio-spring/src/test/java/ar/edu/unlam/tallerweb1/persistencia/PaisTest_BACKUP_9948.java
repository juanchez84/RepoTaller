package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
import static org.assertj.core.api.Assertions.*;

public class PaisTest extends SpringTest {
	
	private Session session;

	@Before
	public void setUp() {
		
		session = getSession();
		
		Continente america = new Continente("America");
		Continente europa = new Continente("Europa");
		Continente africa = new Continente("Africa");
		Continente asia = new Continente("Asia");
		Continente oceania = new Continente("Oceania");
		
		session.save(america);
		session.save(europa);
		session.save(africa);
		session.save(asia);
		session.save(oceania);
		
		
		Pais argentina = new Pais("Argentina", (long) 43000000 , "Español", america);
		Pais inglaterra = new Pais("Inglaterra", (long) 53000000, "Ingles", europa);
		Pais eeuu = new Pais("Estados Unidos", (long) 325000000, "Ingles", america);
		Pais brasil = new Pais("Brasil", (long) 207000000, "Portugues", america);
		
		session.save(argentina);
		session.save(inglaterra);
		session.save(eeuu);
		session.save(brasil);
		
		Ubicacion ubicacion1 = new Ubicacion(-64.0000000, -34.0000000);
		Ubicacion ubicacion2 = new Ubicacion(51.5085300, -0.1257400);
		Ubicacion ubicacion3 = new Ubicacion(38.8951100, -77.0363700);
		Ubicacion ubicacion4 = new Ubicacion(-47.9297200, -15.7797200);
		
		session.save(ubicacion1);
		session.save(ubicacion2);
		session.save(ubicacion3);
		session.save(ubicacion4);
		
		Ciudad buenosaires = new Ciudad("Buenos Aires", argentina, ubicacion1);
		Ciudad londres = new Ciudad("Londres", inglaterra, ubicacion2);
		Ciudad washington = new Ciudad("Washington", eeuu, ubicacion3);
		Ciudad brasilia = new Ciudad("Brasilia", brasil, ubicacion4);
		
		session.save(buenosaires);
		session.save(londres);
		session.save(washington);
		session.save(brasilia);
		
		argentina.setCapital(buenosaires);
		inglaterra.setCapital(londres);
		eeuu.setCapital(washington);
		brasil.setCapital(brasilia);
		
		session.save(argentina);
		session.save(inglaterra);
		session.save(eeuu);
		session.save(brasil);
		}
	
		@Test
	    @Transactional @Rollback()
		public void obtenerPaisesDeHablaInglesa() {
	
			@SuppressWarnings("unchecked")
			List<Pais> busqueda = session.createCriteria(Pais.class)
					.add(Restrictions.eq("idioma", "Ingles"))
					.list();
			
			assertThat(busqueda.size()).isEqualTo(2);
			for(Pais pais : busqueda) {
				assertThat(pais.getIdioma()).isEqualTo("Ingles");
			}
	
		}
			
		@Test
		@Transactional @Rollback()
		public void obtenerPaisesDelContinenteEuropeo() {
			
			@SuppressWarnings("unchecked")
			List<Pais> busqueda = session.createCriteria(Pais.class)
					.createAlias("continente", "tablaContinente")
					.add(Restrictions.eq("tablaContinente.nombre", "Europa"))
					.list();
			
			assertThat(busqueda.size()).isEqualTo(1);
			for(Pais pais : busqueda) {
				assertThat(pais.getContinente().getNombre()).isEqualTo("Europa");
			}
		}
<<<<<<< HEAD
}	
=======
		
		@Test
		@Transactional @Rollback()
		public void obtenerPaisesCapitalNorteTropicoCancer (){
			@SuppressWarnings("unchecked")
			List <Pais> busqueda = session.createCriteria(Pais.class)
						.createAlias("capital", "ciu")
						.createAlias("ciu.ubicacionGeografica", "ub")
						.add(Restrictions.gt("ub.latitud", 20.00))
						.list();
			
			assertThat (busqueda.size()).isEqualTo(2);
			for (Pais pais : busqueda) {
				assertThat (pais.getCapital().getUbicacion().getLatitud()).isGreaterThan(20.00);
			}
			
			
		}
		
		@Test
		@Transactional @Rollback ()
		public void obtenerCiudadesHemisferioSur (){
			@SuppressWarnings("unchecked")
			
			List <Ciudad> busqueda = session.createCriteria(Ciudad.class)
						.createAlias("ubicacionGeografica", "ub")
						.add(Restrictions.lt("ub.latitud",00.00))
						.list();
			
			assertThat (busqueda.size()).isEqualTo(2);
			for (Ciudad ciudad : busqueda){
				assertThat (ciudad.getUbicacion().getLatitud()).isLessThan(00.00);
			}
			
			
		}

}	

>>>>>>> b53e98fc95425b04a1b211b4e1f3dd9a6a0aefc8
	


