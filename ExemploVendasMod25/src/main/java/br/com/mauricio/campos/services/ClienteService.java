/**
 * 
 */
package br.com.mauricio.campos.services;

import br.com.mauricio.campos.dao.IClienteDAO;
import br.com.mauricio.campos.domain.Cliente;
import br.com.rpires.reflections.anotacao.cadastro.exception.TipoChaveNaoEncontradaException;

/**
 * 
 */
public class ClienteService implements IClienteService {
	

	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		return clienteDAO.cadastrar(cliente);

	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		return clienteDAO.consultar(cpf);
	}
	
	@Override
	public void excluir(Long cpf) {
		clienteDAO.excluir(cpf);
		
	}

	@Override
	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
		clienteDAO.alterar(cliente);
		
	}

}
