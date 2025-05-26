package com.joilson.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private final NinjasRepository ninjasRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaMapper ninjaMapper, NinjasRepository ninjasRepository) {
        this.ninjaMapper = ninjaMapper;
        this.ninjasRepository = ninjasRepository;
    }

    public List<NinjaDTO> getNinjas() {
        List<NinjaModel> ninjas = ninjasRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninja = ninjasRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjasRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deleteNinja(Long id) {
        ninjasRepository.deleteById(id);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaFound = ninjasRepository.findById(id);

        if(ninjaFound.isPresent()) {
            NinjaModel updatedNinja = ninjaMapper.map(ninjaDTO);
            updatedNinja.setId(id);
            updatedNinja = ninjasRepository.save(updatedNinja);

            return ninjaMapper.map(updatedNinja);
        }

        return null;
    }
}
