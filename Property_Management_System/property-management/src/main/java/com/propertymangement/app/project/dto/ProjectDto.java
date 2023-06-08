package com.propertymangement.app.project.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {
	
	private String projectName;

	private String location;

	private String status;
	
	private LocalDateTime projectStartDate;
	
	private LocalDateTime projectEndDate;
	
	private Integer sizeStartSqft;
	
	private Integer sizeUptoSqft;
	
	private Integer noOfTowers;
	
	private String bhkConfiguration;
	
	private String pricingStratingFrom;
	
	private String 	coverImageUrl;
	
	private String projectOverview;

	private Float projectArea;
	
	private Integer swimmingPool;
	
	private Integer communityHall;
	
	private Integer indoorGamesRoom;
	
	private Integer creachToddlerZone;
	
	private Integer joggingTrack;
	
	private Integer yogaDeck;
	
	private Integer playground;
	
	private Integer partyLawn;

}
