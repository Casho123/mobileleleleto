INSERT INTO `users`
VALUES
(1, 'alex.petkov606@gmail.com', 'Casho', null, 1, 'Cashev', 'geiove');

INSERT INTO `brands`
values
(1, 'Ford'),
(2, 'Toyota');

INSERT INTO `models`
(id, name, category, start_year, end_year, brand_id, image_url)
VALUES
(1, 'Fiesta', 'CAR', 1976, null, 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_OsjIqMzWwnPSzXnPFUKReWNYdLOHde7WLjOx4Akc&s'),
(2, 'Escort', 'CAR', 1988, null, 1, 'https://classicsworld.co.uk/wp-content/uploads/sites/6/2022/12/DSC8630C.jpg?w=900'),
(3, 'Yaris', 'CAR', 2013, null, 2, 'https://scene7.toyota.eu/is/image/toyotaeurope/toyota-yaris-grs-2021-gallery-22-full?qlt=80&wid=1280&fit=fit,1&ts=19454&resMode=sharp2&op_usm=1.75,0.3,2,0');