-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2019 at 09:05 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_donasi_online`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`id_admin`, `username`, `password`) VALUES
(1, 'superadmin', 'superadmin');

-- --------------------------------------------------------

--
-- Table structure for table `tb_donation`
--

CREATE TABLE `tb_donation` (
  `id_donation` int(11) NOT NULL,
  `donation_name` varchar(100) NOT NULL,
  `donation_desc` varchar(500) NOT NULL,
  `target` int(11) NOT NULL,
  `current_acv` int(11) NOT NULL,
  `status_acceptance` enum('accept','reject','waiting') NOT NULL,
  `clear_status` enum('done','not_done') NOT NULL,
  `id_member` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_donation`
--

INSERT INTO `tb_donation` (`id_donation`, `donation_name`, `donation_desc`, `target`, `current_acv`, `status_acceptance`, `clear_status`, `id_member`) VALUES
(1, 'Bantu Izzul Beli Kawasaki', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore ', 50000000, 0, 'waiting', 'not_done', 1),
(2, 'Bantu Izzul Beli Rumah', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.', 100000000, 0, 'waiting', 'not_done', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_member`
--

CREATE TABLE `tb_member` (
  `id_member` int(11) NOT NULL,
  `member_name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` enum('male','female') NOT NULL,
  `no_telepon` varchar(12) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `ban_status` enum('true','false') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_member`
--

INSERT INTO `tb_member` (`id_member`, `member_name`, `username`, `password`, `gender`, `no_telepon`, `alamat`, `ban_status`) VALUES
(1, 'ilham izzul', 'ilhamizzul', 'ilhamizzul', 'male', '2147483647', 'probolinggo', 'false');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tb_donation`
--
ALTER TABLE `tb_donation`
  ADD PRIMARY KEY (`id_donation`),
  ADD KEY `id_member` (`id_member`);

--
-- Indexes for table `tb_member`
--
ALTER TABLE `tb_member`
  ADD PRIMARY KEY (`id_member`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_donation`
--
ALTER TABLE `tb_donation`
  MODIFY `id_donation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_member`
--
ALTER TABLE `tb_member`
  MODIFY `id_member` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_donation`
--
ALTER TABLE `tb_donation`
  ADD CONSTRAINT `tb_donation_ibfk_1` FOREIGN KEY (`id_member`) REFERENCES `tb_member` (`id_member`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
