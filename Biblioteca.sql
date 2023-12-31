-- MySQL Script generated by MySQL Workbench
-- Fri Oct 27 00:17:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Biblioteca` ;

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `Biblioteca` ;

-- -----------------------------------------------------
-- Table `Biblioteca`.`Autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Autor` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Autor` (
  `idAutor` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutor`),
  UNIQUE INDEX `idAutor_UNIQUE` (`idAutor` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Categoria` (
  `idCategoria` VARCHAR(10) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE INDEX `idCategoria_UNIQUE` (`idCategoria` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Editorial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Editorial` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Editorial` (
  `idEditorial` VARCHAR(10) NOT NULL,
  `nombreEditorial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEditorial`),
  UNIQUE INDEX `idEditorial_UNIQUE` (`idEditorial` ASC) INVISIBLE,
  UNIQUE INDEX `nombreEditorial_UNIQUE` (`nombreEditorial` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Libro` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Libro` (
  `idLibro` VARCHAR(10) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `fechaLanzamiento` VARCHAR(45) NOT NULL,
  `idioma` VARCHAR(45) NOT NULL,
  `paginas` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `vinculo` VARCHAR(100) NOT NULL,
  `Editorial_idEditorial` VARCHAR(10) NOT NULL,
  `Categoria_idCategoria` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idLibro`, `Editorial_idEditorial`, `Categoria_idCategoria`),
  INDEX `fk_Libro_Editorial1_idx` (`Editorial_idEditorial` ASC) VISIBLE,
  INDEX `fk_Libro_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  UNIQUE INDEX `idLibro_UNIQUE` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_Editorial1`
    FOREIGN KEY (`Editorial_idEditorial`)
    REFERENCES `Biblioteca`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `Biblioteca`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Cuenta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Cuenta` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Cuenta` (
  `usuario` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`usuario`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Profesor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Profesor` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Profesor` (
  `idProfesor` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `Cuenta_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfesor`, `Cuenta_usuario`),
  INDEX `fk_Profesor_Cuenta1_idx` (`Cuenta_usuario` ASC) VISIBLE,
  UNIQUE INDEX `idProfesor_UNIQUE` (`idProfesor` ASC) VISIBLE,
  CONSTRAINT `fk_Profesor_Cuenta1`
    FOREIGN KEY (`Cuenta_usuario`)
    REFERENCES `Biblioteca`.`Cuenta` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`CursoCargo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`CursoCargo` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`CursoCargo` (
  `clave` VARCHAR(10) NOT NULL,
  `cursoCargo` VARCHAR(45) NOT NULL,
  `cicloEscolar` VARCHAR(45) NOT NULL,
  `Profesor_idProfesor` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`clave`, `Profesor_idProfesor`),
  INDEX `fk_CursoCargo_Profesor_idx` (`Profesor_idProfesor` ASC) VISIBLE,
  UNIQUE INDEX `clave_UNIQUE` (`clave` ASC) VISIBLE,
  CONSTRAINT `fk_CursoCargo_Profesor`
    FOREIGN KEY (`Profesor_idProfesor`)
    REFERENCES `Biblioteca`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Alumno` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Alumno` (
  `idAlumno` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `CursoCargo_clave` VARCHAR(10) NOT NULL,
  `Cuenta_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAlumno`, `CursoCargo_clave`, `Cuenta_usuario`),
  INDEX `fk_Alumno_CursoCargo1_idx` (`CursoCargo_clave` ASC) VISIBLE,
  INDEX `fk_Alumno_Cuenta1_idx` (`Cuenta_usuario` ASC) VISIBLE,
  UNIQUE INDEX `idAlumno_UNIQUE` (`idAlumno` ASC) VISIBLE,
  CONSTRAINT `fk_Alumno_CursoCargo1`
    FOREIGN KEY (`CursoCargo_clave`)
    REFERENCES `Biblioteca`.`CursoCargo` (`clave`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_Cuenta1`
    FOREIGN KEY (`Cuenta_usuario`)
    REFERENCES `Biblioteca`.`Cuenta` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Lectura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Lectura` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Lectura` (
  `idLectura` VARCHAR(10) NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  `Libro_idLibro` VARCHAR(10) NOT NULL,
  `Alumno_idAlumno` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idLectura`, `Libro_idLibro`, `Alumno_idAlumno`),
  INDEX `fk_Lectura_Libro1_idx` (`Libro_idLibro` ASC) VISIBLE,
  INDEX `fk_Lectura_Alumno1_idx` (`Alumno_idAlumno` ASC) VISIBLE,
  UNIQUE INDEX `idLectura_UNIQUE` (`idLectura` ASC) VISIBLE,
  CONSTRAINT `fk_Lectura_Libro1`
    FOREIGN KEY (`Libro_idLibro`)
    REFERENCES `Biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lectura_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno`)
    REFERENCES `Biblioteca`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`Autor_has_Libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Biblioteca`.`Autor_has_Libro` ;

CREATE TABLE IF NOT EXISTS `Biblioteca`.`Autor_has_Libro` (
  `Autor_idAutor` VARCHAR(10) NOT NULL,
  `Libro_idLibro` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Autor_idAutor`, `Libro_idLibro`),
  INDEX `fk_Autor_has_Libro_Libro1_idx` (`Libro_idLibro` ASC) VISIBLE,
  INDEX `fk_Autor_has_Libro_Autor1_idx` (`Autor_idAutor` ASC) VISIBLE,
  CONSTRAINT `fk_Autor_has_Libro_Autor1`
    FOREIGN KEY (`Autor_idAutor`)
    REFERENCES `Biblioteca`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Autor_has_Libro_Libro1`
    FOREIGN KEY (`Libro_idLibro`)
    REFERENCES `Biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
