CREATE TABLE tree_survey.tree_master (
	tree_id varchar(20) PRIMARY KEY,
	location_id varchar(100) NOT NULL,
	plant_date Date NOT NULL,
	species varchar(100) NOT NULL,
	treatment varchar(200) NOT NULL	
);

CREATE TABLE tree_survey.survey (
	tree_id varchar(20) PRIMARY KEY,
	inspection_date Date ,
	health_score numeric(10),
	pathogen_count numeric(10),
	woodborer_count numeric(10),
	notes varchar(500)
);