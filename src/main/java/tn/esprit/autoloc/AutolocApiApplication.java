package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {
            if (vehiculeRepository.count() == 0) {
                vehiculeRepository.save(new Vehicule(null, "123-TUN-456", "Renault", "Clio", CategorieVehicule.CITADINE, new BigDecimal("80.00"), StatutVehicule.DISPONIBLE));
                vehiculeRepository.save(new Vehicule(null, "789-TUN-101", "Peugeot", "3008", CategorieVehicule.SUV, new BigDecimal("150.00"), StatutVehicule.DISPONIBLE));
                vehiculeRepository.save(new Vehicule(null, "202-TUN-303", "Volkswagen", "Passat", CategorieVehicule.BERLINE, new BigDecimal("180.00"), StatutVehicule.LOUE));
                System.out.println(">>> Données de démonstration pour Vehicule insérées avec succès !");
            }
        };
    }
}
