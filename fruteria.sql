CREATE DATABASE IF NOT EXISTS `fruteria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `fruteria`;

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

INSERT INTO `productos` (`id`, `nombre`, `precio`) VALUES
(5, 'Manzanas', 3.5),
(6, 'Peras', 4),
(7, 'Plátanos', 2.5),
(8, 'Ciruelas', 4.5),
(9, 'Aguacates', 10),
(10, 'Tomates', 3);

