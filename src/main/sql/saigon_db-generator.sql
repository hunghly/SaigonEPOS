-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema saigon_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema saigon_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `saigon_db` DEFAULT CHARACTER SET utf8 ;
USE `saigon_db` ;

-- -----------------------------------------------------
-- Table `saigon_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(75) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`foods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`foods` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `price` DOUBLE NOT NULL,
  `img_url` VARCHAR(255) NULL,
  `users_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `users_id`),
  UNIQUE INDEX `idfoods_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_foods_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_foods_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `saigon_db`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`categories` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `category_UNIQUE` (`category` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`foods_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`foods_categories` (
  `foods_id` INT UNSIGNED NOT NULL,
  `categories_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`foods_id`, `categories_id`),
  INDEX `fk_foods_has_categories_categories1_idx` (`categories_id` ASC),
  INDEX `fk_foods_has_categories_foods1_idx` (`foods_id` ASC),
  CONSTRAINT `fk_foods_has_categories_foods1`
    FOREIGN KEY (`foods_id`)
    REFERENCES `saigon_db`.`foods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foods_has_categories_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `saigon_db`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`foods_categories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`foods_categories` (
  `foods_id` INT UNSIGNED NOT NULL,
  `categories_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`foods_id`, `categories_id`),
  INDEX `fk_foods_has_categories_categories1_idx` (`categories_id` ASC),
  INDEX `fk_foods_has_categories_foods1_idx` (`foods_id` ASC),
  CONSTRAINT `fk_foods_has_categories_foods1`
    FOREIGN KEY (`foods_id`)
    REFERENCES `saigon_db`.`foods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_foods_has_categories_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `saigon_db`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`modifiers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`modifiers` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `modifier` VARCHAR(200) NOT NULL,
  `price_mod` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `modifier_UNIQUE` (`modifier` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saigon_db`.`categories_modifiers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saigon_db`.`categories_modifiers` (
  `categories_id` INT UNSIGNED NOT NULL,
  `modifiers_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`categories_id`, `modifiers_id`),
  INDEX `fk_categories_has_modifiers_modifiers1_idx` (`modifiers_id` ASC),
  INDEX `fk_categories_has_modifiers_categories1_idx` (`categories_id` ASC),
  CONSTRAINT `fk_categories_has_modifiers_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `saigon_db`.`categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categories_has_modifiers_modifiers1`
    FOREIGN KEY (`modifiers_id`)
    REFERENCES `saigon_db`.`modifiers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
