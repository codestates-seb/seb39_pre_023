
drop all objects;

CREATE TABLE `member` (
  `user_id` int PRIMARY KEY auto_increment,
  `password` varchar(255),
  `nick_name` varchar(255),
  `email` varchar(255),
  `profile_id` varchar(255),
  `post_id` int,
  `comment_id` int,
  `answer_id` int
);

CREATE TABLE `post` (
  `post_id` int PRIMARY KEY auto_increment,
  `post_content` varchar(255),
  `user_id` int,
  `post_name` varchar(255),
  `write_date` TIMESTAMP,
  `modified_date` datetime,
  `view_count` int,
  `comment_id` int,
  `answer_id` int,
  `is_answered` boolean,
  `score` int,
  `post_vote_id` int,
  `tag_id` int
);

CREATE TABLE `comment` (
  `comment_id` int PRIMARY KEY auto_increment,
  `comment_content` varchar(255),
  `comment_date` TIMESTAMP,
  `comment_modified` boolean,
  `user_id` int,
  `post_id` int,
  `answer_id` int
);

CREATE TABLE `answer` (
  `answer_id` int PRIMARY KEY auto_increment,
  `answer_content` varchar(255),
  `user_id` int,
  `write_date` datetime,
  `modified_date` datetime,
  `is_accepted` boolean,
  `score` int,
  `answer_vote_id` int,
  `post_id` int
);

CREATE TABLE `post_vote` (
  `post_vote_id` int PRIMARY KEY auto_increment,
  `user_id` int,
  `post_id` int,
  `post_vote_up` boolean,
  `post_vote_down` boolean
);

CREATE TABLE `answer_vote` (
  `answer_vote_id` int PRIMARY KEY auto_increment,
  `answer_id` int,
  `user_id` int,
  `answer_vote_up` boolean,
  `answer_vote_down` boolean
);

CREATE TABLE `tag` (
  `tag_id` int PRIMARY KEY auto_increment,
  `tag_name` varchar(255),
  `tag_description` varchar(255),
  `stub_questions` int
);

CREATE TABLE `profile` (
  `profile_id` int PRIMARY KEY auto_increment,
  `user_id` int,
  `stub_reputation` int,
  `stub_reached` int,
  `profile_image_link` varchar(255),
  `About` varchar(255),
  `sign_in_date` datetime,
  `last_visit` datetime
);

CREATE TABLE `tag_profile` (
  `tag_profile_id` int PRIMARY KEY auto_increment,
  `user_id` int,
  `tag_id` int,
  `tag_score` int,
  `posts` int,
  `posts_percent` int
);

CREATE TABLE `log` (
  `log_id` int PRIMARY KEY auto_increment,
  `log_content` varchar(255),
  `log_date` datetime
);

ALTER TABLE `post` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `profile` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`);

ALTER TABLE `tag_profile` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `tag_profile` ADD FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);

ALTER TABLE `post_vote` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `answer_vote` ADD FOREIGN KEY (`user_id`) REFERENCES `member` (`user_id`);

ALTER TABLE `post_vote` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `answer_vote` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `comment` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `answer` ADD FOREIGN KEY (`answer_vote_id`) REFERENCES `answer_vote` (`answer_vote_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`);

ALTER TABLE `member` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `post` ADD FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`);

ALTER TABLE `post` ADD FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`);

ALTER TABLE `post` ADD FOREIGN KEY (`post_vote_id`) REFERENCES `post_vote` (`post_vote_id`);

ALTER TABLE `post` ADD FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`);
