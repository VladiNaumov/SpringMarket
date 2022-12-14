DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, name VARCHAR(255), price decimal, sn VARCHAR(255));

INSERT INTO product (name, price, sn)
VALUES
('LEIPOA', 2.80,'QWER-1234'),
('MAITOA', 1.20,'WERT-3566'),
('APPELSINI', 3.60, 'WERT-300566'),
('AVAKADO', 1.80,'W0ERT-3566'),
('SUKLATA', 3.20,'WE00RT-3566'),
('KERMA', 0.60,'WERT99-3566'),
('MAKKARA', 3.80,'WERTTT-3566'),
('KANAN', 3.20,'WERTFG-3566'),
('KURKKUA', 2.60,'WERTYU-3566'),
('TOMATTIA', 2.80,'WEWERT-35T6'),
('TEE', 1.20, 'WERT-356677-FG'),
('KAHFI', 6.60,'WERT-356677-FG'),
('PERUNOITA', 0.80,'WERT-356677-FG'),
('SALATTIA', 2.20,'WERT-356677-FG'),
('BANANIA', 1.60,'WERT-356677-FG'),
('PIZZA', 2.80,'WERT-356RR-FG'),
('JAATELLO', 1.80,'WERT-356000-FG'),
('ANANAS', 1.60,'WERT-356677-FGTY'),
('JOUGURTTI', 2.80,'WERT-35667YY7-FG'),
('NAKKI', 2.20,'DERT-356677-FG'),
('OULTT', 3.60,'WRT-356677-FG');