package com.target.casestudy.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "value")),
			@AttributeOverride(name = "currencyCode", column = @Column(name = "currency_code")), })
	@JsonProperty("currency_price")
	private Price currencyPrice;

	public Price getCurrencyPrice() {
		return currencyPrice;
	}

	public void setCurrencyPrice(Price currencyPrice) {
		this.currencyPrice = currencyPrice;
	}

}
