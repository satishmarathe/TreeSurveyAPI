CREATE TABLE IF NOT EXISTS survey_data (
    tree_id   VARCHAR(15)      NOT NULL,
    experiment VARCHAR(128) NOT NULL,
    site VARCHAR(32) NOT NULL,
    surveyor VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL,
    tree_plantation_date TIMESTAMP DEFAULT NOW(),
    inspection_date TIMESTAMP DEFAULT NOW(),
    species VARCHAR(50) NOT NULL,
    treatment VARCHAR(50) NOT NULL,
    tree_score INTEGER NOT NULL,
    pathogen_found INTEGER NOT NULL,
    wood_borer_found INTEGER NOT NULL,
    notes VARCHAR(1024),
    PRIMARY KEY (tree_id)
);


