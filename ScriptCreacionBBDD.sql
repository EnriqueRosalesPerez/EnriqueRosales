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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directorios`
--

LOCK TABLES `directorios` WRITE;
/*!40000 ALTER TABLE `directorios` DISABLE KEYS */;
INSERT INTO `directorios` VALUES (34,'Tres Reinos','220 d.C.','280 d.C.','Los Tres Reinos es un periodo de la historia de China. En un estricto sentido académico se refiere al periodo comprendido entre la fundación de Wei en el 220 y la conquista de los Wu por la dinastía Jin en el 280. Sin embargo, muchos historiadores chinos amplían el punto del comienzo de este periodo a la rebelión de los turbantes amarillos en el 184.\r\n\r\nLa temprana y \"no oficial\" parte del periodo, comprendida desde 190 al 220, estuvo marcada por las caóticas luchas internas entre los señores de la guerra en varias partes de China. La parte media del periodo, del 220 al 263, estuvo marcada por el militarmente más estable acuerdo entre los tres estados rivales, Wei, Shu, y Wu.\r\n\r\nPara distinguir a estos estados de los antiguos estados del mismo nombre, los historiadores los precedieron de un carácter: Wei es también conocido como Cao Wei, Han es conocido como Shu Han, que posteriormente pasó solamente a ser conocido como Shu, y Wu es también conocido como Wu oriental.\r\n\r\nLa última parte de este periodo estuvo marcada por la destrucción de Shu por parte de Wei en el 263, el derrocamiento de Wei por la dinastía Jin en el 265 y la destrucción de Wu por Jin en el 280.\r\n\r\nEl término \"Tres Reinos\" es una traducción inexacta, puesto que cada estado estuvo eventualmente gobernado por un emperador que reclamaba su legítimo derecho de sucesión a la dinastía Han y no por reyes. Sin embargo, esta denominación se ha convertido en estándar entre los sinólogos.\r\n\r\nEste periodo histórico ha sido en gran manera visto de forma romántica en las culturas de China, Japón y Corea y a lo largo del sureste asiático. Ha sido celebrado y popularizado en óperas, cuentos tradicionales, novelas, y en tiempos más recientes, películas, series de televisión y videojuegos. El más conocido de todos, es sin duda, el Romance de los Tres Reinos, una recreación ficticia de este periodo con un profundo trasfondo histórico. El registro histórico autorizado de la era es Sanguo Zhi de Chen Shou, junto con las anotaciones posteriores de Pei Songzhi sobre el texto.\r\n\r\nEl periodo de los Tres Reinos es uno de los más sangrientos en la historia de China. Un censo de la población a finales de la dinastía Han oriental calculaba una población de aproximadamente 56 millones, mientras otro censo posterior reporta aproximadamente 16 millones, teniendo en cuenta las imprecisiones de los registros censales de la época, es seguro asumir que un amplio porcentaje de la población fue exterminada durante las constantes guerras que se desataron durante el periodo.','2018-11-21 23:00:00',1),(38,'Guerra Civil Americana','12 de abril de 1861','9 de abril de 1865','La guerra de Secesión o guerra civil estadounidense (en inglés American Civil War o simplemente Civil War en los Estados Unidos) fue una guerra (aunque el Congreso nunca emitió una Declaración de Guerra) librada en los Estados Unidos desde 1861 hasta 1865. Como resultado de la controversia histórica sobre la esclavitud, la guerra estalló en abril de 1861, cuando las fuerzas de los Estados Confederados de América atacaron Fort Sumter en Carolina del Sur, poco después de que el presidente Abraham Lincoln asumiera su cargo. Los nacionalistas de la Unión proclamaron lealtad a la Constitución de los Estados Unidos. Se enfrentaron a secesionistas de los Estados Confederados, que defendían los derechos de los estados a expandir la esclavitud.\r\n\r\nEntre los 34 estados de EE. UU. en febrero de 1861, siete estados esclavistas del sur individualmente declararon su secesión de los Estados Unidos para formar los Estados Confederados de América, o el Sur. La Confederación creció para incluir once estados esclavistas. La Confederación nunca fue diplomáticamente reconocida por el Gobierno de los Estados Unidos, ni fue reconocida por ningún país extranjero (aunque el Reino Unido y Francia le otorgaron estatus beligerante). Los estados que permanecieron leales a los EE. UU. (incluidos los estados fronterizos donde la esclavitud era legal) se conocían como la Unión o el Norte.\r\n\r\nLa Unión y la Confederación rápidamente levantaron ejércitos voluntarios y conscriptos que lucharon principalmente en el Sur a lo largo de cuatro años. La Unión finalmente ganó la guerra cuando el general Robert E. Lee se rindió ante el general Ulysses S. Grant en la batalla de Appomattox Court House, seguido de una serie de rendiciones de generales confederados en todos los estados del sur. Cuatro años de intensos combates dejaron entre 620 000 y 750 000 personas muertas, más que el número de muertes militares de los Estados Unidos en todas las demás guerras combinadas (al menos hasta aproximadamente la guerra de Vietnam). Gran parte de la infraestructura del sur fue destruida, especialmente los sistemas de transporte. La Confederación colapsó, la esclavitud fue abolida y 4 millones de esclavos fueron liberados. La Era de la Reconstrucción (1863-1877) se superpuso y siguió a la guerra, con el proceso de restaurar la unidad nacional, fortalecer el gobierno nacional y otorgar derechos civiles a los esclavos liberados en todo el país. La Guerra Civil es el episodio más estudiado y escrito sobre la historia de los Estados Unidos.','2018-11-21 23:00:00',1),(39,'Guerra Civil Española','','','','2018-11-21 23:00:00',1);
/*!40000 ALTER TABLE `directorios` ENABLE KEYS */;
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
  CONSTRAINT `FK_edicionesdirectorios_usuarios_idEditor` FOREIGN KEY (`idEditor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicionesdirectorios`
--

LOCK TABLES `edicionesdirectorios` WRITE;
/*!40000 ALTER TABLE `edicionesdirectorios` DISABLE KEYS */;
INSERT INTO `edicionesdirectorios` VALUES (18,34,1,'2018-11-21 23:00:00'),(19,34,1,'2018-11-21 23:00:00'),(20,38,1,'2018-11-21 23:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicionespersonajes`
--

