package projetakip.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projetakip.dao.DAO;
import projetakip.model.Durum;
import projetakip.model.Proje;

@ManagedBean
@SessionScoped
public class ProjeBean {

	private Proje projeAdd;
	private Durum selectedDurum;
	String selectedDurumString;
	private List<Durum> durumList;
	private List<Proje> projeList;
	private boolean excelControl = false;
	private List<Proje> filteredProjeList;
	
	@PostConstruct
	public void init(){
		this.projeAdd = new Proje();
		this.projeList = DAO.getInstance().getProjeList();
		this.durumList = DAO.getInstance().getDurumList();
	}
	
	public String addProjeFonk(){
		projeAdd.setDurum(selectedDurum);
		DAO.getInstance().addProje(projeAdd);
		this.projeList = DAO.getInstance().getProjeList();
		this.projeAdd = new Proje();
		this.selectedDurum = new Durum();
		return "guvenli/listele.xhtml";
	}
	
	public void degistirciFnk(){
		this.excelControl = (!this.excelControl);
	}
	
	public void setProjeAdd(Proje projeAdd) {
		this.projeAdd = projeAdd;
	}
	
	public Proje getProjeAdd() {
		return projeAdd;
	}
	
	public void setDurumList(List<Durum> durumList) {
		this.durumList = durumList;
	}
	
	public List<Durum> getDurumList() {
		return durumList;
	}
	
	public void setSelectedDurum(Durum selectedDurum) {
		this.selectedDurum = selectedDurum;
	}
	
	public Durum getSelectedDurum() {
		return selectedDurum;
	}
	
	public void setSelectedDurumString(String selectedDurumString) {
		this.selectedDurumString = selectedDurumString;
	}
	
	public String getSelectedDurumString() {
		return selectedDurumString;
	}
	
	public void setProjeList(List<Proje> projeList) {
		this.projeList = projeList;
	}
	
	public List<Proje> getProjeList() {
		return projeList;
	}
	
	public void setExcelControl(boolean excelControl) {
		this.excelControl = excelControl;
	}
	
	public boolean isExcelControl() {
		return excelControl;
	}
	
	public void setFilteredProjeList(List<Proje> filteredProjeList) {
		this.filteredProjeList = filteredProjeList;
	}
	
	public List<Proje> getFilteredProjeList() {
		return filteredProjeList;
	}
	
}
