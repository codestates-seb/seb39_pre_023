
drop all objects;

CREATE TABLE `member` (
  `member_id` int PRIMARY KEY AUTO_INCREMENT,
  `password` varchar(255),
  `nickname` varchar(255),
  `email` varchar(255),
  `profile_id` varchar(255),
  --`post_id` int,
  `comment_id` int,
  --`member_post_id` int,
  `answer_id` int
);

CREATE TABLE `post` (
  `post_id` int PRIMARY KEY AUTO_INCREMENT,
  `post_content` varchar(255),
  --`member_id` int,
  `post_name` varchar(255),
  `write_date` TIMESTAMP,
  `modified_date` datetime,
  `view_count` int,
  --`comment_id` int,
  --`answer_id` int,
  `is_answered` boolean,
  --`member_post_id` int,
  `score` int
  --`post_vote_id` int,
  --`tag_id` int
);

CREATE TABLE `member_post`(
`member_post_id` int PRIMARY KEY AUTO_INCREMENT,
`member_id` int,
`post_id` int

);

CREATE TABLE `comment` (
  `comment_id` int PRIMARY KEY AUTO_INCREMENT,
  `comment_content` varchar(255),
  `comment_date` TIMESTAMP,
  `comment_modified_date` boolean,
  `member_id` int,
  `post_id` int,
  `answer_id` int
);

CREATE TABLE `answer` (
  `answer_id` int PRIMARY KEY AUTO_INCREMENT,
  `answer_content` varchar(255),
  `member_id` int,
  `write_date` datetime,
  `modified_date` datetime,
  `is_accepted` boolean,
  `score` int,
  `answer_vote_id` int,
  `post_id` int
);

CREATE TABLE `postVote` (
  `post_vote_id` int PRIMARY KEY AUTO_INCREMENT,
  `member_id` int,
  `post_id` int,
  `post_vote_up` boolean,
  `post_vote_down` boolean
);

CREATE TABLE `answerVote` (
  `answer_vote_id` int PRIMARY KEY AUTO_INCREMENT,
  `answer_id` int,
  `member_id` int,
  `answer_vote_up` boolean,
  `answer_vote_down` boolean
);

CREATE TABLE `tag` (
  `tag_id` int PRIMARY KEY AUTO_INCREMENT,
  `tag_name` varchar(255),
  `tag_description` varchar(255),
  `stub_questions` int
);

CREATE TABLE `profile` (
  `profile_id` int PRIMARY KEY AUTO_INCREMENT,
  `member_id` int,
  `stub_reputation` int,
  `stub_reached` int,
  `profile_image_link` varchar(255),
  `about` varchar(255),
  `sign_in_date` datetime,
  `last_visit` datetime
);

--ALTER TABLE `post` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `profile` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`);


ALTER TABLE `postVote` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `answerVote` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

ALTER TABLE `postVote` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `answerVote` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`answer_vote_id`) REFERENCES `answerVote` (`answer_vote_id`);

--ALTER TABLE `member` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

--ALTER TABLE `post` ADD FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`);

--ALTER TABLE `post` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

--ALTER TABLE `post` ADD FOREIGN KEY (`post_vote_id`) REFERENCES `postVote` (`post_vote_id`);

--ALTER TABLE `post` ADD FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);

--ALTER TABLE `post` ADD FOREIGN KEY (`member_post_id`) REFERENCES `member_post` (`member_post_id`);
--ALTER TABLE `member` ADD FOREIGN KEY (`member_post_id`) REFERENCES `member_post` (`member_post_id`);

ALTER TABLE `member_post` ADD FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);
ALTER TABLE `member_post` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);
