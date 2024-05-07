package com.ms.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private QuartoService quartoService;

    private List<Hotel> hotels;

    public HotelService() {
        // Inicializa a lista de hotéis com alguns dados de exemplo
        this.hotels = new ArrayList<>();
        // Adicionando hotéis de exemplo
        Hotel hotelA = new Hotel(1L, "Hotel A", "Location A");
        hotelA.addQuarto(101L); // Adiciona o quarto com ID 101 ao Hotel A
        hotelA.addQuarto(102L); // Adiciona o quarto com ID 102 ao Hotel A
        this.hotels.add(hotelA);

        Hotel hotelB = new Hotel(2L, "Hotel B", "Location B");
        hotelB.addQuarto(201L); // Adiciona o quarto com ID 201 ao Hotel B
        hotelB.addQuarto(202L); // Adiciona o quarto com ID 202 ao Hotel B
        this.hotels.add(hotelB);
    }

    public List<Hotel> searchHotels(String date, String location) {
        // Implementa a lógica para buscar hotéis disponíveis na data e localização especificadas
        List<Hotel> availableHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            boolean disponibilidade = false;
            for (Long quartoId : hotel.getQuartosIds()) {
                Quarto quarto = quartoService.getQuartoById(quartoId);
                if (quarto != null && quarto.isDisponivel()) {
                    // Implementa lógica para verificar a disponibilidade do quarto na data específica
                    // Aqui você deve adicionar sua lógica de verificação de disponibilidade na data
                    disponibilidade = true;
                    break;
                }
            }
            if (disponibilidade) {
                availableHotels.add(hotel);
            }
        }
        return availableHotels;
    }
}
