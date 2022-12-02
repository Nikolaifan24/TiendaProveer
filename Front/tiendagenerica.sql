-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-09-2021 a las 23:42:38
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendagenerica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `numeroDocumento` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `idTipoDocumento`, `numeroDocumento`, `direccion`, `email`, `nombre`, `telefono`) VALUES
(1, 1, '123', 'CALLE 1', 'DIEGO887@HOTMAIL.COM', 'DIEGO RIVERA', '00000000'),
(2, 2, '123', 'CALLE 2', 'VALEN997@HOTMAIL.COM', 'VALENTINA LOPEZ', '00000111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleVenta`
--

CREATE TABLE `detalleVenta` (
  `id` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `cantidadProducto` double NOT NULL,
  `valorTotal` double NOT NULL,
  `valorVenta` double NOT NULL,
  `valorIva` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `detalleVenta`
--

INSERT INTO `detalleVenta` (`id`, `idProducto`, `idVenta`, `cantidadProducto`, `valorTotal`, `valorVenta`, `valorIva`) VALUES
(1, 1, 1, 8, 9800, 8000, 1800),
(2, 2, 2, 5, 7800, 5000, 2800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `ivaCompra` double NOT NULL,
  `nombreProducto` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `idProveedor`, `ivaCompra`, `nombreProducto`, `precioCompra`, `precioVenta`) VALUES
(1, 1, 1800, 'PAPAS', 800, 900),
(2, 2, 2000, 'TOMATES', 500, 700);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `ciudad` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `idTipoDocumento`, `ciudad`, `direccion`, `nombre`, `telefono`) VALUES
(1, 2, 'MEDELLIN', 'CALLE 3', 'LAURA', '00009'),
(2, 3, 'CALI', 'CALLE 4', 'ESTEBAN', '00008');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoDocumento`
--

CREATE TABLE `tipoDocumento` (
  `id` int(11) NOT NULL,
  `tipo` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `tipoDocumento`
--

INSERT INTO `tipoDocumento` (`id`, `tipo`) VALUES
(1, 'CEDULA-Update'),
(2, 'NIT'),
(3, 'PASAPORTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `numeroDocumento` varchar(30) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombreUsuario` varchar(200) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `idTipoDocumento`, `numeroDocumento`, `email`, `nombre`, `password`, `nombreUsuario`) VALUES
(1, 1, '649876', 'ALFREDO@GMAIL.COM', 'ALFREDO AGUDELO', 'AA-123', 'ALFREDOAG'),
(2, 2, '900676', 'CAMILA@GMAIL.COM', 'CAMILA RESTREPO', 'BB-123', 'CAMILARE'),
(3, 2, '1234567', 'NIKO@HOTMAIL.COM', 'NIKOLAI', '123', 'NIKOLAI23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `ivaVenta` double NOT NULL,
  `totalVenta` double NOT NULL,
  `valorVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `idCliente`, `idUsuario`, `ivaVenta`, `totalVenta`, `valorVenta`) VALUES
(1, 1, 1, 1500, 10000, 8500),
(2, 2, 2, 3500, 13500, 10000),
(3, 1, 1, 2000, 20000, 18000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_TIPODOCUMENTO_CLIENTE` (`idTipoDocumento`);

--
-- Indices de la tabla `detalleVenta`
--
ALTER TABLE `detalleVenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_IDVENTA_DETALLEVENTA` (`idVenta`),
  ADD KEY `FK_IDPRODUCTO_VENTAS` (`idProducto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_IDPROVEEDOR_PRODUCTOS` (`idProveedor`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipoDocumento`
--
ALTER TABLE `tipoDocumento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_IDCLIENTE_VENTAS` (`idCliente`),
  ADD KEY `FK_IDUSUARIO_VENTAS` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipoDocumento`
--
ALTER TABLE `tipoDocumento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_TIPODOCUMENTO_CLIENTE` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipoDocumento` (`id`);

--
-- Filtros para la tabla `detalleVenta`
--
ALTER TABLE `detalleVenta`
  ADD CONSTRAINT `FK_IDPRODUCTO_VENTAS` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`),
  ADD CONSTRAINT `FK_IDVENTA_DETALLEVENTA` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`id`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_IDPROVEEDOR_PRODUCTOS` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `FK_IDCLIENTE_VENTAS` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK_IDUSUARIO_VENTAS` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
