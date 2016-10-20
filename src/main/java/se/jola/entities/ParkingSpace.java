package se.jola.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parkingSpace")
public class ParkingSpace {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String label;

    protected ParkingSpace() {
    }

    public ParkingSpace(String lablel) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

    public Long getId() {
	return id;
    }
    
    public ParkingSpace setLabel(String label) {
	this.label = label;
	
	return this;
    }

}
