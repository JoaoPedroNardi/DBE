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
		
		dao.create(getUser());
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Usuário cadastrado com sucesso"));
		
		return "users";
	}
	
	public List<User> getAll(){
		return dao.listAll();
	}
	
	public String login() {
		// verificar as credencias
		if(dao.exist(user)) return "setups";
		// se existir, encaminhar para home
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login invalido", "Erro"));
		//senao, voltar para login
	}			return "login";
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
