package com.example.myservice;

import com.example.myservice.entities.Attraction;
import com.example.myservice.entities.City;
import com.example.myservice.entities.Destination;
import com.example.myservice.entities.Expense;
import com.example.myservice.repositories.AttractionRepository;
import com.example.myservice.repositories.CityRepository;
import com.example.myservice.repositories.DestinationRepository;
import com.example.myservice.repositories.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataSeeder implements CommandLineRunner {

    private static final String TRANSPORT = "Transport";
    private static final String HEBERGEMENT = "Hébergement";
    private static final String RESTAURATION = "Restauration";
    private static final String ACTIVITES = "Activités";
    private static final String SHOPPING = "Shopping";
    private static final String DIVERS = "Divers";

    private final DestinationRepository destinations;
    private final CityRepository cities;
    private final AttractionRepository attractions;
    private final ExpenseRepository expenses;

    private static final String A_VENIR = "À venir";
    private static final String TERMINE = "Terminé";
    private static final String EN_COURS = "En cours";

    public DataSeeder(DestinationRepository destinations, CityRepository cities,
                      AttractionRepository attractions, ExpenseRepository expenses) {
        this.destinations = destinations;
        this.cities = cities;
        this.attractions = attractions;
        this.expenses = expenses;
    }

    @Override
    public void run(String... args) {
        if (destinations.count() > 0) {
            return;
        }


        int japon = dest("Japon", TERMINE);
        int tokyo = city("Tokyo", japon);
        attr("Temple Sensō-ji", "Le plus ancien temple de Tokyo, dans le quartier animé d'Asakusa.", tokyo);
        attr("Carrefour de Shibuya", "La traversée piétonne la plus célèbre du monde.", tokyo);
        attr("teamLab Planets", "Musée d'art numérique immersif, pieds dans l'eau.", tokyo);
        exp(1240, TRANSPORT, "Vols A/R Paris–Tokyo", japon);
        exp(980, HEBERGEMENT, "Hôtel Shinjuku · 7 nuits", japon);
        exp(280, TRANSPORT, "Japan Rail Pass", japon);
        exp(95, RESTAURATION, "Sushi au marché de Toyosu", japon);
        exp(70, ACTIVITES, "Billets teamLab Planets", japon);
        exp(150, SHOPPING, "Souvenirs & papeterie", japon);
        exp(30, DIVERS, "Carte SIM data", japon);


        int coree = dest("Corée du Sud", TERMINE);
        int seoul = city("Séoul", coree);
        attr("Palais Gyeongbokgung", "Le grand palais royal de la dynastie Joseon.", seoul);
        attr("Village Bukchon Hanok", "Ruelles de maisons traditionnelles coréennes.", seoul);
        attr("Tour N de Séoul", "Panorama sur la ville depuis le mont Namsan.", seoul);
        exp(760, TRANSPORT, "Vols A/R Séoul", coree);
        exp(620, HEBERGEMENT, "Hôtel Myeongdong · 5 nuits", coree);
        exp(78, RESTAURATION, "BBQ coréen & street food", coree);
        exp(12, ACTIVITES, "Palais Gyeongbokgung", coree);
        exp(35, TRANSPORT, "Carte T-money", coree);
        exp(130, SHOPPING, "Cosmétiques K-beauty", coree);


        int usa = dest("États-Unis", A_VENIR);
        int ny = city("New York", usa);
        attr("Statue de la Liberté", "L'icône new-yorkaise sur Liberty Island.", ny);
        attr("Central Park", "Le poumon vert au cœur de Manhattan.", ny);
        attr("Times Square", "Le carrefour électrique aux écrans géants.", ny);
        exp(690, TRANSPORT, "Vols A/R New York", usa);
        exp(1450, HEBERGEMENT, "Hôtel Manhattan · 5 nuits", usa);
        exp(240, RESTAURATION, "Brunchs & diners", usa);
        exp(75, ACTIVITES, "Empire State Building", usa);
        exp(160, ACTIVITES, "Comédie musicale Broadway", usa);
        exp(33, TRANSPORT, "MetroCard", usa);
        exp(320, SHOPPING, "Shopping SoHo", usa);


        int malaisie = dest("Malaisie", A_VENIR);
        int kl = city("Kuala Lumpur", malaisie);
        int langkawi = city("Langkawi", malaisie);
        attr("Tours Petronas", "Les tours jumelles emblématiques de KL.", kl);
        attr("Grottes de Batu", "Sanctuaire hindou au sommet de 272 marches.", kl);
        attr("Chinatown – Petaling", "Marché de rue animé et street food.", kl);
        attr("Sky Bridge", "Passerelle suspendue avec vue sur la jungle.", langkawi);
        attr("Plage de Cenang", "Sable blanc et couchers de soleil.", langkawi);
        exp(850, TRANSPORT, "Vols A/R Kuala Lumpur", malaisie);
        exp(360, HEBERGEMENT, "Hôtel KLCC · 4 nuits", malaisie);
        exp(90, TRANSPORT, "Vol interne KL → Langkawi", malaisie);
        exp(420, HEBERGEMENT, "Resort Langkawi · 3 nuits", malaisie);
        exp(45, RESTAURATION, "Street food Jalan Alor", malaisie);
        exp(25, ACTIVITES, "Sky Bridge Langkawi", malaisie);


        int thai = dest("Thaïlande", A_VENIR);
        int bangkok = city("Bangkok", thai);
        int phuket = city("Phuket", thai);
        attr("Grand Palais", "Ancienne résidence royale et Wat Phra Kaew.", bangkok);
        attr("Wat Arun", "Le temple de l'Aube au bord du fleuve.", bangkok);
        attr("Marché de Chatuchak", "L'un des plus grands marchés du monde.", bangkok);
        attr("Plage de Patong", "La plage la plus animée de Phuket.", phuket);
        attr("Grand Bouddha", "Statue de 45 m dominant l'île.", phuket);
        exp(720, TRANSPORT, "Vols A/R Bangkok", thai);
        exp(240, HEBERGEMENT, "Hôtel Bangkok · 4 nuits", thai);
        exp(480, HEBERGEMENT, "Resort Phuket · 5 nuits", thai);
        exp(65, TRANSPORT, "Vol Bangkok → Phuket", thai);
        exp(60, RESTAURATION, "Pad thaï & street food", thai);
        exp(14, ACTIVITES, "Grand Palais", thai);
        exp(95, ACTIVITES, "Excursion îles Phi Phi", thai);
        exp(40, DIVERS, "Massage thaï", thai);


        int espagne = dest("Espagne", TERMINE);
        int barcelone = city("Barcelone", espagne);
        attr("Sagrada Família", "La basilique inachevée de Gaudí.", barcelone);
        attr("Parc Güell", "Mosaïques colorées signées Gaudí.", barcelone);
        attr("Las Ramblas", "L'avenue piétonne emblématique.", barcelone);
        exp(160, TRANSPORT, "Vols A/R Barcelone", espagne);
        exp(480, HEBERGEMENT, "Hôtel Eixample · 4 nuits", espagne);
        exp(52, ACTIVITES, "Billets Sagrada Família", espagne);


        int mali = dest("Mali", EN_COURS);
        int bamako = city("Bamako", mali);
        attr("Marché de Bamako", "Couleurs, tissus et artisanat malien.", bamako);
        attr("Musée National du Mali", "Art et histoire du pays.", bamako);
        exp(680, TRANSPORT, "Vols A/R Bamako", mali);
        exp(350, HEBERGEMENT, "Hôtel Bamako · 5 nuits", mali);


        int uk = dest("Royaume-Uni", TERMINE);
        int londres = city("Londres", uk);
        attr("British Museum", "Collections du monde entier, entrée libre.", londres);
        attr("Tower Bridge", "Le pont basculant victorien sur la Tamise.", londres);
        attr("London Eye", "La grande roue avec vue sur Westminster.", londres);
        exp(180, TRANSPORT, "Eurostar A/R Londres", uk);
        exp(540, HEBERGEMENT, "Hôtel Soho · 3 nuits", uk);
        exp(95, RESTAURATION, "Fish & chips + pubs", uk);
        exp(38, ACTIVITES, "London Eye", uk);
        exp(40, TRANSPORT, "Oyster card", uk);
        exp(180, SHOPPING, "Shopping Oxford Street", uk);
    }

    private int dest(String pays, String statut) {
        Destination d = new Destination();
        d.setPays(pays);
        d.setStatut(statut);
        return destinations.save(d).getId();
    }

    private int city(String nom, int destinationId) {
        City c = new City();
        c.setNom(nom);
        c.setDestinationId(destinationId);
        return cities.save(c).getId();
    }

    private void attr(String nom, String description, int cityId) {
        Attraction a = new Attraction();
        a.setNom(nom);
        a.setDescription(description);
        a.setCityId(cityId);
        attractions.save(a);
    }

    private void exp(double montant, String categorie, String description, int destinationId) {
        Expense e = new Expense();
        e.setMontant(montant);
        e.setCategorie(categorie);
        e.setDescription(description);
        e.setDestinationId(destinationId);
        expenses.save(e);
    }
}