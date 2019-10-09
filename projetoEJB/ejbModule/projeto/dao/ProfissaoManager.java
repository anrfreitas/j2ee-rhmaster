package projeto.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import projeto.controller.SystemController;
import projeto.model.Profissao;

import java.util.List;

@Stateless
public class ProfissaoManager {

	@Inject
	private EntityManager em;
	
	public void edit(Profissao obj) throws Exception
	{
		if(obj.getId() != 0)
			em.merge(obj);
		else
			em.persist(obj);
	}
	
	@SuppressWarnings("unchecked")
	public void remove(int id) throws Exception
	{
		//Verifica se a profissão que deseja remover está sendo usada na tabela cliente...
		List<Profissao> existe = em.createQuery("SELECT c.profissao FROM cliente c WHERE c.profissao.id = " + id).getResultList();
		
		if(existe.isEmpty()) {
			Profissao obj = new Profissao();
			obj.setId(id);
			em.remove(em.merge(obj));			
		}
		else
		{
			SystemController.setTmpMessage("ALERTA: Profissão já está sendo usada no sistema, não poderá ser deletada!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Profissao> listAll() throws Exception
	{
		return em.createQuery("SELECT p FROM profissao p").getResultList();
	}
	
}
