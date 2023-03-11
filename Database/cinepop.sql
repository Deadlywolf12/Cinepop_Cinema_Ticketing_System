-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2023 at 11:49 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinepop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `adName` varchar(256) NOT NULL,
  `adEmail` varchar(256) NOT NULL,
  `adPassword` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `adName`, `adEmail`, `adPassword`) VALUES
(1, 'Rushan', 'admin@', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `card_payment_info`
--

CREATE TABLE `card_payment_info` (
  `ticket_id` varchar(256) NOT NULL,
  `card_title` varchar(256) NOT NULL,
  `card_num` int(11) NOT NULL,
  `card_cvc` int(11) NOT NULL,
  `card_type` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `1A` int(11) NOT NULL,
  `1B` int(11) NOT NULL,
  `1C` int(11) NOT NULL,
  `2A` int(11) NOT NULL,
  `2B` int(11) NOT NULL,
  `2C` int(11) NOT NULL,
  `3A` int(11) NOT NULL,
  `3B` int(11) NOT NULL,
  `3C` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `name`, `date`, `time`, `1A`, `1B`, `1C`, `2A`, `2B`, `2C`, `3A`, `3B`, `3C`) VALUES
(25, 'Harry Potter The Half Blood Prince', '2023-05-02', '08:00:00', 0, 0, 0, 1, 1, 1, 1, 1, 1),
(27, 'James Bond No Time To Die', '2023-05-02', '08:00:00', 0, 0, 0, 1, 1, 1, 1, 1, 1),
(32, 'fantastic beasts', '2023-05-02', '08:00:00', 0, 0, 0, 0, 1, 1, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` varchar(256) NOT NULL,
  `movie` varchar(256) NOT NULL,
  `time` time NOT NULL,
  `date` date NOT NULL,
  `seats` varchar(256) NOT NULL,
  `amountPaid` int(11) NOT NULL,
  `medium` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `purDate` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `movie`, `time`, `date`, `seats`, `amountPaid`, `medium`, `email`, `purDate`) VALUES
('1Mk257HYRw', 'Harry Potter The Half Blood Prince', '08:00:00', '2023-05-02', '  3A 3B', 600, 'Wallet', 'jason3@gmail.com', 'Fri Mar 10 04:25:35 PST 2023'),
('2EBRG0At5g', 'James Bond No Time To Die', '08:00:00', '2023-05-02', '  2B 2C', 600, 'Wallet', 'deadlywolf12@gmail.com', 'Sat Mar 11 02:40:26 PST 2023'),
('CiFGHPoVf8', 'James Bond No Time To Die', '08:00:00', '2023-05-02', '  3A', 300, 'Wallet', 'jason3@gmail.com', 'Fri Mar 10 07:48:26 PST 2023'),
('h068y55bTZ', 'Harry Potter The Half Blood Prince', '08:00:00', '2023-05-02', '  2A 2B', 600, 'Wallet', 'jason3@gmail.com', 'Fri Mar 10 08:22:22 PST 2023'),
('teimH8rMsW', 'James Bond No Time To Die', '08:00:00', '2023-05-02', '  2A', 300, 'Wallet', 'jason3@gmail.com', 'Fri Mar 10 08:39:15 PST 2023'),
('W0iNv9KTk1', 'Harry Potter The Half Blood Prince', '08:00:00', '2023-05-02', '  3C 2C', 600, 'Wallet', 'deadlywolf@gmail.com', 'Sat Mar 11 02:25:28 PST 2023'),
('Z4FHny1fcb', 'James Bond No Time To Die', '08:00:00', '2023-05-02', '  3B 3C', 600, 'Wallet', 'null', 'Sat Mar 11 01:57:38 PST 2023');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `balance` int(11) DEFAULT 600
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `balance`) VALUES
(22, 'jason', 'jason3@gmail.com', 'itsjason1234', 1069),
(29, 'deadly', 'deadlywolf@gmail.com', '123123123123', 100),
(30, 'deadly12', 'deadlywolf1@gmail.com', '123123123123', 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `adEmail` (`adEmail`);

--
-- Indexes for table `card_payment_info`
--
ALTER TABLE `card_payment_info`
  ADD UNIQUE KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `card_payment_info`
--
ALTER TABLE `card_payment_info`
  ADD CONSTRAINT `test` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
