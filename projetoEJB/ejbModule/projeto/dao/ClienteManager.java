package projeto.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import projeto.model.Cliente;
import projeto.model.Profissao;

import java.util.List;

@Stateless
public class ClienteManager {

	@Inject
	private EntityManager em;
	
	public void edit(Cliente obj) throws Exception
	{	
		//Adicioandno o objeto profissão para o contexto do Entity Manager
		obj.setProfissao(em.find(Profissao.class, obj.getProfissao().getId()));
		
		if(obj.getId() != 0)
			em.merge(obj);
		else
			em.persist(obj);
	}
	
	public void remove(int id) throws Exception
	{
		em.remove(em.find(Cliente.class, id));
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listAll() throws Exception
	{
		return em.createQuery("SELECT c FROM cliente c").getResultList();
	}
	
}
