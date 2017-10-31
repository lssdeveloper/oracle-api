package com.lssdeveloper.oracleapi;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.lssdeveloper.oracleapi.model.Cliente;
import com.lssdeveloper.oracleapi.repository.ClienteRepository;

import static java.lang.System.exit;

@SpringBootApplication
public class OracleApiApplication implements CommandLineRunner {
	
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DataSource dataSource;

    @Autowired
    ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(OracleApiApplication.class, args);
	}
	@Transactional(readOnly = true)
    @Override
	public void run(String...args) throws Exception {
		
		Cliente cli = new Cliente();
		
		System.out.println("DATASource = " + dataSource);
        System.out.println("************************************************************");
        System.out.println("************************************************************");
		
		System.out.println("\n1.findAll()... Retorna todos os clientes");
        for (Cliente cliente : clienteRepository.findAll()) {
            System.out.println(cliente);
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        System.out.println("\n2.findByEmail(String email)... Retorna o email do anderson");
        for (Cliente cliente : clienteRepository.findByEmail("anderson@yahoo.com")) {
            System.out.println(cliente);
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");     
        System.out.println("\n3.findByDate(Date date)...Retorna cliente com data criação 2017-10-29");
        for (Cliente cliente : clienteRepository.findByData(sdf.parse("2017-10-29"))) {
            System.out.println(cliente);
        }
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        // For Stream, need @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Cliente> stream = clienteRepository.findByEmailReturnStream("luciana@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        } 
        System.out.println("************************************************************");
        System.out.println("************************************************************");

        //retorna um cliente
        cli = clienteRepository.findOne(3L);
        System.out.println("Localiza o cliente de código 3 : " + cli);
        
        System.out.println("************************************************************");
        System.out.println("************************************************************");
        
        System.out.println("Pronto-Fim");

        exit(0);
		
	}

}
