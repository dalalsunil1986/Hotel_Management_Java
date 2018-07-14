-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2018 at 09:45 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `relex`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_name` varchar(100) NOT NULL,
  `c_email` varchar(30) NOT NULL,
  `c_city` varchar(20) NOT NULL,
  `c_state` varchar(20) NOT NULL,
  `c_country` varchar(20) NOT NULL,
  `c_date` varchar(30) NOT NULL,
  `c_id` varchar(30) NOT NULL,
  `c_idnum` varchar(30) NOT NULL,
  `c_room` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_name`, `c_email`, `c_city`, `c_state`, `c_country`, `c_date`, `c_id`, `c_idnum`, `c_room`) VALUES
('Alex Ponting', 'Alexpn@gmail.com', 'London', 'UK', 'England', '7-6-2018', 'Voter-ID', 'TRF43ER6678', 1),
('joe Root', 'Root@gmail.com', 'London', 'UK', 'England', '7-6-2018', 'Driving Licence', 'BGYH54RF6TGF', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_room`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_room` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
