package com.skillenza.parkinglotjava;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private String id;
    
	@Column(name="created_at")
	@NotNull
	private String createdAt;
    
	@Column(name="lot", unique=true)
	@NotNull
	private String lot;
    
	@Column(name="parking_amount")
	@NotNull
	private String parkingAmount;
    
	@Column(name="parking_duration")
	@NotNull
	private String parkingDuration;
    
	@Column(name="updated_at")
	@NotNull
	private String updatedAt;
    
    @Column(name="vehicle_number", unique=true)
	@NotNull
    private String vehicleNumber;
    
	public ParkingLot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingLot(@NotNull String parkingAmount, String id, @NotNull String createdAt,
			@NotNull String parkingDuration, @NotNull String vehicleNumber, @NotNull String lot,
			@NotNull String updatedAt) {
		super();
		this.parkingAmount = parkingAmount;
		this.id = id;
		this.createdAt = createdAt;
		this.parkingDuration = parkingDuration;
		this.vehicleNumber = vehicleNumber;
		this.lot = lot;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getParkingAmount() {
		return parkingAmount;
	}

	public void setParkingAmount(String parkingAmount) {
		this.parkingAmount = parkingAmount;
	}

	public String getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(String parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "ParkingLot [id=" + id + ", createdAt=" + createdAt + ", lot=" + lot + ", parkingAmount=" + parkingAmount
				+ ", parkingDuration=" + parkingDuration + ", updatedAt=" + updatedAt + ", vehicleNumber="
				+ vehicleNumber + "]";
	}
    
}
