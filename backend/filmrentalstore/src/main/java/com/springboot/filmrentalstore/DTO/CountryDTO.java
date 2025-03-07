package com.springboot.filmrentalstore.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class CountryDTO {
	private Long countryId;
	private String country;
	private LocalDateTime lastUpdate;
	private List<Long> cityIds;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Long> getCityIds() {
		return cityIds;
	}

	public void setCityIds(List<Long> cityIds) {
		this.cityIds = cityIds;
	}

	public CountryDTO() {
		super();
	}

}
