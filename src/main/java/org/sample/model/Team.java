package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	
	private String teamName;
	private java.sql.Timestamp timestamp;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    public java.sql.Timestamp getTimestamp(){
    	return timestamp;
    }
    
    public void setTimestamp(java.sql.Timestamp timestamp){
    	this.timestamp = timestamp;
    }
    
    
}
