CREATE TABLE `url`(
    `id` VARCHAR(36) NOT NULL,
    `url` VARCHAR(400) NOT NULL,
    `url_identifier` VARCHAR(20) NOT NULL,
    `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `click_count` INTEGER NOT NULL,

    PRIMARY KEY (`id`),
    INDEX `id` (`id` ASC),
    INDEX `url_identifier` (`url_identifier` ASC)
);