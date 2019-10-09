package projeto.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import projeto.dao.ClienteManager;
import projeto.model.*;

@Path("/clientes")
@RequestScoped
public class ClienteREST {

	@Inject
	private ClienteManager manager;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Cliente> listarTodos() throws Exception {
        return manager.listAll();
    }
	
}
