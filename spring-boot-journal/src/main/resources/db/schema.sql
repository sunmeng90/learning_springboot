-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`
(
    `next_val` bigint(20) NULL DEFAULT NULL
);

-- ----------------------------
-- Table structure for journal
-- ----------------------------
DROP TABLE IF EXISTS `journal`;
CREATE TABLE `journal`
(
    `id`      bigint(20)  NOT NULL,
    `created` datetime(0) NULL DEFAULT NULL,
    `summary` varchar(255),
    `title`   varchar(255),
    PRIMARY KEY (`id`)
);