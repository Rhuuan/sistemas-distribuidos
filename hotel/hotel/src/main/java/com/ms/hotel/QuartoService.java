package com.ms.hotel;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuartoService {
    private Map<Long, Quarto> quartos;

    public QuartoService() {
        this.quartos = new HashMap<>();
        // Adicione quartos de exemplo conforme necessário
        addQuarto(new Quarto(101L, "Single", 2, true));
        addQuarto(new Quarto(102L, "Double", 3, true));
        addQuarto(new Quarto(201L, "Single", 1, true));
        addQuarto(new Quarto(202L, "Double", 2, false)); // Quarto indisponível
    }

    public void addQuarto(Quarto quarto) {
        quartos.put(quarto.getId(), quarto);
    }

    public Quarto getQuartoById(Long id) {
        return quartos.get(id);
    }

    // Outros métodos de serviço para manipular quartos conforme necessário
}
