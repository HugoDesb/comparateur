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
-- Structure de la table `ecran`
--

CREATE TABLE IF NOT EXISTS `ecran` (
  `id` int(11) NOT NULL,
  `reference` varchar(30) NOT NULL,
  `type` varchar(10) NOT NULL,
  `taille` double NOT NULL,
  `resolution` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ecran`
--

INSERT INTO `ecran` (`id`, `reference`, `type`, `taille`, `resolution`) VALUES
(2, 'Amoled - 5.5p - sd', 'oled', 5.5, 'sd'),
(3, 'LCD - 5.5p - hd', 'lcd', 5.5, 'hd'),
(4, 'Amoled - 6p - fhd', 'oled', 6, 'fhd'),
(5, 'LCD - 6p - fhd', 'lcd', 6, 'fhd');


-- --------------------------------------------------------

--
-- Structure de la table `processeur`
--
CREATE TABLE IF NOT EXISTS `processeur` (
  `id` int(11) NOT NULL,
  `reference` varchar(30) NOT NULL,
  `architecture` varchar(10) NOT NULL,
  `frequence` double NOT NULL,
  `marque` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `processeur`
--

INSERT INTO `processeur` (`id`, `reference`, `architecture`, `frequence`, `marque`) VALUES
(2, 'A11 Bionic', 'x64', 2.39, 'Apple'),
(3, 'Cortex-A72', 'arm', 1.5, 'ARM'),
(4, 'SnapDragon', 'arm', 2, 'Qualcomm');

-- --------------------------------------------------------

--
-- Structure de la table `batterie`
--

CREATE TABLE IF NOT EXISTS `batterie` (
  `id` int(11) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `capacite` int(11) NOT NULL,
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `batterie`
--

INSERT INTO `batterie` (`id`, `reference`, `capacite`) VALUES
(2, 'Moyenne', 2716),
(3, 'Grande', 4600),
(4, 'Petite', 1500);

-- --------------------------------------------------------

--
-- Structure de la table `appareil_photo`
--

CREATE TABLE IF NOT EXISTS `appareil_photo` (
  `id` int(11) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `resolution` double NOT NULL,
  `ouverture` double NOT NULL,
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `appareil_photo`
--

INSERT INTO `appareil_photo` (`id`, `reference`, `resolution`, `ouverture`) VALUES
(5, 'iPhone X', 12, 1.8),
(6, 'Sony IMX318 ', 23, 2),
(7, 'HTC', 20, 1.7);
-- --------------------------------------------------------

--
-- Structure de la table `smartphone`
--

CREATE TABLE IF NOT EXISTS `smartphone` (
  `id` int(11) NOT NULL,
  `ecran` varchar(50) NOT NULL,
  `processeur` varchar(50) NOT NULL,
  `batterie` varchar(50) NOT NULL,
  `appareil_photo` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `marque` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;




--
-- Contenu de la table `smartphone`
--
(2, 'Amoled - 5.5p - sd', 'oled', 5.5, 'sd'),
(3, 'LCD - 5.5p - hd', 'lcd', 5.5, 'hd'),
(4, 'Amoled - 6p - fhd', 'oled', 6, 'fhd'),
(5, 'LCD - 6p - fhd', 'lcd', 6, 'fhd');

(2, 'A11 Bionic', 'x64', 2.39, 'Apple'),
(3, 'Cortex-A72', 'arm', 1.5, 'ARM'),
(4, 'SnapDragon 870', 'arm', 2, 'Qualcomm');

(2, 'Moyenne', 2716),
(3, 'Grande', 4600),
(4, 'Petite', 1500);

(5, 'iPhone X', 12, 1.8),
(6, 'Sony IMX318 ', 23, 2),
(7, 'HTC', 20, 1.7);

INSERT INTO `smartphone` (`id`, `ecran`, `processeur`, `batterie`, `appareil_photo`, `prix`,marque) VALUES
(1, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Petite', 'iPhone X', 1160, 'A'),
(2, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Petite', 'Sony IMX318', 1119, 'B'),
(3, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Petite', 'HTC', 1030,'C'),
(4, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Moyenne', 'iPhone X', 1160, 'A'),
(5, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(6, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Moyenne', 'HTC', 1030,'C'),
(7, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Grande', 'iPhone X', 1160, 'A'),
(8, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Grande', 'Sony IMX318', 1119, 'B'),
(9, 'Amoled - 5.5p - sd', 'A11 Bionic', 'Grande', 'HTC', 1030,'C'),
(10, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Petite', 'iPhone X', 1160, 'A'),
(11, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Petite', 'Sony IMX318', 1119, 'B'),
(12, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Petite', 'HTC', 1030,'C'),
(13, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Moyenne', 'iPhone X', 1160, 'A'),
(14, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(15, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Moyenne', 'HTC', 1030,'C'),
(16, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Grande', 'iPhone X', 1160, 'A'),
(17, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Grande', 'Sony IMX318', 1119, 'B'),
(18, 'Amoled - 5.5p - sd', 'Cortex-A72', 'Grande', 'HTC', 1030,'C'),
(19, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Petite', 'iPhone X', 1160, 'A'),
(20, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Petite', 'Sony IMX318', 1119, 'B'),
(21, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Petite', 'HTC', 1030,'C'),
(22, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Moyenne', 'iPhone X', 1160, 'A'),
(23, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(24, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Moyenne', 'HTC', 1030,'C'),
(25, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Grande', 'iPhone X', 1160, 'A'),
(26, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Grande', 'Sony IMX318', 1119, 'B'),
(27, 'Amoled - 5.5p - sd', 'SnapDragon 870', 'Grande', 'HTC', 1030,'C'),

(28, 'LCD - 5.5p - hd', 'A11 Bionic', 'Petite', 'iPhone X', 1160, 'A'),
(29, 'LCD - 5.5p - hd', 'A11 Bionic', 'Petite', 'Sony IMX318', 1119, 'B'),
(30, 'LCD - 5.5p - hd', 'A11 Bionic', 'Petite', 'HTC', 1030,'C'),
(31, 'LCD - 5.5p - hd', 'A11 Bionic', 'Moyenne', 'iPhone X', 1160, 'A'),
(32, 'LCD - 5.5p - hd', 'A11 Bionic', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(33, 'LCD - 5.5p - hd', 'A11 Bionic', 'Moyenne', 'HTC', 1030,'C'),
(34, 'LCD - 5.5p - hd', 'A11 Bionic', 'Grande', 'iPhone X', 1160, 'A'),
(35, 'LCD - 5.5p - hd', 'A11 Bionic', 'Grande', 'Sony IMX318', 1119, 'B'),
(36, 'LCD - 5.5p - hd', 'A11 Bionic', 'Grande', 'HTC', 1030,'C'),
(37, 'LCD - 5.5p - hd', 'Cortex-A72', 'Petite', 'iPhone X', 1160, 'A'),
(38, 'LCD - 5.5p - hd', 'Cortex-A72', 'Petite', 'Sony IMX318', 1119, 'B'),
(39, 'LCD - 5.5p - hd', 'Cortex-A72', 'Petite', 'HTC', 1030,'C'),
(40, 'LCD - 5.5p - hd', 'Cortex-A72', 'Moyenne', 'iPhone X', 1160, 'A'),
(41, 'LCD - 5.5p - hd', 'Cortex-A72', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(42, 'LCD - 5.5p - hd', 'Cortex-A72', 'Moyenne', 'HTC', 1030,'C'),
(43, 'LCD - 5.5p - hd', 'Cortex-A72', 'Grande', 'iPhone X', 1160, 'A'),
(44, 'LCD - 5.5p - hd', 'Cortex-A72', 'Grande', 'Sony IMX318', 1119, 'B'),
(45, 'LCD - 5.5p - hd', 'Cortex-A72', 'Grande', 'HTC', 1030,'C'),
(46, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Petite', 'iPhone X', 1160, 'A'),
(47, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Petite', 'Sony IMX318', 1119, 'B'),
(48, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Petite', 'HTC', 1030,'C'),
(49, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Moyenne', 'iPhone X', 1160, 'A'),
(50, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(51, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Moyenne', 'HTC', 1030,'C'),
(52, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Grande', 'iPhone X', 1160, 'A'),
(53, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Grande', 'Sony IMX318', 1119, 'B'),
(54, 'LCD - 5.5p - hd', 'SnapDragon 870', 'Grande', 'HTC', 1030,'C'),

(56, 'Amoled - 6p - fhd', 'A11 Bionic', 'Petite', 'iPhone X', 1160, 'A'),
(57, 'Amoled - 6p - fhd', 'A11 Bionic', 'Petite', 'Sony IMX318', 1119, 'B'),
(58, 'Amoled - 6p - fhd', 'A11 Bionic', 'Petite', 'HTC', 1030,'C'),
(59, 'Amoled - 6p - fhd', 'A11 Bionic', 'Moyenne', 'iPhone X', 1160, 'A'),
(60, 'Amoled - 6p - fhd', 'A11 Bionic', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(61, 'Amoled - 6p - fhd', 'A11 Bionic', 'Moyenne', 'HTC', 1030,'C'),
(62, 'Amoled - 6p - fhd', 'A11 Bionic', 'Grande', 'iPhone X', 1160, 'A'),
(63, 'Amoled - 6p - fhd', 'A11 Bionic', 'Grande', 'Sony IMX318', 1119, 'B'),
(64, 'Amoled - 6p - fhd', 'A11 Bionic', 'Grande', 'HTC', 1030,'C'),
(65, 'Amoled - 6p - fhd', 'Cortex-A72', 'Petite', 'iPhone X', 1160, 'A'),
(66, 'Amoled - 6p - fhd', 'Cortex-A72', 'Petite', 'Sony IMX318', 1119, 'B'),
(67, 'Amoled - 6p - fhd', 'Cortex-A72', 'Petite', 'HTC', 1030,'C'),
(68, 'Amoled - 6p - fhd', 'Cortex-A72', 'Moyenne', 'iPhone X', 1160, 'A'),
(69, 'Amoled - 6p - fhd', 'Cortex-A72', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(70, 'Amoled - 6p - fhd', 'Cortex-A72', 'Moyenne', 'HTC', 1030,'C'),
(71, 'Amoled - 6p - fhd', 'Cortex-A72', 'Grande', 'iPhone X', 1160, 'A'),
(72, 'Amoled - 6p - fhd', 'Cortex-A72', 'Grande', 'Sony IMX318', 1119, 'B'),
(73, 'Amoled - 6p - fhd', 'Cortex-A72', 'Grande', 'HTC', 1030,'C'),
(74, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Petite', 'iPhone X', 1160, 'A'),
(75, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Petite', 'Sony IMX318', 1119, 'B'),
(76, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Petite', 'HTC', 1030,'C'),
(77, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'iPhone X', 1160, 'A'),
(78, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(79, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'HTC', 1030,'C'),
(80, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Grande', 'iPhone X', 1160, 'A'),
(81, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Grande', 'Sony IMX318', 1119, 'B'),
(82, 'Amoled - 6p - fhd', 'SnapDragon 870', 'Grande', 'HTC', 1030,'C'),

(83, 'LCD - 6p - fhd', 'A11 Bionic', 'Petite', 'iPhone X', 1160, 'A'),
(84, 'LCD - 6p - fhd', 'A11 Bionic', 'Petite', 'Sony IMX318', 1119, 'B'),
(85, 'LCD - 6p - fhd', 'A11 Bionic', 'Petite', 'HTC', 1030,'C'),
(86, 'LCD - 6p - fhd', 'A11 Bionic', 'Moyenne', 'iPhone X', 1160, 'A'),
(87, 'LCD - 6p - fhd', 'A11 Bionic', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(88, 'LCD - 6p - fhd', 'A11 Bionic', 'Moyenne', 'HTC', 1030,'C'),
(89, 'LCD - 6p - fhd', 'A11 Bionic', 'Grande', 'iPhone X', 1160, 'A'),
(90, 'LCD - 6p - fhd', 'A11 Bionic', 'Grande', 'Sony IMX318', 1119, 'B'),
(91, 'LCD - 6p - fhd', 'A11 Bionic', 'Grande', 'HTC', 1030,'C'),
(92, 'LCD - 6p - fhd', 'Cortex-A72', 'Petite', 'iPhone X', 1160, 'A'),
(93, 'LCD - 6p - fhd', 'Cortex-A72', 'Petite', 'Sony IMX318', 1119, 'B'),
(94, 'LCD - 6p - fhd', 'Cortex-A72', 'Petite', 'HTC', 1030,'C'),
(95, 'LCD - 6p - fhd', 'Cortex-A72', 'Moyenne', 'iPhone X', 1160, 'A'),
(96, 'LCD - 6p - fhd', 'Cortex-A72', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(97, 'LCD - 6p - fhd', 'Cortex-A72', 'Moyenne', 'HTC', 1030,'C'),
(98, 'LCD - 6p - fhd', 'Cortex-A72', 'Grande', 'iPhone X', 1160, 'A'),
(99, 'LCD - 6p - fhd', 'Cortex-A72', 'Grande', 'Sony IMX318', 1119, 'B'),
(100, 'LCD - 6p - fhd', 'Cortex-A72', 'Grande', 'HTC', 1030,'C'),
(101, 'LCD - 6p - fhd', 'SnapDragon 870', 'Petite', 'iPhone X', 1160, 'A'),
(102, 'LCD - 6p - fhd', 'SnapDragon 870', 'Petite', 'Sony IMX318', 1119, 'B'),
(103, 'LCD - 6p - fhd', 'SnapDragon 870', 'Petite', 'HTC', 1030,'C'),
(104, 'LCD - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'iPhone X', 1160, 'A'),
(105, 'LCD - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'Sony IMX318', 1119, 'B'),
(106, 'LCD - 6p - fhd', 'SnapDragon 870', 'Moyenne', 'HTC', 1030,'C'),
(107, 'LCD - 6p - fhd', 'SnapDragon 870', 'Grande', 'iPhone X', 1160, 'A'),
(108, 'LCD - 6p - fhd', 'SnapDragon 870', 'Grande', 'Sony IMX318', 1119, 'B'),
(109, 'LCD - 6p - fhd', 'SnapDragon 870', 'Grande', 'HTC', 1030,'C'),

-- --------------------------------------------------------



--
-- Index pour les tables exportees
--

--
-- Index pour la table `ecran`
--
ALTER TABLE `ecran`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `processeur`
--
ALTER TABLE `processeur`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `batterie`
--
ALTER TABLE `batterie`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `appareil_photo`
--
ALTER TABLE `appareil_photo`
 ADD PRIMARY KEY (`id`);
 
--
-- Index pour la table `smartphone`
--
ALTER TABLE `smartphone`
 ADD PRIMARY KEY (`id`);



--
-- AUTO_INCREMENT pour les tables exportees
--

--
-- AUTO_INCREMENT pour la table `ecran`
--
ALTER TABLE `ecran`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `processeur`
--
ALTER TABLE `processeur`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `batterie`
--
ALTER TABLE `batterie`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `appareil_photo`
--
ALTER TABLE `appareil_photo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `smartphone`
--
ALTER TABLE `smartphone`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=94;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
