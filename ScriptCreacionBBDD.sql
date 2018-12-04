CREATE DATABASE  IF NOT EXISTS `proyectoenciclopedia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `proyectoenciclopedia`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectoenciclopedia
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comentarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idPersonaje` int(11) NOT NULL,
  `comentario` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `directorios`
--

DROP TABLE IF EXISTS `directorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `directorios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `annoInicio` varchar(255) DEFAULT NULL,
  `annoFin` varchar(255) DEFAULT NULL,
  `descripcion` text,
  `fechaCreacion` timestamp NOT NULL,
  `idCreador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_directorios_usuarios_idCreador_idx` (`idCreador`),
  CONSTRAINT `FK_directorios_usuarios_idCreador` FOREIGN KEY (`idCreador`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edicionesdirectorios`
--

DROP TABLE IF EXISTS `edicionesdirectorios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edicionesdirectorios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idDirectorio` int(11) NOT NULL,
  `idEditor` int(11) NOT NULL,
  `fechaEdicion` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_edicionesdirectorios_directorios_idDirectorio_idx` (`idDirectorio`),
  KEY `FK_edicionesdirectorios_usuarios_idEditor_idx` (`idEditor`),
  CONSTRAINT `FK_edicionesdirectorios_directorios_idDirectorio` FOREIGN KEY (`idDirectorio`) REFERENCES `directorios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_edicionesdirectorios_usuarios_idEditor` FOREIGN KEY (`idEditor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `edicionespersonajes`
--

DROP TABLE IF EXISTS `edicionespersonajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edicionespersonajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPersonaje` int(11) NOT NULL,
  `idEditor` int(11) NOT NULL,
  `fechaEdicion` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_edicionespersonajes_personajes_idPersonaje_idx` (`idPersonaje`),
  KEY `FK_edicionespersonajes_usuarios_idEditor_idx` (`idEditor`),
  CONSTRAINT `FK_edicionespersonajes_personajes_idPersonaje` FOREIGN KEY (`idPersonaje`) REFERENCES `personajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_edicionespersonajes_usuarios_idEditor` FOREIGN KEY (`idEditor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `annoNacimiento` varchar(255) DEFAULT NULL,
  `annoMuerte` varchar(255) DEFAULT NULL,
  `biografia` text,
  `idDirectorio` int(11) NOT NULL,
  `fechaCreacion` timestamp NOT NULL,
  `idCreador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_personajes_usuarios_idCreador_idx` (`idCreador`),
  KEY `FK_personajes_directorios_idDirectorio_idx` (`idDirectorio`),
  CONSTRAINT `FK_personajes_directorios_idDirectorio` FOREIGN KEY (`idDirectorio`) REFERENCES `directorios` (`id`),
  CONSTRAINT `FK_personajes_usuarios_idCreador` FOREIGN KEY (`idCreador`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tiposusuario`
--

DROP TABLE IF EXISTS `tiposusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tiposusuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) NOT NULL,
  `contrasenna` varchar(45) NOT NULL,
  `tipoUsuarioId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
  KEY `FK_usuarios_tiposusuario_tipoUsuarioId_idx` (`tipoUsuarioId`),
  CONSTRAINT `FK_usuarios_tiposusuario_tipoUsuarioId` FOREIGN KEY (`tipoUsuarioId`) REFERENCES `tiposusuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-04 19:43:25
