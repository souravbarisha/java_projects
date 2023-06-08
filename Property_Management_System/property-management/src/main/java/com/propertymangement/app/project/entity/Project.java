package com.propertymangement.app.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="project_id")
	private Integer projectId;
	
	@Column(name ="project_name")
	private String projectName;

	@Column(name="location")
	private String location;
	
	@Column(name="status")
	private String status;
	
	@Column(name="project_start_date")
	private LocalDateTime projectStartDate;
	
	@Column(name="project_end_date")
	private LocalDateTime projectEndDate;
	
	@Column(name="size_start_sqft")
	private Integer sizeStartSqft;
	
	@Column(name="size_upto_sqft")
	private Integer sizeUptoSqft;
	
	@Column(name="no_of_towers")
	private Integer noOfTowers;
	
	@Column(name="BHK_configuration")
	private String bhkConfiguration;
	
	@Column(name="price_starting_from")
	private String pricingStratingFrom;
	
	@Column(name="	cover_image_url")
	private String 	coverImageUrl;
	
	@Column(name="project_overview")
	private String projectOverview;
	
	@Column(name="project_area")
	private Float projectArea;
	
	@Column(name="swimming_pool")
	private Integer swimmingPool;
	
	@Column(name ="community_hall")
	private Integer communityHall;
	
	@Column(name="indoor_games_room")
	private Integer indoorGamesRoom;
	
	@Column(name="creach_toddler_zone")
	private Integer creachToddlerZone;
	
	@Column(name="jogging_track")
	private Integer joggingTrack;
	
	@Column(name="yoga_deck")
	private Integer yogaDeck;
	
	@Column(name="playground")
	private Integer playground;
	
	@Column(name="party_lawn")
	private Integer partyLawn;
	
}
