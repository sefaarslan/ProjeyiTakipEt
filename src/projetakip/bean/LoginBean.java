package projetakip.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import projetakip.dao.DAO;
import projetakip.entity.UserEntity;
import projetakip.model.User;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4165989573695827461L;
	
	
	private UserEntity userEntity;
	private boolean kullaniciIcerede = false;
	private User mevcutUser;
	
	@PostConstruct
	public void init(){
		this.userEntity = new UserEntity();
	}
	
	
	public String login(){
		User user = DAO.getInstance().checkUser(this.userEntity);
		if(user == null){
			return "fail.xhtml";
		}
		else{
			this.mevcutUser = user;
			this.kullaniciIcerede = true;
			return "guvenli/anasayfa.xhtml?faces-redirect=true";
		}
	}
	
	public String loginOut(){
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		 this.kullaniciIcerede = false;
		 return "/index.xhtml?faces-redirect=true";
	}
	
	
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	
	public void setKullaniciIcerede(boolean kullaniciIcerede) {
		this.kullaniciIcerede = kullaniciIcerede;
	}
	public boolean isKullaniciIcerede() {
		return kullaniciIcerede;
	}
	
	public void setMevcutUser(User mevcutUser) {
		this.mevcutUser = mevcutUser;
	}
	
	public User getMevcutUser() {
		return mevcutUser;
	}
	
}
