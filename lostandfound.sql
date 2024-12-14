-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2023 at 05:27 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lostandfound`
--

-- --------------------------------------------------------

--
-- Table structure for table `found_item`
--

CREATE TABLE `found_item` (
  `item1` varchar(20) NOT NULL,
  `foundername2` varchar(20) NOT NULL,
  `founderphone3` varchar(11) NOT NULL,
  `email4` varchar(50) DEFAULT NULL,
  `itemcolor5` varchar(20) NOT NULL,
  `location6` varchar(30) NOT NULL,
  `founderid7` varchar(10) NOT NULL,
  `description8` varchar(100) DEFAULT NULL,
  `founddate9` varchar(20) NOT NULL,
  `itemcatagory` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `found_item`
--

INSERT INTO `found_item` (`item1`, `foundername2`, `founderphone3`, `email4`, `itemcolor5`, `location6`, `founderid7`, `description8`, `founddate9`, `itemcatagory`) VALUES
('pixel six', 'mehedi', '20', '', '', 'bubt', '20', 'sgasfgd', '12sept', 0),
('', '', '20', '', '', '', '20', '', '', 0),
('', '', '20', '', '', '', '20', '', '', 0),
('galaxy s20+', 'polin', '20', 'mehedi7hasan10134@gmail.com', '', 'puran dhaka', '20', ' nothing to describe', '12 sept 2023', 0),
('mi a3', 'mehedi hasan ', '20', 'mehedi7hasan10134@gmail.com', '', 'puran dhaka', '20', 'nothing', '12 sept 2023', 0),
('redmi 12', 'pabel', '20', 'pabel223@gmail.com', '', 'postogola', '20', 'nothing', '11 october 2021', 0),
('iphone 11', 'mamun ur rashid', '0147984150', 'mamunisrat@gmail.com', '', 'gazipur,boardbazar', '527', 'null', '30 october 2023', 0),
('keyboard', 'mehedi', '018754620', 'amiopiwjne@gmail.com', '', 'ophsegfi', '526', '', '', 0),
('iphone 11', 'mamun', '01854112', 'mamunisrat@gmail.com', 'purple', 'gazipur', '527', '', '12 oct 2022', 0),
('key', 'ytfyub', '350151', 'iuiujuij', 'red', '', '526', '', '', 0),
('samsung s20', 'Zahid Hasan ', '01724348000', 'zahidhasantonmoybd@gmail.com', 'blue', 'Dhaka', '407', 'Nothing', '05-11-2023', 0),
('samsung', 'Zahid', '017', 'zahid@gmail.com', 'blue', 'Dhaka', '123', 'nothing', '05-11-23', 0),
('testing', 'testing', '084', 'testing', 'testing', 'testing', 'testing', 'testing', 'testing', 2),
('', '', '', '', '', '', '', '', '', 2),
('new test', 'new test', 'new test', 'new test', 'new test', 'new test', 'new test', 'new test', 'new test', 9),
('testhgg', 'testhgg', 'testhgg', 'testhgg', 'testhgg', 'testhgg', 'testhgg', 'testhgg', 'testhgg', 4),
('testing', 'testing', 'testing', 'testing', 'testing', 'testing', 'testing', 'testing', 'testing', 0),
('', '', 'uuuiiu', '', 'uuuiiu', '', 'uuuiiu', '', '', 0),
('uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 'uuuiiu', 1),
('okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 'okkkkkk', 0),
('ebrahim', 'ebrahim', 'ebrahim', 'ebrahim', '2', 'ebrahim', '', 'ebrahim', 'ebrahim', 0),
('samsung', 'samsung', 'samsung', 'samsung', '2', 'samsung', '', 'samsung', 'samsung', 0),
('last test', 'last test', 'last test', 'last test', '1', 'last test', '', 'last test', 'last test', 1);

-- --------------------------------------------------------

--
-- Table structure for table `lost_item`
--

CREATE TABLE `lost_item` (
  `item1` varchar(20) NOT NULL,
  `lostname2` varchar(20) NOT NULL,
  `lostphone3` varchar(11) NOT NULL,
  `email4` varchar(50) DEFAULT NULL,
  `itemcolor5` varchar(20) NOT NULL,
  `location6` varchar(30) NOT NULL,
  `lostid7` varchar(10) NOT NULL,
  `description8` varchar(100) DEFAULT NULL,
  `lostdate9` varchar(20) NOT NULL,
  `itemcatagory` int(20) NOT NULL,
  `imei11` varchar(50) NOT NULL,
  `idno12` varchar(50) NOT NULL,
  `vr13` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lost_item`
--

INSERT INTO `lost_item` (`item1`, `lostname2`, `lostphone3`, `email4`, `itemcolor5`, `location6`, `lostid7`, `description8`, `lostdate9`, `itemcatagory`, `imei11`, `idno12`, `vr13`) VALUES
('teset', 'teset', 'teset', 'teset', 'teset', 'teset', 'teset', 'teset', 'teset', 5, '', '', ''),
('tetst', 'tetst', 'tetst', 'tetst', 'tetst', 'tetst', 'tetst', 'tetst', 'tetst', 0, '5165123132132121', '', ''),
('dddddd', 'dddddd', 'dddddd', 'dddddd', '2', 'dddddd', '', 'dddddd', 'dddddd', 0, 'dddddd', '', ''),
('dddddd', 'dddddd', 'dddddd', '', '0', 'dddddd', '', '', '', 1, '', '', ''),
('samiull', 'samiull', 'samiull', 'samiull', '1', 'samiull', '', 'samiull', 'samiull', 0, 'samiull', '', ''),
('last test', 'last test', 'last test', 'last test', '1', 'last test', '', 'last test', 'last test', 1, '', '', ''),
('lastaddd', 'lastaddd', 'lastaddd', 'lastaddd', '2', 'lastaddd', '', 'lastadddlastaddd', 'lastaddd', 1, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `registrationdate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`userid`, `username`, `password`, `email`, `phone`, `address`, `gender`, `registrationdate`) VALUES
(1, '152786', '1234', 'hudai', '01475552', 'dilam', 'Male', '2023-11-13 16:42:18'),
(2, '608538', 'fdjfgnjfd', 'jhgnjkn', '0144', 'ajknjkf', 'Male', '2023-11-13 16:45:42'),
(3, '510384', 'okkkk', 'okkkk', 'okkkk', 'okkkk', 'Male', '2023-11-14 06:02:15'),
(4, '876671', 'java', 'java', 'java', 'java', 'Male', '2023-11-15 13:48:10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userdata`
--
ALTER TABLE `userdata`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
