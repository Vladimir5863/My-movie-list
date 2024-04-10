-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2024 at 09:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id_filma` int(15) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `trajanje` int(11) NOT NULL,
  `zanr` varchar(20) NOT NULL,
  `direktor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id_filma`, `naziv`, `trajanje`, `zanr`, `direktor`) VALUES
(1, 'The Shawshank Redemption', 144, 'Drama', 'Frank Darabont'),
(2, 'The Godfather', 175, 'Krimi', 'Francis Ford Coppola'),
(3, 'The Dark Knight', 152, 'Super hejoski', 'Christopher Nolan'),
(4, 'The Godfather Part II', 202, 'Krimi', 'Francis Ford Coppola'),
(5, '12 Angry Men', 96, 'Drama', 'Sidney Lumet'),
(6, 'Schindler\'s List', 195, 'Istorijska drama', 'Steven Spielberg'),
(7, 'The Lord of the Rings: The Return of the King', 201, 'Fantastika', 'Peter Jackson'),
(8, 'The Good, the Bad and the Ugly', 178, 'Vestern', 'Sergio Leone'),
(9, 'Forrest Gump', 144, 'Drama', 'Robert Zemeckis'),
(10, 'Fight Club', 139, 'Psiholoski triler', 'David Fincher'),
(11, 'The Lord of the Rings: The Two Towers', 179, 'Fantastika', 'Peter Jackson'),
(12, 'Inception', 148, 'Akcija', 'Christopher Nolan'),
(13, 'Star Wars: Episode V - The Empire Strikes Back', 124, 'Sci-Fi', 'Irvin Kershner'),
(14, 'The Matrix', 136, 'Sci-Fi', 'Lana Wachowski\r\nLilly Wachowski'),
(15, 'Gladiator', 155, 'Istorijska drama', 'Ridley Scott'),
(16, 'Saving Private Ryan', 169, 'Ratni', 'Steven Spielberg'),
(17, 'Cidade de Deus', 130, 'Krimi', 'Fernando Meirelles\r\nKátia Lund'),
(18, 'Star Wars: Episode IV – A New Hope', 121, 'Sci-Fi', 'George Lucas'),
(19, 'Terminator 2: Judgment Day', 137, 'Sci-Fi', 'James Cameron'),
(20, 'The Green Mile', 189, 'Drama', 'Frank Darabont'),
(21, 'Parasite', 132, 'Triler', 'Bong Joon Ho'),
(22, 'Once Upon a Time in the West ', 146, 'Vestern', 'Sergio Leone'),
(23, 'The Gods Must Be Crazy', 109, 'Komedija', 'Jamie Uys'),
(24, 'Harakiri', 133, 'Istorijska drama', 'Masaki Kobayashi'),
(25, '12th Fail', 147, 'Drama', 'Vidhu Vinod Chopra'),
(26, 'The Lord of the Rings: The Fellowship of the Ring', 178, 'Fantastika', 'Peter Jackson'),
(27, 'Casablanca', 102, 'Romansa', 'Michael Curtiz'),
(28, 'Oppenheimer', 180, 'Triler', 'Christopher Nolan'),
(29, 'Joker', 122, 'Psiholoski triler', 'Todd Phillips'),
(30, 'Avengers: Endgame', 181, 'Sci-Fi', 'Anthony Russo\r\nJoe Russo'),
(31, 'Avengers: Infinity War', 149, 'Sci-Fi', 'Joe Russo\r\nAnthony Russo'),
(32, 'Your Name', 106, 'Romansa', 'Makoto Shinkai'),
(33, 'Heat', 170, 'Krimi', 'Michael Mann'),
(34, 'М', 117, 'Triler', 'Fritz Lang'),
(35, 'The Great Dictator', 125, 'Komedija', 'Charles Chaplin');

-- --------------------------------------------------------

--
-- Table structure for table `gledanje`
--

CREATE TABLE `gledanje` (
  `id_gledanja` int(11) NOT NULL,
  `id_korisnika` int(11) NOT NULL,
  `id_filma` int(11) NOT NULL,
  `ocena` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gledanje`
--

INSERT INTO `gledanje` (`id_gledanja`, `id_korisnika`, `id_filma`, `ocena`, `status`) VALUES
(5, 8, 7, 8, 'Odgledao'),
(6, 8, 11, 8, 'Odgledao'),
(7, 8, 1, 10, 'Dropovao'),
(8, 8, 6, NULL, NULL),
(9, 8, 13, 5, 'Odgledao'),
(10, 9, 3, NULL, NULL),
(11, 9, 18, NULL, NULL),
(12, 9, 33, NULL, NULL),
(14, 12, 12, NULL, NULL),
(15, 12, 2, NULL, NULL),
(16, 12, 18, NULL, NULL),
(17, 10, 12, NULL, NULL),
(18, 10, 33, NULL, NULL),
(19, 10, 10, NULL, NULL),
(20, 10, 3, NULL, NULL),
(21, 10, 3, NULL, NULL),
(22, 10, 3, NULL, NULL),
(23, 10, 16, NULL, NULL),
(24, 10, 9, NULL, NULL),
(25, 8, 9, 5, 'Odgledao'),
(26, 13, 13, 4, 'Dropovao'),
(27, 13, 6, 6, 'Planiram da gledam'),
(28, 8, 14, 8, 'Gledam'),
(29, 8, 10, 5, 'Odgledao'),
(32, 8, 29, 10, 'Odgledao'),
(34, 8, 35, 7, 'Gledam');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id_korisnika` int(11) NOT NULL,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `godina_rodjenja` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id_korisnika`, `ime`, `prezime`, `godina_rodjenja`, `username`, `password`) VALUES
(1, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(2, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(3, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(4, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(5, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(6, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(7, 'Nikola', 'Nikolic', 2006, 'nikola123', 'sifra123'),
(8, 'Vladimir', 'Nikolic', 2002, 'vladanikolic', 'sifra'),
(9, 'Vladimir', 'Nikolic', 2006, 'vladanikolic123', 'sifra'),
(10, 'Marko', 'Markovic', 2004, 'mare12', 'marko123'),
(11, 'Janko', 'Jankovic', 1996, 'jankijan', 'jankovic'),
(12, 'Jovana', 'Tomic', 1998, 'jovanki98', 'tomicka'),
(13, 'Masa', 'Masovic', 2000, 'maske12', 'masa567'),
(14, 'Misko', 'Milosevic', 2003, 'miskomil', 'miloje'),
(15, 'Misko', 'Milosevic', 2003, 'miskomi', 'miloje'),
(16, 'johan', 'smith', 2000, 'john', 'sifra'),
(17, 'Marko', 'Nikolic', 2003, 'marki49', 'sifra'),
(18, 'Jovana', 'Jovanovic', 2003, 'jovano', 'jovanki');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id_filma`);

--
-- Indexes for table `gledanje`
--
ALTER TABLE `gledanje`
  ADD PRIMARY KEY (`id_gledanja`),
  ADD KEY `kljuc1` (`id_filma`),
  ADD KEY `kljuc2` (`id_korisnika`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id_korisnika`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id_filma` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `gledanje`
--
ALTER TABLE `gledanje`
  MODIFY `id_gledanja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id_korisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gledanje`
--
ALTER TABLE `gledanje`
  ADD CONSTRAINT `kljuc1` FOREIGN KEY (`id_filma`) REFERENCES `film` (`id_filma`),
  ADD CONSTRAINT `kljuc2` FOREIGN KEY (`id_korisnika`) REFERENCES `korisnik` (`id_korisnika`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
