package projetakip.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "proje_adi", nullable = true)
	String projeAdi;
	
	@Column(name = "proje_aciklamasi")
	String projeAciklamasi;
	
	@Column(name = "problem_bulgulari")
	String problemBulgulari;
	
	@Column(name = "baslangic_tarihi")
	Date baslangicTarihi;
	
	@Column(name = "hedef_tarihi")
	Date hedefTarihi;
	
	@ManyToOne
	Durum durum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjeAdi() {
		return projeAdi;
	}

	public void setProjeAdi(String projeAdi) {
		this.projeAdi = projeAdi;
	}

	public String getProjeAciklamasi() {
		return projeAciklamasi;
	}

	public void setProjeAciklamasi(String projeAciklamasi) {
		this.projeAciklamasi = projeAciklamasi;
	}

	public String getProblemBulgulari() {
		return problemBulgulari;
	}

	public void setProblemBulgulari(String problemBulgulari) {
		this.problemBulgulari = problemBulgulari;
	}

	public Date getBaslangicTarihi() {
		return baslangicTarihi;
	}

	public void setBaslangicTarihi(Date baslangicTarihi) {
		this.baslangicTarihi = baslangicTarihi;
	}

	public Durum getDurum() {
		return durum;
	}

	public void setDurum(Durum durum) {
		this.durum = durum;
	}

	public Date getHedefTarihi() {
		return hedefTarihi;
	}

	public void setHedefTarihi(Date hedefTarihi) {
		this.hedefTarihi = hedefTarihi;
	}
	
	
	
	

}
