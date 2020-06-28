-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 13, 2020 at 05:13 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_student`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` varchar(20) NOT NULL,
  `fullname` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `fullname`, `birthday`, `email`, `phone`, `address`) VALUES
('1', 'Clone User', '2020-06-23', 'userclone77@gmail.com', '7520660716', '1360 B Street West St Paul'),
('34', 'Clone User', '2020-06-09', 'userclone77@gmail.com', '7520660716', '1360 B Street West St Paul'),
('ce130438', 'gfgger', '2020-06-27', 'userclone77@gmail.com', '7520660716', '1360 B Street West St Paul'),
('e3ret435', 'Clone User', '2020-06-03', 'userclone77@gmail.com', '7520660716', '1360 B Street West St Paul'),
('errrrrr322323', 'MINH', '2020-07-22', 'minh@gmail.com', '09324793257', 'TIEN GIANG'),
('erwury', 'Clone User', '2020-06-18', 'userclone77@gmail.com', '7520660716', '1360 B Street West St Paul'),
('TIN', 'Clone User', '2020-06-24', 'userclone77@gmail.com', '7520660716', 'THG');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
