/**
 * 
 */
package br.com.mauricio.campos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.mauricio.campos.dao.ClienteDaoMock;
import br.com.mauricio.campos.dao.IClienteDAO;
import br.com.mauricio.campos.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteDAOTest {
	
	
		
		private IClienteDAO clienteDao;
		
		private Cliente cliente;
		
		public ClienteDAOTest() {
			clienteDao = new ClienteDaoMock();
		}
		
		@Before
		public void init() throws TipoChaveNaoEncontradaException {
			cliente = new Cliente();
			cliente.setCpf(12345678910L);
			cliente.setNome("Maurício Campos");
			cliente.setCidade("Santa Branca");
			cliente.setEstado("SP");
			cliente.setEnd("Rua Antônio Pires");
			cliente.setNumero(10);
			cliente.setTel(12981827278L);
			clienteDao.cadastrar(cliente);
		}
		
		@Test
		public void pesquisarCliente() {
			Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
			Assert.assertNotNull(clienteConsultado);
		}
		
		@Test
		public void salvarCliente() throws TipoChaveNaoEncontradaException {
			
			Boolean retorno = clienteDao.cadastrar(cliente);
			
			Assert.assertTrue(retorno);
			
		}
		
		@Test
		public void excluirCliente() {
			clienteDao.excluir(cliente.getCpf());
		}
		
		@Test
		public void alterarCliente() throws TipoChaveNaoEncontradaException {
			cliente.setNome("Maurício Campos");
			clienteDao.alterar(cliente);
			
			Assert.assertEquals("Maurício Campos", cliente.getNome());
		}

}
