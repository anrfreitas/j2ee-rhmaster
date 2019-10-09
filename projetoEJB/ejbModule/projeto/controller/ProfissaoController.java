package projeto.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import projeto.dao.ProfissaoManager;
import projeto.model.Profissao;
import java.io.Serializable;

@Named
@SessionScoped
public class ProfissaoController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProfissaoManager profissaoManager;
	
	@Produces
	@Named
	private Profissao newProfissao;
	
	@PostConstruct
	public void initNewProfissao()
	{
		newProfissao = new Profissao();
	}
	
	public List<Profissao> getProfissoes() throws Exception
	{
		try
		{
			return profissaoManager.listAll();
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
			profissaoManager.remove(id);
			initNewProfissao();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void edit(Profissao obj) throws Exception
	{
		try
		{
			profissaoManager.edit(obj);
			initNewProfissao();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Profissao getNewProfissao() {
		return newProfissao;
	}

	public void setNewProfissao(Profissao newProfissao) {
		this.newProfissao = newProfissao;
	}

}
