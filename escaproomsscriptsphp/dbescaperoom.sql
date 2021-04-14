-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2021 at 01:10 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbescaperoom`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_no` int(11) NOT NULL,
  `bill_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `mobile` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bill_details`
--

CREATE TABLE `bill_details` (
  `bill_no` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `category` varchar(50) NOT NULL,
  `photo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `category`, `photo`) VALUES
(1, 'Tazmamart', 499, 'PrisonEscape', 'taz.jpg'),
(2, 'Alchemist', 49.99, 'PuzzleGames', 'alch.png'),
(3, 'MentalLab', 39.99, 'Science', 'lab2.jpg'),
(4, 'Alcatraz', 499, 'PrisonEscape', 'alc.jpg'),
(5, 'Puzzle', 49.99, 'PuzzleGames', 'puz.jpg'),
(6, 'CodingChallenge', 49.99, 'ComputerChallenges', 'co.png'),
(7, 'WitchSpell', 79.99, 'Horror', 'witch.jpg'),
(8, 'BlindMode', 19.99, 'Adventure', 'blin.jpg'),
(9, 'Oukacha', 129.99, 'PrisonEscape', 'oka.jpg'),
(10, 'Bioshock', 49.99, 'Horror', 'bio.jpg'),
(11, 'Devil Island', 350, 'PrisonEscape', 'devilis.jpg'),
(12, 'Château d\'If et Île du Diable', 479, 'PrisonEscape', 'chateaux.jpg'),
(13, 'Tadmor', 199, 'PrisonEscape', 'tadmor.jpg'),
(14, 'La Sante', 199, 'PrisonEscape', 'sante.jpg'),
(15, 'Laboratoire', 19.99, 'Science', 'lab2.jpg'),
(16, 'LaboratoireX', 49.99, 'Science', 'lab.jpg'),
(18, 'Paranormal', 55, 'Horror', 'horror2.jpg'),
(19, 'Teccart', 39000, 'Horror', 'teccart.jpg'),
(20, 'Sewers', 79.99, 'Horror', 'horror1.png');

-- --------------------------------------------------------

--
-- Table structure for table `temp_order`
--

CREATE TABLE `temp_order` (
  `mobile` varchar(15) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_order`
--

INSERT INTO `temp_order` (`mobile`, `item_id`, `quantity`) VALUES
('514123456', 2, 0),
('514123456', 8, 0),
('514123456', 6, 0),
('514123456', 2, 0),
('33', 1, 0),
('33', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `mobile` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`mobile`, `password`, `name`, `address`) VALUES
('514123456', 'pass', 'SoufianeJD', 's.f.j.dsapro@gmail.com'),
('77', 'qq', 'qq', 'qq'),
('99', 'ww', 'ww', 'ww'),
('33', 'dd', 'dd', 'dd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_no`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
