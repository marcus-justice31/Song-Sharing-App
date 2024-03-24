-- Run this statement first, and then go under "Other databases" and set LMS it as "Default Catelog",
-- then you can run the create statements after the above step.
-- CREATE DATABASE LMS;

CREATE TABLE USER (
id int NOT NULL AUTO_INCREMENT,
username VARCHAR(50),
password VARCHAR(20),
PRIMARY KEY (id),
UNIQUE (username)
);

CREATE TABLE SONG (
id int NOT NULL AUTO_INCREMENT,
songName VARCHAR(20),
artist VARCHAR(50),
genre VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE PLAYLIST (
playlistName VARCHAR(50),
userID INT,
songID INT,
foreign key (userID) references USER (id),
foreign key (songID) references song (id)
);

INSERT INTO USER (username, password) VALUES ('marcus', 'pass');
INSERT INTO USER (username, password) VALUES ('austin', 'pass');
INSERT INTO SONG (songName, Artist, Genre) VALUES ('song1', 'artist1', 'genre1');
INSERT INTO SONG (songName, Artist, Genre) VALUES ('song2', 'artist2', 'genre2');
INSERT INTO SONG (songName, Artist, Genre) VALUES ('song3', 'artist3', 'genre3');
INSERT INTO SONG (songName, Artist, Genre) VALUES ('song4', 'artist4', 'genre4');

INSERT INTO PLAYLIST (playlistName, userID, songID) VALUES ('marcusPlaylist', 1, 1);
INSERT INTO PLAYLIST (playlistName, userID, songID) VALUES ('marcusPlaylist', 1, 2);
INSERT INTO PLAYLIST (playlistName, userID, songID) VALUES ('austinPlaylist', 2, 3);
