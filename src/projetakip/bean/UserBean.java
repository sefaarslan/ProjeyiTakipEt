package projetakip.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projetakip.dao.DAO;
import projetakip.model.Person;
import projetakip.model.User;

@ManagedBean
@SessionScoped
public class UserBean {

	List<User> userList;
	User userAdd;
	Person personAdd;
	
	@PostConstruct
	public void init(){
		this.userAdd = new User();
		this.personAdd = new Person();
		this.userList =  DAO.getInstance().getUserList();
	}
	
	public String addUserFonk(){
		Person person = DAO.getInstance().addPerson(this.personAdd);
		this.userAdd.setPerson(person);
		DAO.getInstance().addUser(this.userAdd);
		this.userList =  DAO.getInstance().getUserList();
		this.userAdd = new User();
		this.personAdd = new Person();
		return "kullanci.xhtml";
	}
	
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	
	public void setUserAdd(User userAdd) {
		this.userAdd = userAdd;
	}
	
	public User getUserAdd() {
		return userAdd;
	}
	
	public void setPersonAdd(Person personAdd) {
		this.personAdd = personAdd;
	}
	
	public Person getPersonAdd() {
		return personAdd;
	}
	
	
}
