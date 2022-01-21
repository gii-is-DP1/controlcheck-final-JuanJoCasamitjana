package org.springframework.samples.petclinic.care;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CareProvision extends BaseEntity{   
    @Range(min=0)
	double duration;
    @ManyToOne(optional=true)
    Visit visit;
    @NotNull
    @OneToOne
    Care care;   
}
