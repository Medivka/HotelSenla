CREATE DATABASE senlahotel;

CREATE TABLE `senlahotel`.`guests` (
  `guestNumber` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `guestGender` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`guestNumber`));


CREATE TABLE `senlahotel`.`services` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `senlahotel`.`rooms` (
  `roomNumber` INT NOT NULL,
  `roomStatus` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL,
  `stars` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`roomNumber`));

INSERT INTO `senlahotel`.`services` (`id`, `name`, `price`) VALUES ('1', 'TV', '600');
INSERT INTO `senlahotel`.`services` (`id`, `name`, `price`) VALUES ('2', 'Dinner', '100');
INSERT INTO `senlahotel`.`services` (`id`, `name`, `price`) VALUES ('3', 'BreakFast', '150');
INSERT INTO `senlahotel`.`services` (`id`, `name`, `price`) VALUES ('4', 'Hot Water', '300');
INSERT INTO `senlahotel`.`services` (`id`, `name`, `price`) VALUES ('5', '18+', '500');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('1', 'Vika', 'Poroshenko', '23', '801 66 66', 'FEMALE', 'poroshenko@mail.ru', 'Moscow');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('2', 'Masha', 'Malinovskaia', '34', '222 22 22', 'FEMALE', 'malinovskakis@rambler.ru', 'Brest');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('3', 'Mila', 'Kunis', '22', '333 33 33', 'FEMALE', 'kunis@gmail.ru', 'Gomel');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('4', 'Vasia', 'Pokrov', '35', '444 44 44', 'MALE', 'pokrov@yahoo.com', 'Minsk');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('5', 'Alexandr', 'Niberman', '45', '555 55 55', 'MALE', 'niberman@git.ua', 'Orsha');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('6', 'Mike', 'Kivsov', '27', '666 66 66', 'MALE', 'kirisov@mail.ru', 'Kursk');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('7', 'Tom', 'Hardy', '22', '777 77 77', 'MALE', 'hardy@gmail.com', 'Omsk');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('8', 'Bred', 'Pitt', '50', '888 88 88', 'MALE', 'pitt@awrds.en', 'Grodno');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('9', 'Natasha', 'Romanova', '35', '999 99 99', 'FEMALE', 'romanova@yandex.ru', 'Vitebsk');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('10', 'Kira', 'Naightly', '23', '123 45 67', 'FEMALE', 'naightly@yandex.ru', 'Alushta');
INSERT INTO `senlahotel`.`guests` (`guestNumber`, `name`, `lastName`, `age`, `phone`, `guestGender`, `email`, `address`) VALUES ('11', 'Vera', 'Brezhneva', '60', '891 23 45', 'FEMALE', 'brezhneva@mail.ru', 'Orel');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('1', 'FREE', '2', '4', '2000');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('2', 'BUSY', '3', '5', '1000');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('3', 'BUSY', '4', '3', '1500');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('4', 'REPAIRS', '5', '4', '1300');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('5', 'FREE', '2', '3', '1400');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('6', 'FREE', '3', '5', '1750');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('7', 'REPAIRS', '4', '3', '1680');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('8', 'FREE', '5', '5', '1350');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('9', 'BUSY', '2', '3', '1400');
INSERT INTO `senlahotel`.`rooms` (`roomNumber`, `roomStatus`, `capacity`, `stars`, `price`) VALUES ('10', 'FREE', '3', '5', '1100');