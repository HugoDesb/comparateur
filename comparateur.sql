-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 09 Décembre 2016 à 20:41
-- Version du serveur :  5.5.53-0+deb8u1
-- Version de PHP :  5.6.27-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `comparateur`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte_graphique`
--

CREATE TABLE IF NOT EXISTS `carte_graphique` (
`id` int(11) NOT NULL,
  `reference` varchar(30) NOT NULL,
  `prix` double NOT NULL,
  `frequence` int(11) NOT NULL,
  `memoire` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `carte_graphique`
--

INSERT INTO `carte_graphique` (`id`, `reference`, `prix`, `frequence`, `memoire`) VALUES
(2, 'NVIDIA GeForce GTX 1080', 794.95, 1607, 8192),
(3, 'NVIDIA GeForce 210', 39.95, 600, 1024),
(4, 'NVIDIA GeForce GT 740', 89.95, 1072, 1024),
(5, 'NVIDIA GeForce GTX 1050', 154.95, 1417, 2048),
(6, 'NVIDIA GeForce GTX 960', 233.95, 1241, 2048);

-- --------------------------------------------------------

--
-- Structure de la table `cpu`
--

CREATE TABLE IF NOT EXISTS `cpu` (
`id` int(11) NOT NULL,
  `reference` varchar(30) NOT NULL,
  `prix` double NOT NULL,
  `frequence` double NOT NULL,
  `coeur` char(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `cpu`
--

INSERT INTO `cpu` (`id`, `reference`, `prix`, `frequence`, `coeur`) VALUES
(2, 'Intel Core i3-4150', 132.95, 3.5, 'I3'),
(3, 'Intel Core i3-6300', 163.95, 3.8, 'I3'),
(4, 'Intel Core i5-6500', 221.95, 3.2, 'I5'),
(5, 'Intel Core i5-4690K', 269.95, 3.5, 'I5'),
(6, 'Intel Core i7-6700K', 389.95, 4, 'I7');

-- --------------------------------------------------------

--
-- Structure de la table `disque_dur`
--

CREATE TABLE IF NOT EXISTS `disque_dur` (
`id` int(11) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `vitesse_rotation` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `disque_dur`
--

INSERT INTO `disque_dur` (`id`, `reference`, `prix`, `capacite`, `type`, `vitesse_rotation`) VALUES
(2, 'Seagate Mobile HDD 1 To', 69.95, 1000, 'HDD', 5400),
(3, 'Seagate Surveillance HDD Series 2 To', 99.95, 2000, 'HDD', 7200),
(4, 'Crucial MX300 275 Go', 99.95, 275, 'SSD', 0),
(5, 'Samsung SSD 850 PRO 512 Go', 269.95, 512, 'SSD', 0),
(6, 'Seagate BarraCuda 500 Go', 51.15, 500, 'HDD', 5400);

-- --------------------------------------------------------

--
-- Structure de la table `ordinateur`
--

CREATE TABLE IF NOT EXISTS `ordinateur` (
`id` int(11) NOT NULL,
  `carte_graphique` varchar(50) NOT NULL,
  `cpu` varchar(50) NOT NULL,
  `disque_dur` varchar(50) NOT NULL,
  `ram` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `reserve` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ordinateur`
--

