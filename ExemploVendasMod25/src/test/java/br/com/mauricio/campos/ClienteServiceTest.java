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
import br.com.mauricio.campos.services.ClienteService;
import br.com.mauricio.campos.services.IClienteService;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12345678910L);
		cliente.setNome("Maurício Campos");
		cliente.setCidade("Santa Branca");
		cliente.setEstado("SP");
		cliente.setEnd("Rua Antônio Pires");
		cliente.setNumero(10);
		cliente.setTel(12981827278L);
		
		
	}
	
	@Test
	public void pesquisarCliente() {
		
		
		Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		
		Boolean retorno = clienteService.salvar(cliente);
		
		Assert.assertTrue(retorno);
		
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Maurício Campos");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Maurício Campos", cliente.getNome());
	}

}
