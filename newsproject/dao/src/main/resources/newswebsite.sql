
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP TABLE IF EXISTS`news`;
DROP TABLE IF EXISTS`users`;

DROP TABLE IF EXISTS`roles`;
CREATE TABLE `news` (
                        `id` int(11) NOT NULL,
                        `imageaddress` text NOT NULL ,
                         `newstext` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `roles` (
                         `id` int(11) NOT NULL,
                         `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `roles` (`id`, `name`) VALUES
                                       (1, 'role_admin'),
                                       (2, 'role_user');

CREATE TABLE `users` (
                         `id` int(11) NOT NULL,
                         `name` varchar(100) NOT NULL,
                         `pass` varchar(100) NOT NULL,
                         `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` (`id`, `name`, `pass`, `role_id`) VALUES
    (1, 'admin', '835d6dc88b708bc646d6db82c853ef4182fabbd4a8de59c213f2b5ab3ae7d9be', 1);


ALTER TABLE `news`
    ADD PRIMARY KEY (`id`);


ALTER TABLE `roles`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `name` (`name`);


ALTER TABLE `users`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `name` (`name`),
    ADD KEY `role_id` (`role_id`);
ALTER TABLE `news`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `roles`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `users`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `users`
    ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION;
COMMIT;
