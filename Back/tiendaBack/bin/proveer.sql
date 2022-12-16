-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2022 a las 03:21:27
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proveer`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartera`
--

CREATE TABLE `cartera` (
  `IDCartera` int(11) NOT NULL,
  `IDCliente` int(11) NOT NULL,
  `IDVenta` int(11) NOT NULL,
  `IDPagos` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `FechaPago` date NOT NULL,
  `Saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `IDCliente` int(11) NOT NULL,
  `documentoCliente` int(30) DEFAULT NULL,
  `nombreCliente` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidoCliente` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccionCliente` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `barrioCliente` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `zonaCliente` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefonoCliente` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefonoCliente1` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`IDCliente`, `documentoCliente`, `nombreCliente`, `apellidoCliente`, `direccionCliente`, `barrioCliente`, `zonaCliente`, `telefonoCliente`, `telefonoCliente1`) VALUES
(1, 1234, 'Maria', 'Lopez', 'calle 98 c Bis 3 18 - 16', 'Fontibon', 'Sur', '122312', '3934094'),
(2, 9877, 'Nikolai', 'Fandiño', 'calle 98 c Bis 3 18 - 35', 'Fontibon', 'sur', '82774', '27374');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `IDCompras` int(11) NOT NULL,
  `IDProveedor` int(11) NOT NULL,
  `FechaCompra` date NOT NULL,
  `ValorCompra` double NOT NULL,
  `IvaCompra` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE `detalle_compra` (
  `IDDetalleCompra` int(11) NOT NULL,
  `IDCompra` int(11) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `ValorUnitario` double NOT NULL,
  `CantidadProducto` int(20) NOT NULL,
  `Valor_Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalle_compra`
--

INSERT INTO `detalle_compra` (`IDDetalleCompra`, `IDCompra`, `IDProducto`, `ValorUnitario`, `CantidadProducto`, `Valor_Total`) VALUES
(1, 1, 1, 5000, 5, 25000),
(4, 1, 1, 4000, 3, 12000),
(5, 1, 1, 4000, 3, 12000),
(6, 1, 1, 2000, 4, 8000),
(9, 2, 4, 7000, 3, 21000),
(10, 2, 1, 8000, 8, 64000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `IDDetalle` int(11) NOT NULL,
  `IDVenta` int(11) NOT NULL,
  `IDProducto` int(11) NOT NULL,
  `cantidadProducto` int(30) NOT NULL,
  `PrecioProducto` double NOT NULL,
  `TotalDetalle` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`IDDetalle`, `IDVenta`, `IDProducto`, `cantidadProducto`, `PrecioProducto`, `TotalDetalle`) VALUES
(1, 1, 1, 5, 2000, 2000),
(2, 1, 4, 1, 10000, 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `IDPagos` int(11) NOT NULL,
  `IDCliente` int(11) NOT NULL,
  `IDVenta` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `FechaPago` date NOT NULL,
  `TipoPago` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `MedioPago` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `ValorPago` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`IDPagos`, `IDCliente`, `IDVenta`, `FechaVenta`, `FechaPago`, `TipoPago`, `MedioPago`, `ValorPago`) VALUES
(1, 1, 1, '2022-12-02', '2022-12-16', '', 'Efectivo', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `IDProductos` int(11) NOT NULL,
  `IDProveedor` int(11) NOT NULL,
  `CodigoProducto` int(30) NOT NULL,
  `NombreProducto` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `TipoProducto` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `PrecioCompra` double NOT NULL,
  `PrecioVenta` double NOT NULL,
  `Cantidad` bigint(20) NOT NULL,
  `UnidadesVendidas` bigint(20) NOT NULL,
  `UnidadesCompradas` bigint(20) NOT NULL,
  `Devoluciones` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`IDProductos`, `IDProveedor`, `CodigoProducto`, `NombreProducto`, `TipoProducto`, `PrecioCompra`, `PrecioVenta`, `Cantidad`, `UnidadesVendidas`, `UnidadesCompradas`, `Devoluciones`) VALUES
(1, 3, 83494, 'Camisa polo', 'Camisa', 5000, 7000, 90, 10, 100, 0),
(2, 1, 2323, 'Escoba zulia', 'Escoba', 2000, 5000, 7, 4, 12, 1),
(3, 2, 13831, 'Espejo cama', 'Espejo', 50000, 80000, 80, 50, 130, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `IDProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `Nit` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ciudadProveedor` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `direcciónProveedor` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `telefonoProveedor` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `TipoProducto` varchar(200) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`IDProveedor`, `nombreProveedor`, `Nit`, `ciudadProveedor`, `direcciónProveedor`, `telefonoProveedor`, `TipoProducto`) VALUES
(1, 'escobas carlos', '658979', 'cali', 'calle axoio # 78 - 34', '678787', 'escobas'),
(2, 'espejos sas', '67989', 'bogota', 'calle 678 # 89 - 5', '57878', 'espejos'),
(3, 'camisas pu', '6898998', 'bogota', 'calle 98nb c #57 -3', '57676', 'camisas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IDUsuario` int(11) NOT NULL,
  `usuario` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombreUsuario` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `perfil` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IDUsuario`, `usuario`, `nombreUsuario`, `correo`, `password`, `perfil`) VALUES
