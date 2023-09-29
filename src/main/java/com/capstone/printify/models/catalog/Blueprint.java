package com.capstone.printify.models.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Blueprint {
	private static final Logger logger = LoggerFactory.getLogger(Blueprint.class);

	@JsonProperty("id")
	private int blueprintId;

	private String title = "";

	private String description = "";

	private String brand = "";

	private String model = "";

	private JsonNode images = null;

	private List<String> imageList = new ArrayList<>();

	public int getBlueprintId() {
		return blueprintId;
	}

	public void setBlueprintId(int blueprintId) {
		this.blueprintId = blueprintId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public JsonNode getImages() {
		return images;
	}

	public void setImages(JsonNode images) {
		this.images = images;
		this.imageList = convertImagesToList(images);

		// Log a message indicating that images have been set.
		logger.info("Images set for Blueprint with ID: {}", blueprintId);
	}

	public List<String> getImageList() {
		return imageList;
	}

	private List<String> convertImagesToList(JsonNode images) {
		List<String> imageList = new ArrayList<>();

		if (images.isObject()) {
			images.fields().forEachRemaining(entry -> imageList.add(entry.getValue().asText()));
		} else if (images.isArray()) {
			images.elements().forEachRemaining(element -> imageList.add(element.asText()));
		}

		return imageList;
	}
}
