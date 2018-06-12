package projetakip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Durum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String durum;
	
	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	public String getDurum() {
		return durum;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

}
