package com.joilson.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjasRepository ninjasRepository;

    public NinjaService(NinjasRepository ninjasRepository) {
        this.ninjasRepository = ninjasRepository;
    }

    public List<NinjaModel> getNinjas() {
        return ninjasRepository.findAll();
    }

    public NinjaModel getNinjaById(Long id) {
        Optional<NinjaModel> ninja = ninjasRepository.findById(id);

        return ninja.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjasRepository.save(ninja);
    }

    public void deleteNinja(Long id) {
        ninjasRepository.deleteById(id);
    }
}
