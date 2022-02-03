DROP TABLE IF EXISTS packages;

CREATE TABLE `packages` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `p_id` int NOT NULL
);

INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(1,'Up to 5 projects', 1);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(2,'Up to 10 projects', 2);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(3,'unlimited projects', 3);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(4,'Up to 10 collabrators', 1);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(5,'Up to 20 collabrators', 2);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(6,'Unlimited collabrators', 3);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(7,'2gb of storage', 1);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(8,'10gb of storage', 2);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(9,'Unlimited of storage', 3);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(10,'Only Office hours support', 1);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(11,'Only Office hours support', 2);
INSERT INTO `packages`(`id`, `name`, `p_id`) VALUES(12,'24x7 Support', 3);


DROP TABLE IF EXISTS pricings;

CREATE TABLE `pricings` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `price` number(15,3) NOT NULL
);

INSERT INTO `pricings`(`id`, `name`, `price`) VALUES(1,'Basic', 12.94);
INSERT INTO `pricings`(`id`, `name`, `price`) VALUES(2,'Intermediate', 23.78);
INSERT INTO `pricings`(`id`, `name`, `price`) VALUES(3,'Unlimited', 50.86);


DROP TABLE IF EXISTS services;

CREATE TABLE `services` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL
);

INSERT INTO `services`(`id`, `name`, `description`) VALUES(1,'Web Development', 'Building, creating, and maintaining of websites. It is the creation of an application that works over the internet i.e. websites.');
INSERT INTO `services`(`id`, `name`, `description`) VALUES(2,'Business Branding', 'Creating a comprehensive message for your company and product or service, using names, logos, slogans, copy and others.');
INSERT INTO `services`(`id`, `name`, `description`) VALUES(3,'App Development', 'The creation of computer applications for use on mobile devices such as tablets, smartphones and smart watches.');
INSERT INTO `services`(`id`, `name`, `description`) VALUES(4,'Graphic Design', 'Craft where professionals create visual content to communicate messages.');
INSERT INTO `services`(`id`, `name`, `description`) VALUES(5,'Content Writing', 'Process of planning, writing and editing web content, typically for digital marketing purposes.');
INSERT INTO `services`(`id`, `name`, `description`) VALUES(6,'Digital Marketing', 'promotion of brands to connect with potential customers using the internet and other forms of digital communication.');







