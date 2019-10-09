package projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.dao.ClienteManager;
import projeto.model.Cliente;

@Named
@SessionScoped
public class ClienteController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteManager clienteManager;
	
	@Produces
	@Named
	private Cliente newCliente;
	
	@PostConstruct
	public void initNewCliente()
	{
		newCliente = new Cliente();
	}
	
	public List<Cliente> getClientes() throws Exception
	{
		try
		{
			return clienteManager.listAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void remove(int id) throws Exception
	{
		try
		{
			clienteManager.remove(id);
			initNewCliente();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void edit(Cliente obj) throws Exception
	{
		try
		{
			clienteManager.edit(obj);
			initNewCliente();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Cliente getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Cliente newCliente) {
		this.newCliente = newCliente;
	}
	
}
