-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2020 at 08:13 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_examsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `administration`
--

CREATE TABLE `administration` (
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administration`
--

INSERT INTO `administration` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `c_question`
--

CREATE TABLE `c_question` (
  `Id` int(11) NOT NULL,
  `question` varchar(200) DEFAULT NULL,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `c_question`
--

INSERT INTO `c_question` (`Id`, `question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES
(1, 'How many Bytes are stored by \'Long\' Data type in C# .net?', '8', '4', '2', '1', '8'),
(2, 'Choose \".Net class\" name from which data type \"UInt\" is derived?', 'System.Int16', 'System.UInt32', 'System.UInt64', 'System.UInt16', 'System.UInt32'),
(3, ' Correct Declaration of Values to variables \'a\' and \'b\'?', 'int a = 32, b = 40.6;', 'int a = 42; b = 40;', 'int a = 32; int b = 40;', 'int a = b = 42;', 'int a = 32; int b = 40;'),
(4, 'Arrange the following data type in order of increasing magnitude sbyte, short, long, int.', 'long < short < int < sbyte', 'sbyte < short < int < long', 'short < sbyte < int < long', 'short < int < sbyte < long', 'sbyte < short < int < long'),
(5, 'Which data type should be more preferred for storing a simple number like 35 to improve execution speed of a program?', 'sbyte', 'short', 'int', 'long', 'sbyte'),
(6, 'Correct way to assign values to variable \'c\' when int a=12, float b=3.5, int c;', 'c= a+b;', 'c = a + int(float(b));', 'c = a + convert.ToInt32(b);', 'c = int(a + b);', 'c = a + convert.ToInt32(b);'),
(7, 'Default Type of number without decimal is?', 'Long Int', 'Unsigned Long', 'Int', 'Unsigned Int', 'Int'),
(8, 'Select a convenient declaration and initialization of a floating point number:', 'float somevariable = 12.502D', 'float somevariable = (Double) 12.502D', 'float somevariable = (float) 12.502D', 'float somevariable = (Decimal)12.502D', 'float somevariable = (float) 12.502D'),
(9, 'Number of digits upto which precision value of float data type is valid?', 'Upto 6 digit', 'Upto 8 digit', 'Upto 9 digit', 'Upto 7 digit', 'Upto 7 digit'),
(10, 'Valid Size of float data type is?', '10 Bytes', '6 Bytes', '4 Bytes', '8 Bytes', '4 Bytes');

-- --------------------------------------------------------

--
-- Table structure for table `examinees`
--

CREATE TABLE `examinees` (
  `FirstName` varchar(30) DEFAULT NULL,
  `LastName` varchar(30) DEFAULT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `javascript_question`
--

CREATE TABLE `javascript_question` (
  `Id` int(11) NOT NULL,
  `question` varchar(200) DEFAULT NULL,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `javascript_question`
--

INSERT INTO `javascript_question` (`Id`, `question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES
(1, 'The web development environment (JavaScript) offers which standard construct for data validation of the input entered by the user.', 'Controlled loop constructs', 'Server page access', 'Client side Event', 'Permit server-side', 'Controlled loop constructs'),
(2, 'The main purpose of a \"Live Wire\" in NetScape is to___________', 'Create linkage between client side and server side', 'Permit server side, JavaScript code, to connect to RDBMS', 'Support only non relational database', 'To interpret JavaScript code', 'Permit server side, JavaScript code, to connect to RDBMS'),
(3, 'The script tag must be placed in _________________', 'the head tag', 'the head or body', 'the title or head', 'after the body tag', 'the head or body'),
(4, 'A JavaScript program developed on a Unix Machine ________________', 'will throw errors and exceptions', 'must be restricted to a Unix Machine only', 'will work perfectly well on a Windows Machine', 'will be displayed as a JavaScript text on the browser', 'will work perfectly well on a Windows Machine'),
(5, 'JavaScript is ideal to ______________', 'make computations in HTML simpler', 'minimize storage requirements on the web server', 'increase the download time for the client', 'ncrease the loading time of the website', 'minimize storage requirements on the web server'),
(6, 'Which attribute is used to specify that the script is executed when the page has finished parsing?(only for external scripts)', 'parse', 'a sync', 'defer', 'type', 'defer'),
(7, 'JavaScript Code can be called by using ____________', 'RMI', 'Triggering Event', 'Preprocessor', 'Function/Method', 'Function/Method'),
(8, 'JavaScript can be written _______________', 'directly into JS file and included into HTML', 'directly on the server page', 'directly into HTML pages', 'directly into the css file', 'directly into JS file and included into HTML'),
(9, 'Which of the following Attribute is used to include External JS code inside your HTML Document?', 'script', 'src', 'ext', 'link', 'src'),
(10, 'A proper scripting language is a ____________', 'Assembly level programming language', 'Machine level programming language', 'Low level programming language', 'High level programming language', 'High level programming language');

-- --------------------------------------------------------

--
-- Table structure for table `java_question`
--

CREATE TABLE `java_question` (
  `Id` int(11) NOT NULL,
  `Question` varchar(200) DEFAULT NULL,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `java_question`
--

INSERT INTO `java_question` (`Id`, `Question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES
(2, 'Size of int in Java is?', '16 bit', '32 bit', '64 bit', 'Depends on execution environment', '32 bit'),
(3, 'Size of float and double in Java is?', '32 and 64', '64 and 64', '32 and 32', '64 and 32', '32 and 64'),
(4, 'In Java arrays are', 'objects', 'object references', 'primitive data type', 'none of the above', 'objects'),
(44, 'What is the range of short data type in Java?', '-128 to 127', '-32768 to 32767', '-2147483648 to 2147483647', 'None of the mentioned', '-32768 to 32767'),
(46, 'What is the range of byte data type in Java?', '-128 to 127', '-32768 to 32767', '-2147483648 to 2147483647', 'None of the mentioned', '-128 to 127'),
(47, 'An expression involving byte, int, and literal numbers is promoted to which of these?', 'int', 'long', 'byte', 'float', 'int'),
(48, 'Which data type value is returned by all transcendental math functions?', 'int', 'float', 'double', 'long', 'double'),
(49, 'Which of these can be returned by the operator &?', 'Integer', 'Boolean', 'Character', 'Boolean or Integer', 'Boolean or Integer'),
(50, 'Literals in java must be appended by which of these?', 'L', 'I', 'D', 'L and I', 'L and I'),
(51, 'Which of these can not be used for a variable name in Java?', 'identifier', 'keyword', 'identifier and keyword', 'none', 'keyword');

-- --------------------------------------------------------

--
-- Table structure for table `python_question`
--

CREATE TABLE `python_question` (
  `Id` int(11) NOT NULL,
  `question` varchar(200) DEFAULT NULL,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `python_question`
--

INSERT INTO `python_question` (`Id`, `question`, `option1`, `option2`, `option3`, `option4`, `answer`) VALUES
(1, 'Is Python case sensitive when dealing with identifiers?', 'yes', 'no', 'machine dependent', 'none', 'yes'),
(2, 'What is the maximum possible length of an identifier?', '31 characters', '63 characters', '79 characters', 'none', 'none'),
(3, 'Which of the following is invalid?', '_a=1', '__a = 1', '__str__ = 1', 'none', 'none'),
(4, 'Why are local variable names beginning with an underscore discouraged?', 'they are used to indicate a private variables of a class', 'they confuse the interpreter', 'they are used to indicate global variables', 'they slow down execution', 'they are used to indicate a private variables of a class'),
(5, 'Which of the following is not a keyword?', 'eval', 'assert', 'nonlocal', 'pass', 'eval'),
(6, 'Which of the following is true for variable names in Python?', 'Unlimited length', 'all private members must have leading and trailing underscores', 'underscore and ampersand are the only two special characters allowed', 'none of the mentioned', 'Unlimited length'),
(7, 'Which of these in not a core data type?', 'Lists', 'Dictionary', 'Tuples', 'Class', 'Class'),
(8, 'Which of the following is not a complex number?', 'k = 2 + 3j', 'k = complex(2, 3)', 'k = 2 + 3l', 'k = 2 + 3J', 'k = 2 + 3l'),
(9, 'What is the type of inf?', 'Boolean', 'Integer', 'Float', 'Complex', 'Float'),
(10, 'Which of the following is incorrect?', 'x = 0b101', 'x = 0x4f5', 'x = 19023', 'x = 03964', 'x = 03964');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administration`
--
ALTER TABLE `administration`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `c_question`
--
ALTER TABLE `c_question`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `examinees`
--
ALTER TABLE `examinees`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `javascript_question`
--
ALTER TABLE `javascript_question`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `java_question`
--
ALTER TABLE `java_question`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `python_question`
--
ALTER TABLE `python_question`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `c_question`
--
ALTER TABLE `c_question`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `javascript_question`
--
ALTER TABLE `javascript_question`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `java_question`
--
ALTER TABLE `java_question`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `python_question`
--
ALTER TABLE `python_question`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
