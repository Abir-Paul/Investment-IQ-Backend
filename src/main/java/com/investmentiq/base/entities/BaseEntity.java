package com.investmentiq.base.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import com.investmentiq.base.constants.AppConstants;
import com.investmentiq.base.enums.GlobalEnums;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue
	@UuidGenerator
	@Column(updatable = false, nullable = false)
	private UUID uuid;

	@Column(updatable = false)
	private Instant createdAt;

	@Column(updatable = false)
	private String createdBy;

	@Column
	private Instant updatedAt;

	@Column
	private String updatedBy;

	@Column
	private Instant dbLock;
	
	@Column
	private GlobalEnums.YesNoFlag delFlg;

	@PrePersist
	public void prePersist() {
		
		setCreatedAt(Instant.now());
		
		if (Objects.isNull(getCreatedBy())) 
		{
			setCreatedBy(AppConstants.SystemUser);
		}
		
		setUpdatedAt(Instant.now());
		
		if(Objects.isNull(getUpdatedBy()))
		{
			setUpdatedBy(AppConstants.SystemUser);
		}
		
		setDelFlg(GlobalEnums.YesNoFlag.N);
		
		setDbLock(Instant.now());

		onPrePersist();
	}

	@PreUpdate
	public void preUpdate() {

        this.setUpdatedAt(Instant.now());
		
		if(Objects.isNull(getUpdatedBy()))
		{
			setUpdatedBy(AppConstants.SystemUser);
		}

		onPreUpdate();
	}

    //Implement in child classes to have custom prePersist logic
	public void onPrePersist()
	{

	}

	//Implement in child classes to have customPrePersist logic
	public void onPreUpdate()
	{

	}

}
