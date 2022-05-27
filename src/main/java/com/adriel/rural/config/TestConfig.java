package com.adriel.rural.config;

import java.time.Instant;
import java.util.Arrays;

import com.adriel.rural.models.Acompanhamento;
import com.adriel.rural.models.Animal;
import com.adriel.rural.models.Especie;
import com.adriel.rural.models.Fazenda;
import com.adriel.rural.models.Funcionario;
import com.adriel.rural.models.Proprietario;
import com.adriel.rural.models.Raca;
import com.adriel.rural.models.Usuario;
import com.adriel.rural.repositories.AcompanhamentoRepository;
import com.adriel.rural.repositories.AnimalRepository;
import com.adriel.rural.repositories.EspecieRepository;
import com.adriel.rural.repositories.FazendaRepository;
import com.adriel.rural.repositories.FuncionarioRepository;
import com.adriel.rural.repositories.ProprietarioRepository;
import com.adriel.rural.repositories.RacaRepository;
import com.adriel.rural.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	UsuarioRepository usuarioRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    RacaRepository racaRepository;

    @Autowired
    EspecieRepository especieRepository;

    @Autowired
    AcompanhamentoRepository acompanhamentoRepository;

    @Autowired
    FazendaRepository fazendaRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    ProprietarioRepository proprietarioRepository;
    
    @Autowired
    PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

    	Usuario usuario = new Usuario(null, "adriel", encoder.encode("@1234"), Instant.now(), null);
    	
    	usuarioRepository.save(usuario);
    			
        Proprietario proprietario = new Proprietario(null, "José", "Adriano", Instant.now());

        proprietarioRepository.save(proprietario);
        
        Usuario usuario2 = new Usuario(null, "adriano", encoder.encode("123"), Instant.now(), proprietario);
        
        usuarioRepository.save(usuario2);

        Fazenda fazenda = new Fazenda(null, "Granja Dois Irmãos", "Rua Exemplo, 1982", "Cajá", "Paraíba", proprietario);

        fazendaRepository.save(fazenda);

        Funcionario funcionario1 = new Funcionario(null, "Adriel", "Felix", Instant.now(), "Gerente Administrativo", 1750.00, fazenda);
        Funcionario funcionario2 = new Funcionario(null, "Pedro", "Sei lá", Instant.now(), "Serviços Gerais", 1100.00, fazenda);

        funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2));

        Especie especie1 = new Especie(null, "Equino");
        Especie especie2 = new Especie(null, "Bovino");

        especieRepository.saveAll(Arrays.asList(especie1, especie2));

        Raca raca1 = new Raca(null, "Paint Horse", especie1);
        Raca raca2 = new Raca(null, "Quarto de milha", especie1);

        racaRepository.saveAll(Arrays.asList(raca1, raca2));

        Animal animal1 = new Animal(null, "Aurora", "F", Instant.now(), Instant.now(), 2500.00, null, null, raca2, fazenda);
        Animal animal2 = new Animal(null, "Katrina", "F", null, null, 2500.00, null, null, raca1, fazenda);
        Animal animal3 = new Animal(null, "Java", "F", null, null, 2500.00, null, null, raca1, fazenda);

        animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3));

        Acompanhamento acompanhamento1 = new Acompanhamento(null, Instant.now(), 1.50, 400.00, true, animal1);

        acompanhamentoRepository.save(acompanhamento1);

    }

}
