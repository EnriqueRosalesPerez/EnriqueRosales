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
-- Table structure for table `afiliaciones`
--

DROP TABLE IF EXISTS `afiliaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `afiliaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text,
  `idDirectorio` int(11) NOT NULL,
  `idCreador` int(11) NOT NULL,
  `fechaCreacion` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_afiliaciones_directorios_idDirectorio_idx` (`idDirectorio`),
  KEY `FK_afiliaciones_usuarios_idCreador_idx` (`idCreador`),
  CONSTRAINT `FK_afiliaciones_directorios_idDirectorio` FOREIGN KEY (`idDirectorio`) REFERENCES `directorios` (`id`),
  CONSTRAINT `FK_afiliaciones_usuarios_idCreador` FOREIGN KEY (`idCreador`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliaciones`
--

LOCK TABLES `afiliaciones` WRITE;
/*!40000 ALTER TABLE `afiliaciones` DISABLE KEYS */;
INSERT INTO `afiliaciones` VALUES (9,'Reino de Wei','El Reino de Wei (chino tradicional y simplificado: 曹魏; Wade-Giles: Ts\'ao2 Wei4) fue una dinastía china perteneciente al periodo de los Tres Reinos (184-283 d. C.). La dinastía Wei fue fundada por Cao Pi, y su padre, Cao Cao tuvo enorme importancia en la fundación. \r\n\r\nEn el año 191 d. C., tras la victoria de las fuerzas aliadas contra Dong Zhuo en la batalla de la puerta de Hu Lao, comienza la carrera de Cao Cao por reunificar China. En el año 200 d. C. Cao Cao ya controlaba la llanura central de China y se había convertido en una fuerza digna de tenerse en cuenta. En los ocho años que siguieron conquistó todo el norte, la provincia de Ji, convirtiéndose en la fuerza dominante en China. Con el tiempo su territorio llegó a abarcar todo el norte del país, delimitando al sur con Hanzhong, gran parte de la provincia de Jing y el río Changjiang.\r\n\r\nCao Cao murió en el año 220, y su puesto lo ocupó su segundo hijo Cao Pi (su primer hijo, Cao Ang, murió asesinado en el año 197). En el año 220 d. C. Cao Pi fundó el reino de Wei y destronó al emperador Xian, terminando así definitivamente con la dinastía Han y proclamándose él mismo emperador de Wei. ',71,28,'2018-12-18 14:27:05'),(10,'La Unión','Durante la guerra civil estadounidense, la Unión fue el término utilizado para referirse al bando formado por los estados del norte durante la Guerra de Secesión, y específicamente al gobierno nacional del presidente Abraham Lincoln, conformado por los 20 estados libres partidarios de abolir la esclavitud y 5 estados esclavistas fronterizos que lo apoyaban. La Unión fue opuesta por 11 estados esclavistas del sur que habían declarado una secesión a unirse entre sí para formar la Confederación.\r\n\r\nA menudo a la Unión también se le denomina como «el Norte», tanto entonces como ahora, en contraposición al otro nombre de la Confederación, «el Sur». La Unión nunca reconoció la legitimidad de la secesión y en todo momento sostuvo que comprendía la totalidad de los Estados Unidos de América. En asuntos exteriores fue reconocida por todas las demás naciones como el Gobierno legítimo del país. ',73,28,'2018-12-18 14:32:39'),(11,'Estados Confederados','Los Estados Confederados de América (en inglés, Confederate States of America o C.S.A.), también llamados La Confederación y Estados Confederados, fue un país formado por los once estados meridionales que se separaron de los Estados Unidos de América entre 1861 y 1865. Como su existencia nunca fue reconocida en el plano internacional, su frontera septentrional es incierta, pero al este limitaba con el océano Atlántico y al sur tenía frontera con México y el golfo homónimo. El gobierno confederado reclamaba un territorio de 1 995 392 km² y una población de 9 103 332 de habitantes, de los cuales 3 521 110 eran esclavos, según censo de 1860.1​\r\n\r\nSiete estados declararon su independencia de los Estados Unidos antes de que Abraham Lincoln fuera proclamado presidente, cuatro más hicieron lo mismo después de que la Guerra Civil de los Estados Unidos comenzara con la batalla de Fort Sumter. El gobierno de los Estados Unidos de América («la Unión») sostuvo que la secesión era ilegal y se negaron a reconocer a la Confederación. La mayoría de los gobiernos europeos no reconocieron oficialmente esta Confederación, solo le dieron reconocimiento los Estados Pontificios en una carta enviada a Jefferson Davis por el papa Pio IX y el Reino Unido de Gran Bretaña e Irlanda que le vendió buques de guerra y los abasteció de suministros por intereses comerciales.\r\n\r\nCuando Robert E. Lee y otros generales confederados se rindieron en la primavera de 1865, la Confederación se derrumbó, finalizando la guerra sin una posterior guerra de guerrillas. A continuación, se produjo un proceso, bautizado como la Reconstrucción, que duró más de una década, y que dotó a los esclavos liberados de derechos civiles y derecho al voto, expulsando a los líderes de la derrotada Confederación de sus cargos, y readmitiendo a los estados su representación en el Congreso de forma permanente. ',73,28,'2018-12-18 14:33:19');
/*!40000 ALTER TABLE `afiliaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afiliaciones_personajes`
--

DROP TABLE IF EXISTS `afiliaciones_personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `afiliaciones_personajes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAfiliacion` int(11) NOT NULL,
  `idPersonaje` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_afiliaciones_personajes_afiliaciones_idAfiliacion_idx` (`idAfiliacion`),
  KEY `FK_afiliaciones_personajes_personajes_idPersonaje_idx` (`idPersonaje`),
  CONSTRAINT `FK_afiliaciones_personajes_afiliaciones_idAfiliacion` FOREIGN KEY (`idAfiliacion`) REFERENCES `afiliaciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_afiliaciones_personajes_personajes_idPersonaje` FOREIGN KEY (`idPersonaje`) REFERENCES `personajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliaciones_personajes`
--

LOCK TABLES `afiliaciones_personajes` WRITE;
/*!40000 ALTER TABLE `afiliaciones_personajes` DISABLE KEYS */;
INSERT INTO `afiliaciones_personajes` VALUES (8,9,37),(9,11,38),(10,10,39);
/*!40000 ALTER TABLE `afiliaciones_personajes` ENABLE KEYS */;
UNLOCK TABLES;

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
  `fechaPublicacion` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comentarios_usuarios_idUsuario_idx` (`idUsuario`),
  KEY `FK_comentarios_personajes_idPersonaje_idx` (`idPersonaje`),
  CONSTRAINT `FK_comentarios_personajes_idPersonaje` FOREIGN KEY (`idPersonaje`) REFERENCES `personajes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_comentarios_usuarios_idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (26,28,37,'Muy chulo','2018-12-18 14:29:04'),(27,29,37,'Estoy de acuerdo','2018-12-18 14:30:05');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directorios`
--

LOCK TABLES `directorios` WRITE;
/*!40000 ALTER TABLE `directorios` DISABLE KEYS */;
INSERT INTO `directorios` VALUES (71,'Tres Reinos','220 d.C.','280 d.C.','Los Tres Reinos (chino tradicional, 三國 Sānguó) es un periodo de la historia de China. En un estricto sentido académico se refiere al periodo comprendido entre la fundación de Wei en el 220 y la conquista de los Wu por la dinastía Jin en el 280. Sin embargo, muchos historiadores chinos amplían el punto del comienzo de este periodo a la rebelión de los turbantes amarillos en el 184. \r\n\r\nLa temprana y \"no oficial\" parte del periodo, comprendida desde 190 al 220, estuvo marcada por las caóticas luchas internas entre los señores de la guerra en varias partes de China. La parte media del periodo, del 220 al 263, estuvo marcada por el militarmente más estable acuerdo entre los tres estados rivales, Wei (魏), Shu (蜀), y Wu (吳).\r\n\r\nPara distinguir a estos estados de los antiguos estados del mismo nombre, los historiadores los precedieron de un carácter: Wei es también conocido como Cao Wei, Han es conocido como Shu Han, que posteriormente pasó solamente a ser conocido como Shu, y Wu es también conocido como Wu oriental.\r\n\r\nLa última parte de este periodo estuvo marcada por la destrucción de Shu por parte de Wei en el 263, el derrocamiento de Wei por la dinastía Jin en el 265 y la destrucción de Wu por Jin en el 280.\r\n\r\nEl término \"Tres Reinos\" es una traducción inexacta, puesto que cada estado estuvo eventualmente gobernado por un emperador que reclamaba su legítimo derecho de sucesión a la dinastía Han y no por reyes. Sin embargo, esta denominación se ha convertido en estándar entre los sinólogos.\r\n\r\nEste periodo histórico ha sido en gran manera visto de forma romántica en las culturas de China, Japón y Corea y a lo largo del sureste asiático. Ha sido celebrado y popularizado en óperas, cuentos tradicionales, novelas, y en tiempos más recientes, películas, series de televisión y videojuegos. El más conocido de todos, es sin duda, el Romance de los Tres Reinos, una recreación ficticia de este periodo con un profundo trasfondo histórico. El registro histórico autorizado de la era es Sanguo Zhi de Chen Shou, junto con las anotaciones posteriores de Pei Songzhi sobre el texto.\r\n\r\nEl periodo de los Tres Reinos es uno de los más sangrientos en la historia de China. Un censo de la población a finales de la dinastía Han oriental calculaba una población de aproximadamente 56 millones, mientras otro censo posterior reporta aproximadamente 16 millones, teniendo en cuenta las imprecisiones de los registros censales de la época, es seguro asumir que un amplio porcentaje de la población fue exterminada durante las constantes guerras que se desataron durante el periodo. ','2018-12-18 14:26:10',28),(73,'Guerra Civil Americana','12 de abril de 1861','9 de abril de 1865','La guerra de Secesión o guerra civil estadounidense (en inglés American Civil War o simplemente Civil War en los Estados Unidos) fue una guerra (aunque el Congreso nunca emitió una Declaración de Guerra) librada en los Estados Unidos desde 1861 hasta 1865. Como resultado de la controversia histórica sobre la esclavitud, la guerra estalló en abril de 1861, cuando las fuerzas de los Estados Confederados de América atacaron Fort Sumter en Carolina del Sur, poco después de que el presidente Abraham Lincoln asumiera su cargo. Los nacionalistas de la Unión proclamaron lealtad a la Constitución de los Estados Unidos. Se enfrentaron a secesionistas de los Estados Confederados, que defendían los derechos de los estados a expandir la esclavitud.\r\n\r\nEntre los 34 estados de EE. UU. en febrero de 1861, siete estados esclavistas del sur individualmente declararon su secesión de los Estados Unidos para formar los Estados Confederados de América, o el Sur. La Confederación creció para incluir once estados esclavistas. La Confederación nunca fue diplomáticamente reconocida por el Gobierno de los Estados Unidos, ni fue reconocida por ningún país extranjero (aunque el Reino Unido y Francia le otorgaron estatus beligerante). Los estados que permanecieron leales a los EE. UU. (incluidos los estados fronterizos donde la esclavitud era legal) se conocían como la Unión o el Norte.\r\n\r\nLa Unión y la Confederación rápidamente levantaron ejércitos voluntarios y conscriptos que lucharon principalmente en el Sur a lo largo de cuatro años. La Unión finalmente ganó la guerra cuando el general Robert E. Lee se rindió ante el general Ulysses S. Grant en la batalla de Appomattox Court House, seguido de una serie de rendiciones de generales confederados en todos los estados del sur. Cuatro años de intensos combates dejaron entre 620 000 y 750 000 personas muertas, más que el número de muertes militares de los Estados Unidos en todas las demás guerras combinadas (al menos hasta aproximadamente la guerra de Vietnam).1​ Gran parte de la infraestructura del sur fue destruida, especialmente los sistemas de transporte. La Confederación colapsó, la esclavitud fue abolida y 4 millones de esclavos fueron liberados. La Era de la Reconstrucción (1863-1877) se superpuso y siguió a la guerra, con el proceso de restaurar la unidad nacional, fortalecer el gobierno nacional y otorgar derechos civiles a los esclavos liberados en todo el país. La Guerra Civil es el episodio más estudiado y escrito sobre la historia de los Estados Unidos.','2018-12-18 14:32:22',28);
/*!40000 ALTER TABLE `directorios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edicionesafiliaciones`
--

DROP TABLE IF EXISTS `edicionesafiliaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edicionesafiliaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAfiliacion` int(11) NOT NULL,
  `idEditor` int(11) NOT NULL,
  `fechaEdicion` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_edicionesafiliaciones_afiliaciones_idAfiliacion_idx` (`idAfiliacion`),
  KEY `FK_edicionesafiliaciones_usuarios_idEditor_idx` (`idEditor`),
  CONSTRAINT `FK_edicionesafiliaciones_afiliaciones_idAfiliacion` FOREIGN KEY (`idAfiliacion`) REFERENCES `afiliaciones` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_edicionesafiliaciones_usuarios_idEditor` FOREIGN KEY (`idEditor`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicionesafiliaciones`
