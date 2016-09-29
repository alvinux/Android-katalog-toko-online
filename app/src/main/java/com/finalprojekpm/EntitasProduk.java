package com.finalprojekpm;

public class EntitasProduk {
	int idproduk;
	String namaproduk = "";
	String hargaproduk = "";
	String deskripsiproduk = "";
	String stokproduk = "";
	String pictproduk = "";

	public void setIDproduk(int id) {
		this.idproduk = id;
	}

	public int getIDproduk() {
		return idproduk;
	}

	public void setNamaProduk(String n) {
		this.namaproduk = n;
	}

	public String getNamaProduk() {
		return namaproduk;
	}
	
	public void setStokProduk(String s) {
		this.stokproduk = s;
	}

	public String getStokProduk() {
		return stokproduk;
	}
	

	public void setHargaProduk(String h) {
		this.hargaproduk = h;
	}

	public String getHargaProduk() {
		return hargaproduk;
	}

	public void setDeskripsiProduk(String d) {
		this.deskripsiproduk = d;
	}

	public String getDeskripsiProduk() {
		return deskripsiproduk;
	}

	public void setPictProduk(String p) {
		this.pictproduk = p;
	}

	public String getPictProduk() {
		return pictproduk;
	}

}
