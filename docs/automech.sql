-- MySQL Script generated by MySQL Workbench
-- Sun Oct 22 17:32:43 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema automech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema automech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `automech` DEFAULT CHARACTER SET utf8 ;
USE `automech` ;

-- -----------------------------------------------------
-- Table `automech`.`oficinas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`oficinas` (
  `idoficinas` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(19) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `qtdFuncionarios` INT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `temSite` INT NOT NULL,
  `endereco` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idoficinas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`especialidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`especialidades` (
  `idespecialidades` INT NOT NULL AUTO_INCREMENT,
  `nomeEspecialidade` VARCHAR(45) NOT NULL,
  `descricaoEspecialidade` VARCHAR(400) NOT NULL,
  PRIMARY KEY (`idespecialidades`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`oficinas_especialidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`oficinas_especialidades` (
  `oficinas_idoficinas` INT NOT NULL,
  `especialidades_idespecialidades` INT NOT NULL,
  PRIMARY KEY (`oficinas_idoficinas`, `especialidades_idespecialidades`),
  INDEX `fk_oficinas_has_especialidades_especialidades1_idx` (`especialidades_idespecialidades` ASC) VISIBLE,
  INDEX `fk_oficinas_has_especialidades_oficinas_idx` (`oficinas_idoficinas` ASC) VISIBLE,
  CONSTRAINT `fk_oficinas_has_especialidades_oficinas`
    FOREIGN KEY (`oficinas_idoficinas`)
    REFERENCES `automech`.`oficinas` (`idoficinas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oficinas_has_especialidades_especialidades1`
    FOREIGN KEY (`especialidades_idespecialidades`)
    REFERENCES `automech`.`especialidades` (`idespecialidades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`funcionario` (
  `nomeFuncionario` VARCHAR(45) NOT NULL,
  `cpfFuncionario` VARCHAR(45) NOT NULL,
  `salarioFuncionario` DECIMAL(8,2) NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  `oficinas_idoficinas` INT NOT NULL,
  PRIMARY KEY (`usuario_idUsuario`),
  INDEX `fk_funcionario_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_funcionario_oficinas1_idx` (`oficinas_idoficinas` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `automech`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_oficinas1`
    FOREIGN KEY (`oficinas_idoficinas`)
    REFERENCES `automech`.`oficinas` (`idoficinas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`cliente` (
  `nomeCliente` VARCHAR(100) NOT NULL,
  `cpfCliente` VARCHAR(17) NOT NULL,
  `emailCliente` VARCHAR(45) NOT NULL,
  `senhaCliente` VARCHAR(45) NOT NULL,
  `endereçoCliente` VARCHAR(80) NULL,
  `telefoneCliente` VARCHAR(45) NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`usuario_idUsuario`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `automech`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`veiculo` (
  `idVeiculo` INT NOT NULL AUTO_INCREMENT,
  `marcaVeiculo` VARCHAR(45) NOT NULL,
  `modeloVeiculo` VARCHAR(45) NOT NULL,
  `placaVeiculo` VARCHAR(45) NOT NULL,
  `anoVeiculo` INT NOT NULL,
  `cliente_usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idVeiculo`),
  INDEX `fk_veiculo_cliente1_idx` (`cliente_usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_veiculo_cliente1`
    FOREIGN KEY (`cliente_usuario_idUsuario`)
    REFERENCES `automech`.`cliente` (`usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`orcamento` (
  `idOrcamento` INT NOT NULL AUTO_INCREMENT,
  `valorOrcamento` DECIMAL(8,2) NOT NULL,
  `descricaoOrcamento` VARCHAR(500) NOT NULL,
  `isApprovedOrcamento` INT NOT NULL,
  `veiculo_idVeiculo` INT NOT NULL,
  PRIMARY KEY (`idOrcamento`),
  INDEX `fk_orcamento_veiculo1_idx` (`veiculo_idVeiculo` ASC) VISIBLE,
  CONSTRAINT `fk_orcamento_veiculo1`
    FOREIGN KEY (`veiculo_idVeiculo`)
    REFERENCES `automech`.`veiculo` (`idVeiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`reparo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`reparo` (
  `idReparo` INT NOT NULL AUTO_INCREMENT,
  `valorReparo` DECIMAL(8,2) NOT NULL,
  `dataReparo` DATETIME NOT NULL,
  `imagemReparo` VARCHAR(45) NULL,
  `descricaoReparo` VARCHAR(100) NULL,
  `statusReparo` INT NOT NULL,
  PRIMARY KEY (`idReparo`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `automech`.`pecas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`pecas` (
  `idPeca` INT NOT NULL AUTO_INCREMENT,
  `tipoPeca` VARCHAR(45) NULL,
  `valorPeca` DECIMAL(8,2) NOT NULL,
  `descricaoPeca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPeca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`servico` (
  `idServico` INT NOT NULL AUTO_INCREMENT,
  `valorServico` DECIMAL(8,2) NOT NULL,
  `dataServico` DATETIME NOT NULL,
  `descricaoServico` VARCHAR(200) NOT NULL,
  `obsServico` VARCHAR(100) NULL,
  `prazoServico` DATETIME NOT NULL,
  `dataHoraAtualizacaoServico` DATETIME NULL,
  PRIMARY KEY (`idServico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`oficinas_pecas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`oficinas_pecas` (
  `oficinas_idoficinas` INT NOT NULL,
  `peca_idPeca` INT NOT NULL,
  PRIMARY KEY (`oficinas_idoficinas`, `peca_idPeca`),
  INDEX `fk_oficinas_has_peca_peca1_idx` (`peca_idPeca` ASC) VISIBLE,
  INDEX `fk_oficinas_has_peca_oficinas1_idx` (`oficinas_idoficinas` ASC) VISIBLE,
  CONSTRAINT `fk_oficinas_has_peca_oficinas1`
    FOREIGN KEY (`oficinas_idoficinas`)
    REFERENCES `automech`.`oficinas` (`idoficinas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oficinas_has_peca_peca1`
    FOREIGN KEY (`peca_idPeca`)
    REFERENCES `automech`.`pecas` (`idPeca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`orcamento_reparo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`orcamento_reparo` (
  `orcamento_idOrcamento` INT NOT NULL,
  `reparo_idReparo` INT NOT NULL,
  PRIMARY KEY (`orcamento_idOrcamento`, `reparo_idReparo`),
  INDEX `fk_orcamento_has_reparo_reparo1_idx` (`reparo_idReparo` ASC) VISIBLE,
  INDEX `fk_orcamento_has_reparo_orcamento1_idx` (`orcamento_idOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_orcamento_has_reparo_orcamento1`
    FOREIGN KEY (`orcamento_idOrcamento`)
    REFERENCES `automech`.`orcamento` (`idOrcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_has_reparo_reparo1`
    FOREIGN KEY (`reparo_idReparo`)
    REFERENCES `automech`.`reparo` (`idReparo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`orcamento_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`orcamento_servico` (
  `orcamento_idOrcamento` INT NOT NULL,
  `servico_idServico` INT NOT NULL,
  PRIMARY KEY (`orcamento_idOrcamento`, `servico_idServico`),
  INDEX `fk_orcamento_has_servico_servico1_idx` (`servico_idServico` ASC) VISIBLE,
  INDEX `fk_orcamento_has_servico_orcamento1_idx` (`orcamento_idOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_orcamento_has_servico_orcamento1`
    FOREIGN KEY (`orcamento_idOrcamento`)
    REFERENCES `automech`.`orcamento` (`idOrcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_has_servico_servico1`
    FOREIGN KEY (`servico_idServico`)
    REFERENCES `automech`.`servico` (`idServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `automech`.`atendimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `automech`.`atendimento` (
  `oficinas_idoficinas` INT NOT NULL,
  `orcamento_idOrcamento` INT NOT NULL,
  PRIMARY KEY (`oficinas_idoficinas`, `orcamento_idOrcamento`),
  INDEX `fk_oficinas_has_orcamento_orcamento1_idx` (`orcamento_idOrcamento` ASC) VISIBLE,
  INDEX `fk_oficinas_has_orcamento_oficinas1_idx` (`oficinas_idoficinas` ASC) VISIBLE,
  CONSTRAINT `fk_oficinas_has_orcamento_oficinas1`
    FOREIGN KEY (`oficinas_idoficinas`)
    REFERENCES `automech`.`oficinas` (`idoficinas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oficinas_has_orcamento_orcamento1`
    FOREIGN KEY (`orcamento_idOrcamento`)
    REFERENCES `automech`.`orcamento` (`idOrcamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Inserts
-- -----------------------------------------------------

INSERT INTO `automech`.`usuario` (`idUsuario`) VALUES (1);
INSERT INTO `automech`.`usuario` (`idUsuario`) VALUES (2);
INSERT INTO `automech`.`usuario` (`idUsuario`) VALUES (3);
INSERT INTO `automech`.`usuario` (`idUsuario`) VALUES (4);

INSERT INTO `automech`.`funcionario` (`nomeFuncionario`, `cpfFuncionario`, `salarioFuncionario`, `usuario_idUsuario`, `oficinas_idOficinas`) VALUES ('Matheus', '10811356679', 9000.00, 1,1);
INSERT INTO `automech`.`funcionario` (`nomeFuncionario`, `cpfFuncionario`, `salarioFuncionario`, `usuario_idUsuario`, `oficinas_idOficinas`) VALUES ('Gabriel', '10811317680', 5000.00, 2,1);

INSERT INTO `automech`.`oficinas` (`cnpj`, `nome`, `qtdFuncionarios`, `telefone`, `email`, `temSite`, `endereco`) VALUES ('12345678901234', 'AutoMech', 5, '14696932', 'oficina1@email.com', 1, 'Rua da Bomba');
INSERT INTO `automech`.`oficinas` (`cnpj`, `nome`, `qtdFuncionarios`, `telefone`, `email`, `temSite`, `endereco`) VALUES ('12345678901212', '96 Garage', 2, '55596932', 'oficina2@email.com', 0, 'Rua do Núcleo');

INSERT INTO `automech`.`cliente` (`nomeCliente`, `cpfCliente`, `emailCliente`, `senhaCliente`, `endereçoCliente`, `telefoneCliente`, `usuario_idUsuario`) VALUES ('Indiano', '1234543210', 'cliente1@email.com', 'senha123', 'Rua dos Canários', '31999999999', 3);
INSERT INTO `automech`.`cliente` (`nomeCliente`, `cpfCliente`, `emailCliente`, `senhaCliente`, `endereçoCliente`, `telefoneCliente`, `usuario_idUsuario`) VALUES ('Duda', '9834543210', 'cliente2@email.com', 'password123', 'Rua das Andorinhas', '31995559999', 4);

INSERT INTO `automech`.`especialidades` (`nomeEspecialidade`, `descricaoEspecialidade`) VALUES ('Mecânica Geral', 'Realiza serviços de mecânica em veículos de todas as marcas.');
INSERT INTO `automech`.`especialidades` (`nomeEspecialidade`, `descricaoEspecialidade`) VALUES ('Caminhões', 'Especializamos em manutenção de Caminhões');

INSERT INTO `automech`.`oficinas_especialidades` (`oficinas_idoficinas`, `especialidades_idespecialidades`) VALUES (1, 2);
INSERT INTO `automech`.`oficinas_especialidades` (`oficinas_idoficinas`, `especialidades_idespecialidades`) VALUES (2, 1);

INSERT INTO `automech`.`veiculo` (`marcaVeiculo`, `modeloVeiculo`, `placaVeiculo`, `anoVeiculo`, `cliente_usuario_idUsuario`) VALUES ('Subaru', 'Impreza WRX STI', 'RIKO1234', 2023, 3);
INSERT INTO `automech`.`veiculo` (`marcaVeiculo`, `modeloVeiculo`, `placaVeiculo`, `anoVeiculo`, `cliente_usuario_idUsuario`) VALUES ('Mitsubishi', 'Lancer EVO X', 'NAHO1234', 2023, 3);

INSERT INTO `automech`.`orcamento` (`valorOrcamento`, `descricaoOrcamento`, `isApprovedOrcamento`, `veiculo_idVeiculo`) VALUES ('1000.00', 'Orçamento para reparo do motor', 1, 3);

INSERT INTO `automech`.`reparo` (`valorReparo`, `dataReparo`, `imagemReparo`, `descricaoReparo`, `statusReparo`) VALUES (500.0, '2023-10-22 17:30:00', 'reparo1.jpg', 'Reparo do motor concluído.', 1);

INSERT INTO `automech`.`pecas` (`tipoPeca`, `valorPeca`, `descricaoPeca`) VALUES ('Vela de Ignição', 10.0, 'Vela de ignição para motor a gasolina.');

INSERT INTO `automech`.`servico` (`valorServico`, `dataServico`, `descricaoServico`, `obsServico`, `prazoServico`, `dataHoraAtualizacaoServico`) VALUES (300.0, '2023-10-23 09:00:00', 'Troca de óleo do motor', 'Utilizar óleo sintético.', '2023-10-23 14:00:00', NULL);

INSERT INTO `automech`.`oficinas_pecas` (`oficinas_idoficinas`, `peca_idPeca`) VALUES (1, 1);

INSERT INTO `automech`.`orcamento_reparo` (`orcamento_idOrcamento`, `reparo_idReparo`) VALUES (1, 1);

INSERT INTO `automech`.`orcamento_servico` (`orcamento_idOrcamento`, `servico_idServico`) VALUES (1, 1);

INSERT INTO `automech`.`atendimento` (`oficinas_idoficinas`, `orcamento_idOrcamento`) VALUES (2, 1);