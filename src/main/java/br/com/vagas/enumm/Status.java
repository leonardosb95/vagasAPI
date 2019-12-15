package br.com.vagas.enumm;

public enum Status {
	
	ATIVO(1),
	INATIVO(0);
	
	private int status;
	
	Status(int status){
		this.status=status;
	}
	
	
	public int getStatus() {return status;}
	

}
