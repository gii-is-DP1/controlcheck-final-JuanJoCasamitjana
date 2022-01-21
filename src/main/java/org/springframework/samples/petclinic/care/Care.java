package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care  extends BaseEntity {
	@NotEmpty
	@Length(min = 5, max= 30)
	@Column(unique=true)
    String name;
	@NotEmpty
    String description;
	@NotEmpty
	@ManyToMany(cascade = CascadeType.ALL)
    Set<PetType> compatiblePetTypes;
}
