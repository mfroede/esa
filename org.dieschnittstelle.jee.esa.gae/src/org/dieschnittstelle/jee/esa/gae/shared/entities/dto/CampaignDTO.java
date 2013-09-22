package org.dieschnittstelle.jee.esa.gae.shared.entities.dto;

import java.util.List;

public class CampaignDTO {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductBundleDTO> getBundles() {
		return bundles;
	}

	public void setBundles(List<ProductBundleDTO> bundles) {
		this.bundles = bundles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	private Long id;
	private List<ProductBundleDTO> bundles;
	private String name;
	private int price;
	private String imageURL;

}
