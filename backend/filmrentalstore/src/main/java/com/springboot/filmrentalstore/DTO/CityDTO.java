package com.springboot.filmrentalstore.DTO;

public class CityDTO {
	private Long cityId;
	private String cityName;
	private CityDTO country;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public CityDTO getCountry() {
		return country;
	}

	public void setCountry(CityDTO country) {
		this.country = country;
	}

	public CityDTO() {
		super();
	}

}
