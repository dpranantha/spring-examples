CREATE TABLE IF NOT EXISTS `springbol`.`Book` ( 
`id` INT NOT NULL AUTO_INCREMENT, 
`title` VARCHAR(45) ,   
PRIMARY KEY (`id`),  
UNIQUE INDEX `title_UNIQUE` (`title` ASC));