package com.joilson.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjasRepository ninjasRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjasRepository ninjasRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjasRepository = ninjasRepository;
    }

    public List<NinjaModel> getNinjas() {
        return ninjasRepository.findAll();
    }

    public NinjaModel getNinjaById(Long id) {
        Optional<NinjaModel> ninja = ninjasRepository.findById(id);

        return ninja.orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjasRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deleteNinja(Long id) {
        ninjasRepository.deleteById(id);
    }

    public NinjaModel updateNinja(Long id, NinjaModel ninjaModel) {
        if (ninjasRepository.existsById(id)) {
            ninjaModel.setId(id);

            return ninjasRepository.save(ninjaModel);
        }

        return null;
    }
}
