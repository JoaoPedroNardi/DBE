package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.dao.UserDao;
import br.com.fiap.model.Setup;
import br.com.fiap.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();
	
	// CDI
	@Inject //injeção de dependência
	private UserDao dao;
	
	public String save(){
		
		dao.create(user);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Setup cadastrado com sucesso"));
		
		return "users";
	}
	
	public List<User> getAll(){
		return dao.listAll();
	}
	
	public void login() {
		// verificar as credencias
		if(dao.exist(user)) return "setups";
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login invalido", "Erro"));
		// se existir, encaminhar para home
		return "login";
		//senao, voltar para login
	}
	


}
