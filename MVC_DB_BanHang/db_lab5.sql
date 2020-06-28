-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2020 at 09:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_lab5`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `hdMa` int(11) NOT NULL,
  `khMa` varchar(11) NOT NULL,
  `hdTongTien` int(11) NOT NULL,
  `hdNgayMua` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`hdMa`, `khMa`, `hdTongTien`, `hdNgayMua`) VALUES
(17, 'ce130438', 1450, '2020-06-13'),
(18, 'ce140122', 3700, '2020-06-13'),
(19, 'ce140244', 1200, '2020-06-13'),
(20, 'ce140244', 1400, '2020-06-13'),
(21, 'ce130438', 900, '2020-06-13'),
(22, 'ce140122', 1450, '2020-06-13'),
(23, 'ce130438', 900, '2020-06-15'),
(24, 'ce130438', 1000, '2020-06-15'),
(25, 'ce140122', 950, '2020-06-15'),
(26, 'ce140244', 600, '2020-06-15'),
(27, 'ce130438', 4500, '2020-06-20'),
(28, 'ce130438', 2400, '2020-06-20'),
(29, 'ce140244', 2800, '2020-06-20'),
(30, 'ce140122', 2650, '2020-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `hoadonchitiet`
--

CREATE TABLE `hoadonchitiet` (
  `hdMa` int(11) NOT NULL,
  `spMa` int(11) NOT NULL,
  `hdctSoLuong` int(11) NOT NULL,
  `hdctThanhTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hoadonchitiet`
--

INSERT INTO `hoadonchitiet` (`hdMa`, `spMa`, `hdctSoLuong`, `hdctThanhTien`) VALUES
(17, 1, 2, 1000),
(18, 1, 2, 1000),
(20, 1, 1, 500),
(22, 1, 2, 1000),
(24, 1, 2, 1000),
(25, 1, 1, 500),
(27, 1, 9, 4500),
(28, 1, 3, 1500),
(29, 1, 2, 1000),
(30, 1, 2, 1000),
(17, 2, 1, 450),
(18, 2, 6, 2700),
(19, 2, 2, 900),
(20, 2, 2, 900),
(21, 2, 2, 900),
(22, 2, 1, 450),
(23, 2, 2, 900),
(25, 2, 1, 450),
(28, 2, 2, 900),
(29, 2, 2, 900),
(30, 2, 3, 1350),
(19, 3, 1, 300),
(26, 3, 2, 600),
(29, 3, 3, 900),
(30, 3, 1, 300);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `khMa` varchar(11) NOT NULL,
  `khTen` varchar(30) NOT NULL,
  `khEmail` varchar(30) NOT NULL,
  `khSDT` varchar(15) NOT NULL,
  `khDiaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`khMa`, `khTen`, `khEmail`, `khSDT`, `khDiaChi`) VALUES
('ce130438', 'Minh Tin', 'minhtin@gmail.com', '0983432428', 'Tien Giang'),
('ce140122', 'Nhien', 'nhien@gmail.com', '0324234423', 'Hau Giang'),
('ce140244', 'Truong Nhat Nam', 'nam@gmail.com', '0343475037', 'Vinh Long');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `spMa` int(11) NOT NULL,
  `spTen` varchar(50) NOT NULL,
  `spGia` double NOT NULL,
  `spSoLuong` int(11) NOT NULL,
  `spMoTa` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`spMa`, `spTen`, `spGia`, `spSoLuong`, `spMoTa`) VALUES
(1, 'iPhone 11', 500, 3, '3 camera'),
(2, 'Samsung S10', 450, 14, 'Body sexy'),
(3, 'Sony XA', 300, 5, 'OLED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`hdMa`),
  ADD KEY `khMa` (`khMa`);

--
-- Indexes for table `hoadonchitiet`
--
ALTER TABLE `hoadonchitiet`
  ADD PRIMARY KEY (`spMa`,`hdMa`),
  ADD KEY `hdMa` (`hdMa`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`khMa`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`spMa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `hdMa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `spMa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`khMa`) REFERENCES `khachhang` (`khMa`);

--
-- Constraints for table `hoadonchitiet`
--
ALTER TABLE `hoadonchitiet`
  ADD CONSTRAINT `hoadonchitiet_ibfk_1` FOREIGN KEY (`hdMa`) REFERENCES `hoadon` (`hdMa`),
  ADD CONSTRAINT `hoadonchitiet_ibfk_2` FOREIGN KEY (`spMa`) REFERENCES `sanpham` (`spMa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
