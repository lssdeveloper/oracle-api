package com.lssdeveloper.oracleapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {
	
    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
    @SequenceGenerator(sequenceName = "cliente_seq", initialValue = 1, allocationSize = 1, name = "CLI_SEQ")
    Long id;

    String nome;
    String email;	
    
    //@Temporal(TemporalType.DATE)
    @Column(name = "DATA_CRIACAO")
    Date data;
    
    public Cliente() {
		
	}
    
    @Override
    public String toString() {
    	
    	return "Cliente{" +
    			"id=" + id +
    			", nome='" + nome + '\'' +
    			", email='" + email + '\''+
    			", data=" + data +
    			'}';
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
    
    

}
