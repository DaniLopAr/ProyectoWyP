

CREATE SCHEMA TiendaRepuestos ;

use TiendaRepuestos;

create user 'Admin'@'%' IDENTIFIED BY 'Admin1234';


grant all privileges on TiendaRepuestos.* to 'Admin'@'%';
flush privileges;



create table TiendaRepuestos.producto(
id_producto int auto_increment primary key, 
descripcion varchar(1024), 
marca varchar(64), 
precio int, 
imagen varchar(1024),
activo bool)




INSERT INTO TiendaRepuestos.producto (id_producto, descripcion, marca, precio, imagen, activo)values
(1,'Balanceador Armonic','Honda',25000,'https://i.ebayimg.com/images/g/iyUAAOSw3b5kYuK~/s-l1600.jpg',true),
(2,'Motor de 2,5 L carrocería acelerador módulo de válvula','Toyota',120000,'https://i.ebayimg.com/images/g/em8AAOSwJaRkoeLC/s-l1600.png',true),
(3,'Catalizador EEC','Hyundai',115000,'https://i.ebayimg.com/images/g/7loAAOSwyvZj0pz8/s-l1600.jpg',true),
(4,'Cigüeñal forjado Manley','Chrysler',850000,'https://m.media-amazon.com/images/I/51xVgL9789L._AC_UF894,1000_QL80_.jpg',true),
(5,'Refrigerante de motor anticongelante de un galon','Ford',20000,'https://i.ebayimg.com/images/g/M7sAAOSwFQliC~Hu/s-l1600.jpg',true),
(6,'Trampa de aceite para Cigüeñal','Mercedez',65000,'https://m.media-amazon.com/images/I/61H4y3DZBNL._AC_UF894,1000_QL80_.jpg',true);
