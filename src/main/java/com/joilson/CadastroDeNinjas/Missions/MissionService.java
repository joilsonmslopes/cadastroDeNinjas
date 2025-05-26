package com.joilson.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {
    private MissionRepository missionRepository;
    private MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public List<MissionDTO> getAllMissions() {
        List<MissionModel> missions = missionRepository.findAll();

        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionDTO listMissionById(long id) {
        Optional<MissionModel> missionFound = missionRepository.findById(id);

        return missionFound.map(missionMapper::map).orElse(null);
    }

    public MissionDTO createMission(MissionDTO missionDTO) {
        MissionModel missionModel = missionMapper.map(missionDTO);
        missionModel = missionRepository.save(missionModel);
        return missionMapper.map(missionModel);
    }

    public MissionDTO updateMission(long id, MissionDTO missionDTO) {
        boolean hasMission = missionRepository.existsById(id);

        if (hasMission) {
            MissionModel missionModel = missionMapper.map(missionDTO);
            missionModel.setId(id);
            missionModel = missionRepository.save(missionModel);

            return missionMapper.map(missionModel);
        }

        return null;
    }

    public void deleteMissionByid(long id) {
        missionRepository.deleteById(id);
    }
}