LOCK TABLES `edicionespersonajes` WRITE;
/*!40000 ALTER TABLE `edicionespersonajes` DISABLE KEYS */;
INSERT INTO `edicionespersonajes` VALUES (3,7,1,'2018-11-21 23:00:00'),(4,7,1,'2018-11-21 23:00:00'),(5,10,1,'2018-11-21 23:00:00'),(6,7,1,'2018-11-22 23:00:00'),(7,7,1,'2018-11-22 23:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (7,'Cao Cao','155 d.C.','220 d.C.','Cao Cao (&#26361;&#25805;) fue el último primer ministro de la dinastía Han de la antigua China. Como figura central del Período de los Tres Reinos, estableció los cimientos de lo que llegaría a ser el reino de Wei (también conocido como Cáo Wèi) y fue póstumamente nombrado Emperador Wu de Wei.\r\n\r\nDe joven, Cao Cao era conocido por su astucia. Su tío se quejaba con frecuencia a Cao Song por su indulgencia para con la caza y la música. Para contrarrestar estos ataques, Cao Cao fingió un día un ataque frente a su tío, quien rápidamente informó a Cao Song. Éste acudió a ver a su hijo, que había vuelto a la normalidad. Cuando fue preguntado, Cao Cao respondió: \"Nunca he tenido esa enfermedad, pero he perdido el amor de mi tío, y por eso te ha engañado\". A partir de ese momento, Cao Song dejó de creer las palabras de su hermano en lo relativo a Cao Cao, con lo que éste se volvió más caprichoso.\r\n\r\nEn 189, el Emperador Ling murió y le sucedió en el trono su hijo mayor, aunque eran la emperatriz viuda y los eunucos los que detentaban el poder real. Los dos generales más poderosos de esa época, He Jin y Yuan Shao, se conjuraron para eliminar la influencia de los eunucos. He Jin convocó a Dong Zhuo, gobernador de Liangzhou para que entrara con su ejército en la capital Luoyang y presionara a la emperatriz. Sin embargo, antes de que llegara, He Jin fue asesinado por los eunucos y Luoyang cayó en el caos. Después de que su ejército se hubo deshecho de la oposición en el palacio, Dong Zhuo depuso al emperador, poniendo en su lugar al emperador títere Xian Di. Al ver que no era posible el acuerdo con Dong Zhuo, Cao Cao abandonó Luoyang en dirección a Chenliu (al sureste de la actual Kaifeng, en Henan) donde formó su propio ejército. Al año siguiente, los señores de la guerra, bajo el liderazgo de Yuan Shao, unieron sus fuerzas contra Dong Zhuo. Cao Cao se unió a su causa. Cuando Dong Zhuo fue finalmente asesinado en 192, por su propio hijo adoptivo Lü Bu, un poderoso guerrero, China cayó en la guerra civil. Tras varias guerras de corta duración y de alcance regional, Cao Cao continuó aumentando su poder. ',34,'2018-11-21 23:00:00',1),(8,'Liu Bei','161 d.C.','223 d.C.','Liu Bei (161 - 21 de junio de 223),&#8203; tenía Xuándé como nombre de estilo chino. Fue un poderoso jefe militar y emperador de Shu durante la época de los Tres Reinos de China.\r\n\r\nHabiéndose elevado desde un origen plebeyo muy humilde, fue al principio un personaje de poca importancia durante la guerra civil masiva que llevó al derrumbamiento a la Dinastía Han Oriental.\r\n\r\nEn 214, usando las estratagemas de su consejero principal Zhuge Liang, Liu Bei conquistó Yizhou (actualmente Sichuan y Guizhou) y en su última estancia establecería la fundación del reino de Shu.\r\n\r\nEn 221, Liu Bei se declaró emperador en un esfuerzo por continuar el linaje de la Dinastía Han. Fue sucedido por su hijo Liu Shan, que un tiempo después se rindió a Cao Wei en 263. ',34,'2018-11-21 23:00:00',1),(9,'Sun Quan','182 d.C.','252 d.C.','Sun Quan (5 de julio de 182-21 de mayo de 252),1&#8203; hijo de Sun Jian, formalmente emperador Da de Wu, fue el fundador del reino Wu Oriental durante el período de los Tres Reinos en China. Gobernó desde 222 hasta 229 como rey de Wu y 229 a 252 como emperador de Wu.\r\n\r\nEn su juventud, Sun pasó un tiempo en su casa del condado de Fuchun y, después de la muerte de su padre en los tempranos años de la década 190, en varias ciudades en la parte baja del río Yangtze. Su hermano mayor Sun Ce creó un estado propio en la región para convertirse en señor de la guerra, apoyándose en sus propios seguidores y una serie de alianzas con clanes locales. Cuando Sun Ce fue asesinado por los hombres de Xu Gong en el año 200, a los dieciocho años de edad Sun Quan heredó el sureste de las tierras del río Yangtsé de su hermano. Su gobierno resultó ser relativamente estable en los primeros años. Sun Jian y los oficiales de más sobresalientes de Sun Ce, tales como Zhou Yu, Zhao Zhang, Hong Zhang, y Pu Cheng, se mantuvieron leales, de hecho se menciona en el romance de los Tres Reinos que Sun Ce tenía en su lecho de muerte un recordatorio para Sun Quan que decía que \"en el ámbito interno, consulta a Zhang Zhao, en los asuntos externos, consulta a Zhou Yu. \" Así, todo el 200, Sun Quan, bajo la tutela de sus capaces asesores, continuó aumentando su fuerza a lo largo del río Yangtze. A principios de 207, sus fuerzas finalmente obtuvieron la victoria total sobre Huang Zu, un jefe militar al mando de Liu Biao, que dominó el Yangtsé medio.\r\n\r\nEn invierno de ese año, el señor de la guerra del norte, Cao Cao, condujo un ejército de unos 830.000 hombres a la conquista del sur para completar la reunificación de China. Dos opiniones se crearon en la corte de Sun Quan sobre cómo manejar la situación. Uno, dirigido por Zhang Zhao, instó a rendirse, mientras que la otra, dirigida por Zhou Yu y Lu Su, se oponían a la capitulación. Al final, Sun decidió oponerse a Cao en el Yangtsé medio con sus fuerzas fluviales superiores. Aliado con Liu Bei y empleando las estrategias combinadas de Zhou Yu y Huang Gai, derrotaron a Cao en la decisiva Batalla de los Acantilados Rojos.\r\n\r\nEn 220, Cao Pi, hijo de Cao Cao, consiguió el trono y se proclamó emperador de China; ponía fin así a la dinastía Han. Al principio Sun sirvió nominalmente como vasallo de Cao Wei con el recién creado título de Príncipe de Wu, pero después Cao Pi exigió que enviara a su hijo, Sun Deng, como rehén a la capital de Cao Wei, Luoyang, y él se negó. En 222, se declaró independiente, cambiando su nombre de aquella era. No fue sino hasta el año 229 que oficialmente se declaró emperador.\r\n\r\nDebido a su habilidad en reunir a hombres importantes y honorables a su causa, Sun fue capaz de delegar autoridad a figuras capaces. Esta fuerza primaria le sirvió para ganar el apoyo de la gente común y rodearse de generales competentes.\r\n\r\nDespués de la muerte de su heredero a la corona, Sun Deng, emergieron lentamente dos facciones opuestas que apoyaban a diferentes potenciales sucesores. Cuando Sun He logró suceder a Sun Deng en la corona, recibió el apoyo de Lu Xun y Zhuge Luo, mientras que su rival Sun Ba recibió el apoyo de Quan Cong y Zhi Bu y sus clanes. Tras una lucha de poder interna prolongada, numerosos funcionarios fueron ejecutados, y Sun Quan resolvió duramente el conflicto entre las dos facciones exiliando a Sun He y matando a Sun Ba. Sun Quan murió en 252 a la edad de 70 años. Disfrutó del reinado más largo de todos los fundadores de los Tres Reinos, y fue sucedido por su hijo Sun Liang. ',34,'2018-11-21 23:00:00',1),(10,'Abraham Lincoln','4 de marzo de 1861','15 de abril de 1865','Abraham Lincoln (Hodgenville, Kentucky, 12 de febrero de 1809-Washington D. C., 15 de abril de 1865) fue un político y abogado estadounidense que ejerció como decimosexto presidente de los Estados Unidos de América desde marzo de 1861 hasta su asesinato en abril de 1865. Lincoln lideró a Estados Unidos durante la guerra de Secesión, el conflicto más sangriento y quizás también la mayor crisis moral, constitucional y política que ha sufrido la nación estadounidense. Al mismo tiempo, preservó la Unión, abolió la esclavitud, fortaleció el gobierno federal y modernizó la economía.\r\n\r\nNacido en Hodgenville, Kentucky, Lincoln creció entre los estados de Kentucky e Indiana, en lo que entonces era el Lejano Oeste. Fue un hombre en gran parte autodidacta que llegó a ser abogado en Illinois, líder del Partido Whig y que resultó elegido para la Cámara de Representantes de Illinois, en la cual permaneció ocho años. Elegido para la Cámara de Representantes de los Estados Unidos en 1846, Lincoln promovió una rápida modernización de la economía a través de sectores como el bancario, los impuestos y los ferrocarriles. Debido a que en un principio había acordado no optar a un segundo período en el congreso y a que su oposición a la intervención estadounidense en México era impopular entre los votantes de Illinois, Lincoln volvió a Springfield para retomar su carrera en la abogacía. Regresó a la política en 1854 y se convirtió en líder de la construcción del nuevo Partido Republicano, que tenía una gran masa de votantes en Illinois. En 1858, mientras participaba en varios debates muy sonados con su rival, el demócrata Stephen A. Douglas, Lincoln abogó por la abolición de la esclavitud, pero perdió ante este la carrera para acceder al Senado.\r\n\r\nEn 1860 Lincoln se aseguró su candidatura a la presidencia de Estados Unidos por el Partido Republicano. Aunque apenas tuvo apoyo de los estados sureños, defensores de la esclavitud, arrasó en el norte y fue nombrado presidente en 1860. Antes incluso de llegar a la Casa Blanca, su victoria y la falta de acuerdo en el tema esencial de la esclavitud provocaron que siete estados del sur se escindieran para crear los Estados Confederados de América. A continuación, el 12 de abril de 1861, un ataque confederado en Fort Sumter, inspiró a los estados norteños a unirse para formar la Unión. Como líder de la facción moderada de los republicanos, Lincoln se enfrentó al ala más radical de su partido, la cual exigía mayor dureza contra los estados del sur, a los demócratas contrarios a la guerra, que lo despreciaban, y a secesionistas irreconciliables, que conspiraron para asesinarle. Políticamente, Lincoln se defendió enfrentando a sus adversarios entre sí mediante un mecenazgo político cuidadosamente planificado y apelando al pueblo estadounidense con su habilidad oratoria. Su discurso de Gettysburg se convirtió en una icónica defensa de los principios de patriotismo, republicanismo, igualdad de derechos, libertad y democracia.\r\n\r\nEn un principio, Lincoln se concentró en las dimensiones militar y política del conflicto. Su objetivo principal era conservar la unidad de su país, para lo que supervisó de cerca el esfuerzo de guerra, en especial la selección de los generales que dirigirían el ejército, entre ellos su mejor hombre en el campo de batalla, Ulysses S. Grant. Además, el presidente tomó importantes decisiones en la estrategia de guerra de la Unión, entre ellas un bloqueo naval que impidió el comercio de los estados sureños, movimientos para tomar el control de Kentucky y Tennessee y el uso de buques cañoneros para dominar las vías fluviales del sur. Lincoln trató repetidamente de conquistar la capital confederada en Richmond, misión que encargó a sucesivos generales hasta que Grant lo consiguió. Mientras se libraba la guerra, sus complejos movimientos para acabar con la esclavitud incluyeron la Proclamación de Emancipación en 1863. El presidente usó al ejército de la Unión para proteger a esclavos huidos, forzó a los estados fronterizos a prohibir el sistema esclavista y sacó adelante en el Congreso la hoy célebre Decimotercera Enmienda a la Constitución de los Estados Unidos, que prohibió de forma definitiva la esclavitud.\r\n\r\nLincoln fue un político excepcionalmente astuto, que se involucró profundamente en las cuestiones de poder de cada estado, lo que le valió ser reelegido en el poder en 1864. En previsión del final de la guerra, impulsó una moderada reconstrucción que buscaba reunificar el país de manera rápida a través de una generosa política de reconciliación en medio de una persistente y amarga división. El 14 de abril de 1865, cinco días después de la decisiva rendición del general en jefe del bando confederado, Robert E. Lee, Lincoln fue asesinado por John Wilkes Booth, un simpatizante de la causa del sur. Desde entonces, Abraham Lincoln ha sido considerado por historiadores y por la opinión pública como uno de los mejores presidentes de los Estados Unidos de América. ',38,'2018-11-21 23:00:00',1);
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin');
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

-- Dump completed on 2018-11-23 19:35:08
