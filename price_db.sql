-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 20 2015 г., 06:54
-- Версия сервера: 5.6.21
-- Версия PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `price_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cat`
--

CREATE TABLE IF NOT EXISTS `cat` (
`id` int(11) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cat`
--

INSERT INTO `cat` (`id`, `NAME`) VALUES
(1, 'принтеры'),
(2, 'факсы'),
(3, 'компьютеры'),
(4, 'картриджи');

-- --------------------------------------------------------

--
-- Структура таблицы `prod`
--

CREATE TABLE IF NOT EXISTS `prod` (
`id` int(11) NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `price` float(16,2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `prod`
--

INSERT INTO `prod` (`id`, `cat_id`, `NAME`, `price`) VALUES
(1, 1, 'принтер Epson L800', 11670.50),
(2, 1, 'принтер Epson L200', 8890.50),
(3, 1, 'принтер Canon PIXMA MG3540', 3090.20),
(4, 1, 'принтер Canon PIXMA MG2440', 1817.00),
(5, 2, 'факс Philips Laserfax 5125', 7400.80),
(6, 2, 'факс Panasonic KX - FLC418 RU', 12500.60),
(7, 2, 'факс Panasonic KX - FP207RU', 5200.10),
(8, 2, 'Факс Panasonic KX - FL423RU Black', 11590.10),
(9, 3, 'Моноблок ASUS ET2322INTH - B001R', 62000.10),
(10, 3, 'Моноблок ASUS ET2321IUKH - B004R', 45500.10),
(11, 3, 'Моноблок ASUS ET2321INTH - B020R', 75000.00),
(12, 4, 'Картридж Epson T1706 комплект (BK-C- M - Y)', 3200.80),
(13, 4, 'Картридж для принтера HP 121b', 2500.90),
(14, 4, 'Картридж Uniton ТК - 130', 850.00);

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `prodwithcat`
--
CREATE TABLE IF NOT EXISTS `prodwithcat` (
`id` int(11)
,`catName` varchar(255)
,`name` varchar(255)
,`price` float(16,2)
);
-- --------------------------------------------------------

--
-- Структура для представления `prodwithcat`
--
DROP TABLE IF EXISTS `prodwithcat`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `prodwithcat` AS select `prod`.`id` AS `id`,`cat`.`NAME` AS `catName`,`prod`.`NAME` AS `name`,`prod`.`price` AS `price` from (`prod` join `cat` on((`prod`.`cat_id` = `cat`.`id`)));

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cat`
--
ALTER TABLE `cat`
 ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `prod`
--
ALTER TABLE `prod`
 ADD PRIMARY KEY (`id`), ADD KEY `cat_id` (`cat_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cat`
--
ALTER TABLE `cat`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `prod`
--
ALTER TABLE `prod`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `prod`
--
ALTER TABLE `prod`
ADD CONSTRAINT `prod_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `cat` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