INSERT INTO `ordinateur` (`id`, `carte_graphique`, `cpu`, `disque_dur`, `ram`, `prix`, `reserve`) VALUES
(1, 'NVIDIA GeForce GTX 1080', 'Intel Core i7-6700K', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 1546.35, 0),
(2, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate BarraCuda 500 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 242.9, 0),
(3, 'NVIDIA GeForce GTX 1080', 'Intel Core i3-4150', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 1030, 0),
(4, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-4690K', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 1167, 0),
(5, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 1119, 0),
(6, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-6500', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 1149, 0),
(7, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 1319, 0),
(8, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 1348.1, 0),
(9, 'NVIDIA GeForce GTX 1080', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 1378.35, 0),
(10, 'NVIDIA GeForce GTX 1050', 'Intel Core i7-6700K', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 647, 0),
(11, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-4690K', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 527, 0),
(12, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 479, 0),
(13, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 509, 0),
(14, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Crucial MX300 275 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 509, 0),
(15, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 679, 0),
(16, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate BarraCuda 500 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 460.2, 0),
(17, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate BarraCuda 500 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 462.3, 0),
(18, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate BarraCuda 500 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 519.55, 0),
(19, 'NVIDIA GeForce GTX 1050', 'Intel Core i5-6500', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 511.1, 0),
(20, 'NVIDIA GeForce GTX 1050', 'Intel Core i3-6300', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 453.1, 0),
(21, 'NVIDIA GeForce GTX 1050', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 423.1, 0),
(22, 'NVIDIA GeForce GTX 1050', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 421, 0),
(23, 'NVIDIA GeForce GT 740', 'Intel Core i3-4150', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 325, 0),
(24, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 356, 0),
(25, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 414, 0),
(26, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 444, 0),
(27, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Crucial MX300 275 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 444, 0),
(28, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 614, 0),
(29, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate BarraCuda 500 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 395.2, 0),
(30, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 400.7, 0),
(31, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 443.1, 0),
(32, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 416.1, 0),
(33, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 473.35, 0),
(34, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Crucial MX300 275 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 473.1, 0),
(35, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Crucial MX300 275 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 446.1, 0),
(36, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Crucial MX300 275 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 503.35, 0),
(37, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 275, 0),
(38, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 261.7, 0),
(39, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate Mobile HDD 1 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 304.1, 0),
(40, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Crucial MX300 275 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 305, 0),
(41, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Crucial MX300 275 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 291.7, 0),
(42, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Crucial MX300 275 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 334.1, 0),
(43, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 475, 0),
(44, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 461.7, 0),
(45, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Samsung SSD 850 PRO 512 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 504.1, 0),
(46, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate BarraCuda 500 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 256.2, 0),
(47, 'NVIDIA GeForce 210', 'Intel Core i3-4150', 'Seagate BarraCuda 500 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 285.3, 0),
(48, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 306, 0),
(49, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 292.7, 0),
(50, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 335.1, 0),
(51, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 336, 0),
(52, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 322.7, 0),
(53, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 365.1, 0),
(54, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 506, 0),
(55, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 492.7, 0),
(56, 'NVIDIA GeForce 210', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 535.1, 0),
(57, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 385.1, 0),
(58, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 358.1, 0),
(59, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 415.35, 0),
(60, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 386, 0),
(61, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Surveillance HDD Series 2 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 415.1, 0),
(62, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 445.35, 0),
(63, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 386, 0),
(64, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 415.1, 0),
(65, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 445.35, 0),
(66, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 556, 0),
(67, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 542.7, 0),
(68, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 585.1, 0),
(69, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 558.1, 0),
(70, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate BarraCuda 500 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 366.3, 0),
(71, 'NVIDIA GeForce GT 740', 'Intel Core i3-6300', 'Seagate BarraCuda 500 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 339.3, 0),
(72, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 643.1, 0),
(73, 'NVIDIA GeForce GT 740', 'Intel Core i5-6500', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 673.35, 0),
(74, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 492, 0),
(75, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 478.7, 0),
(76, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Seagate Surveillance HDD Series 2 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 521.1, 0),
(77, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 551.35, 0),
(78, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Crucial MX300 275 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 478.7, 0),
(79, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Crucial MX300 275 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 494.1, 0),
(80, 'NVIDIA GeForce GT 740', 'Intel Core i5-4690K', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 648.7, 0),
(81, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Mobile HDD 1 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 726, 0),
(82, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Mobile HDD 1 To', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 755.1, 0),
(83, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Mobile HDD 1 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 785.35, 0),
(84, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 756, 0),
(85, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 758.1, 0),
(86, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Seagate Surveillance HDD Series 2 To', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 815.35, 0),
(87, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Samsung SSD 850 PRO 512 Go', 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 926, 0),
(88, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 928.1, 0),
(89, 'NVIDIA GeForce GTX 960', 'Intel Core i7-6700K', 'Samsung SSD 850 PRO 512 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 985.35, 0),
(90, 'NVIDIA GeForce GTX 960', 'Intel Core i5-4690K', 'Seagate BarraCuda 500 Go', 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 616.3, 0),
(91, 'NVIDIA GeForce GTX 960', 'Intel Core i5-4690K', 'Seagate BarraCuda 500 Go', 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 646.55, 0),
(92, 'NVIDIA GeForce GTX 960', 'Intel Core i5-4690K', 'Seagate Surveillance HDD Series 2 To', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 622.7, 0),
(93, 'NVIDIA GeForce GTX 1080', 'Intel Core i3-6300', 'Crucial MX300 275 Go', 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 1077.7, 0);

-- --------------------------------------------------------

--
-- Structure de la table `ram`
--

CREATE TABLE IF NOT EXISTS `ram` (
`id` int(11) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `capacite` int(11) NOT NULL,
  `frequence` int(11) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ram`
--

INSERT INTO `ram` (`id`, `reference`, `prix`, `capacite`, `frequence`, `type`) VALUES
(5, 'Corsair Value Select 4 Go DDR3 1600 MHz CL11', 32.15, 4, 1600, 'DDR3'),
(6, 'Corsair Value Select 2 Go DDR3 1333 MHz CL9', 18.85, 2, 1333, 'DDR3'),
(7, 'Kingston ValueRAM 8 Go DDR3L 1600 MHz CL11 DR X8', 61.25, 8, 1600, 'DDR3'),
(8, 'HyperX Savage Noir 4 Go DDR4 2400 MHz CL12', 34.25, 4, 2400, 'DDR4'),
(9, 'HyperX Savage Noir 8 Go DDR4 2800 MHz CL14', 91.5, 8, 2800, 'DDR4');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `carte_graphique`
--
ALTER TABLE `carte_graphique`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cpu`
--
ALTER TABLE `cpu`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `disque_dur`
--
ALTER TABLE `disque_dur`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `ram`
--
ALTER TABLE `ram`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `carte_graphique`
--
ALTER TABLE `carte_graphique`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `cpu`
--
ALTER TABLE `cpu`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `disque_dur`
--
ALTER TABLE `disque_dur`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `ordinateur`
--
ALTER TABLE `ordinateur`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=94;
--
-- AUTO_INCREMENT pour la table `ram`
--
ALTER TABLE `ram`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