(1, 'Nikolai Fandiño ', 'Nikolasfan', 'bkhui@correo.com', '123', 'Vendedor'),
(2, 'Nikolai Fandiño ', 'Nikolasfan', 'bkhui@correo.com', '123', 'Vendedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `IDVendedor` int(11) NOT NULL,
  `IDUsuario` int(11) NOT NULL,
  `documentoVendedor` bigint(20) DEFAULT NULL,
  `nombreVendedor` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `direccionVendedor` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `telefonoVendedor` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `comisionVendedor` float NOT NULL,
  `FechaIngreso` date NOT NULL,
  `Salario` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`IDVendedor`, `IDUsuario`, `documentoVendedor`, `nombreVendedor`, `direccionVendedor`, `telefonoVendedor`, `comisionVendedor`, `FechaIngreso`, `Salario`) VALUES
(1, 1, 3455, 'Nikolai Fandiño ', 'calle 16 c bis # 87- 43', '3567437', 0.05, '2022-12-02', 345467778),
(2, 2, 547568, 'Steven López', 'calle 16 c bis # 87- 98', '467576', 0.06, '2021-11-03', 5755646);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IDVenta` int(11) NOT NULL,
  `IDCliente` int(11) NOT NULL,
  `IDVendedor` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `TotalVenta` double NOT NULL,
  `IvaVenta` double NOT NULL,
  `ValorPago` double NOT NULL,
  `Saldo` double NOT NULL,
  `FormaPago` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `FechaPago` date NOT NULL,
  `zona` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IDVenta`, `IDCliente`, `IDVendedor`, `FechaVenta`, `fechaEntrega`, `TotalVenta`, `IvaVenta`, `ValorPago`, `Saldo`, `FormaPago`, `FechaPago`, `zona`) VALUES
(1, 2, 1, '2022-12-02', '0000-00-00', 20000, 0.15, 15000, 5000, 'EFECTIVO', '2022-12-16', ''),
(2, 2, 1, '2022-12-09', '0000-00-00', 40000, 2000, 35000, 5000, 'efectivo', '2022-12-09', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cartera`
--
ALTER TABLE `cartera`
  ADD PRIMARY KEY (`IDCartera`),
  ADD KEY `IDCliente` (`IDCliente`),
  ADD KEY `IDVenta` (`IDVenta`),
  ADD KEY `IDPagos` (`IDPagos`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`IDCliente`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`IDCompras`),
  ADD KEY `IDProveedor` (`IDProveedor`);

--
-- Indices de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD PRIMARY KEY (`IDDetalleCompra`),
  ADD KEY `IDCompra` (`IDCompra`),
  ADD KEY `IDProducto` (`IDProducto`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`IDDetalle`),
  ADD KEY `IDVenta` (`IDVenta`),
  ADD KEY `IDProducto` (`IDProducto`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`IDPagos`),
  ADD KEY `IDCliente` (`IDCliente`),
  ADD KEY `IDVenta` (`IDVenta`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`IDProductos`),
  ADD KEY `IDProveedor` (`IDProveedor`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`IDProveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IDUsuario`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`IDVendedor`),
  ADD KEY `Rol` (`IDUsuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IDVenta`),
  ADD KEY `IDCliente` (`IDCliente`),
  ADD KEY `IDVendedor` (`IDVendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cartera`
--
ALTER TABLE `cartera`
  MODIFY `IDCartera` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `IDCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `IDCompras` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  MODIFY `IDDetalleCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `IDDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `IDPagos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `IDProductos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `IDProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IDUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IDVendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IDVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cartera`
--
ALTER TABLE `cartera`
  ADD CONSTRAINT `cartera_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `clientes` (`IDCliente`),
  ADD CONSTRAINT `cartera_ibfk_2` FOREIGN KEY (`IDVenta`) REFERENCES `ventas` (`IDVenta`),
  ADD CONSTRAINT `cartera_ibfk_3` FOREIGN KEY (`IDPagos`) REFERENCES `pagos` (`IDPagos`);

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`IDProveedor`) REFERENCES `proveedores` (`IDProveedor`);

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`IDCompra`) REFERENCES `compras` (`IDCompras`),
  ADD CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`IDProducto`) REFERENCES `productos` (`IDProductos`);

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`IDProducto`) REFERENCES `productos` (`IDProductos`),
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`IDVenta`) REFERENCES `ventas` (`IDVenta`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`IDCliente`) REFERENCES `clientes` (`IDCliente`),
  ADD CONSTRAINT `pagos_ibfk_2` FOREIGN KEY (`IDVenta`) REFERENCES `ventas` (`IDVenta`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`IDProveedor`) REFERENCES `proveedores` (`IDProveedor`);

--
-- Filtros para la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IDVendedor`) REFERENCES `vendedor` (`IDVendedor`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`IDCliente`) REFERENCES `clientes` (`IDCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