--

LOCK TABLES `edicionesafiliaciones` WRITE;
/*!40000 ALTER TABLE `edicionesafiliaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `edicionesafiliaciones` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `FK_edicionesdirectorios_usuarios_idEditor` FOREIGN KEY (`idEditor`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicionesdirectorios`
--

LOCK TABLES `edicionesdirectorios` WRITE;
/*!40000 ALTER TABLE `edicionesdirectorios` DISABLE KEYS */;
/*!40000 ALTER TABLE `edicionesdirectorios` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicionespersonajes`
--

LOCK TABLES `edicionespersonajes` WRITE;
/*!40000 ALTER TABLE `edicionespersonajes` DISABLE KEYS */;
INSERT INTO `edicionespersonajes` VALUES (25,37,28,'2018-12-18 14:28:44');
/*!40000 ALTER TABLE `edicionespersonajes` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (37,'Cao Cao','15 de marzo de 155 d.C','15 de marzo de 220 d.C.','Cao Cao (en chino: 曹操, pinyin: Cáo Cāo, Wade-Giles: Ts\'ao Ts\'ao; n. 155 - 15 de marzo de 220) fue el último primer ministro de la dinastía Han de la antigua China. Como figura central del Período de los Tres Reinos, estableció los cimientos de lo que llegaría a ser el reino de Wei (también conocido como Cáo Wèi) y fue póstumamente nombrado Emperador Wu de Wei (魏武帝).\r\n\r\nAunque en la cultura popular y en el Romance de los Tres Reinos se le retrata como un personaje cruel y sospechoso, el Cao Cao histórico brilló como gobernante, como estratega y como poeta. Entre los chinos la figura de Cao Cao es de gran importancia aún hoy en día. Por ejemplo, el dicho \"hablando del rey de Roma, por la puerta asoma\", que en castellano se dice cuando aparece de repente alguien a quien se acaba de mencionar, tiene en chino el equivalente \"hablando de Cao Cao, llega Cao Cao\" (說曹操，曹操到, shuō Cáo Cāo, Cáo Cāo dào)[',71,'2018-12-18 14:28:23',28),(38,'Robert E. Lee','19 de enero de 1807','12 de octubre de 1870','Robert Edward Lee (Stratford, Virginia, 19 de enero de 1807 - Lexington, 12 de octubre de 1870) fue un general estadounidense conocido por comandar el Ejército Confederado de Virginia del Norte durante la Guerra de Secesión desde 1862 hasta su rendición en 1865. Hijo de Henry Lee III, oficial durante la Guerra de Independencia de Estados Unidos, Lee se graduó con honores en la academia militar de West Point y fue un destacado oficial e ingeniero militar del ejército de Estados Unidos durante 32 años. En esas tres décadas sirvió por todo su país, se distinguió durante la Guerra de México-Estados Unidos (1846-1848) y actuó como Superintendente en West Point.\r\n\r\nCuando Virginia declaró su secesión de la Unión en abril de 1861, Lee eligió posicionarse con su estado de origen, a pesar de su deseo de que su país permaneciera intacto y de que le ofrecieron un puesto en el alto mando del ejército de la Unión. Durante el primer año de la guerra de Secesión, Lee sirvió como asesor destacado del presidente confederado Jefferson Davis. Una vez que tomó el mando del principal ejército confederado en 1862, enseguida se distinguió como un astuto estratega y comandante en el campo de batalla, venciendo la mayoría de sus batallas y siempre contra ejércitos de la Unión muy superiores. Su previsión estratégica fue más cuestionable y sus dos grandes ofensivas contra territorio de la Unión acabaron en derrotas. Las tácticas agresivas de Lee, que provocaron numerosas bajas entre sus tropas cuando los confederados contaban con menos hombres, han sido criticadas en tiempos recientes. Lee rindió todo su ejército ante el general Ulysses S. Grant en Appomattox el 9 de abril de 1865. Para entonces ya había asumido el mando de todos los ejércitos que le quedaban a los confederados y otras fuerzas sureñas se rindieron poco después. Lee rechazó la propuesta de mantener una insurgencia contra la Unión y llamó a la reconciliación entre ambos bandos.\r\n\r\nDespués de la guerra, apoyó el programa de Reconstrucción del presidente Andrew Johnson, al tiempo que se oponía a las propuestas de los Republicanos Radicales para conceder el voto a los esclavos libertos y retirarlo a los antiguos confederados. Entonces les urgió a repensar sobre su posicionamiento entre Norte y Sur y sobre la reinserción de los confederados en la vida política de la nación. Lee pasó a ser considerado el gran héroe confederado y para algunos un icono de posguerra de la llamada «Causa perdida de la Confederación». Su popularidad creció incluso en el norte, especialmente después de su muerte en 1870. ',73,'2018-12-18 14:34:43',28),(39,'Abraham Lincoln','4 de marzo de 1861','15 de abril de 1865','Abraham Lincoln (Hodgenville, Kentucky, 12 de febrero de 1809-Washington D. C., 15 de abril de 1865) fue un político y abogado estadounidense que ejerció como decimosexto presidente de los Estados Unidos de América desde marzo de 1861 hasta su asesinato en abril de 1865.1​3​ Lincoln lideró a Estados Unidos durante la guerra de Secesión, el conflicto más sangriento y quizás también la mayor crisis moral, constitucional y política que ha sufrido la nación estadounidense. Al mismo tiempo, preservó la Unión, abolió la esclavitud, fortaleció el gobierno federal y modernizó la economía.4​5​\r\n\r\nNacido en Hodgenville, Kentucky, Lincoln creció entre los estados de Kentucky e Indiana, en lo que entonces era el Lejano Oeste. Fue un hombre en gran parte autodidacta que llegó a ser abogado en Illinois, líder del Partido Whig y que resultó elegido para la Cámara de Representantes de Illinois, en la cual permaneció ocho años. Elegido para la Cámara de Representantes de los Estados Unidos en 1846, Lincoln promovió una rápida modernización de la economía a través de sectores como el bancario, los impuestos y los ferrocarriles. Debido a que en un principio había acordado no optar a un segundo período en el congreso y a que su oposición a la intervención estadounidense en México era impopular entre los votantes de Illinois, Lincoln volvió a Springfield para retomar su carrera en la abogacía. Regresó a la política en 1854 y se convirtió en líder de la construcción del nuevo Partido Republicano, que tenía una gran masa de votantes en Illinois. En 1858, mientras participaba en varios debates muy sonados con su rival, el demócrata Stephen A. Douglas, Lincoln abogó por la abolición de la esclavitud, pero perdió ante este la carrera para acceder al Senado.\r\n\r\nEn 1860 Lincoln se aseguró su candidatura a la presidencia de Estados Unidos por el Partido Republicano. Aunque apenas tuvo apoyo de los estados sureños, defensores de la esclavitud, arrasó en el norte y fue nombrado presidente en 1860. Antes incluso de llegar a la Casa Blanca, su victoria y la falta de acuerdo en el tema esencial de la esclavitud provocaron que siete estados del sur se escindieran para crear los Estados Confederados de América. A continuación, el 12 de abril de 1861, un ataque confederado en Fort Sumter, inspiró a los estados norteños a unirse para formar la Unión. Como líder de la facción moderada de los republicanos, Lincoln se enfrentó al ala más radical de su partido, la cual exigía mayor dureza contra los estados del sur, a los demócratas contrarios a la guerra, que lo despreciaban, y a secesionistas irreconciliables, que conspiraron para asesinarle. Políticamente, Lincoln se defendió enfrentando a sus adversarios entre sí mediante un mecenazgo político cuidadosamente planificado y apelando al pueblo estadounidense con su habilidad oratoria. Su discurso de Gettysburg se convirtió en una icónica defensa de los principios de patriotismo, republicanismo, igualdad de derechos, libertad y democracia. ',73,'2018-12-18 14:35:39',28);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `tiposusuario`
--

LOCK TABLES `tiposusuario` WRITE;
/*!40000 ALTER TABLE `tiposusuario` DISABLE KEYS */;
INSERT INTO `tiposusuario` VALUES (1,'Administrador'),(2,'Estándar');
/*!40000 ALTER TABLE `tiposusuario` ENABLE KEYS */;
UNLOCK TABLES;

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
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombreUsuario_UNIQUE` (`nombreUsuario`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `FK_usuarios_tiposusuario_tipoUsuarioId_idx` (`tipoUsuarioId`),
  CONSTRAINT `FK_usuarios_tiposusuario_tipoUsuarioId` FOREIGN KEY (`tipoUsuarioId`) REFERENCES `tiposusuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (28,'admin','admin',1,'admin@enciclopedia.es'),(29,'Pepito','1234',2,'pepe@pepe.es');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-18 15:36:53
