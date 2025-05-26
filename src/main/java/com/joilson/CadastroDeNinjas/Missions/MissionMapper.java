package com.joilson.CadastroDeNinjas.Missions;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public MissionModel map(MissionDTO missionDTO) {
        MissionModel missionModel = new MissionModel();

        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setLevel(missionDTO.getLevel());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }

    public MissionDTO map(MissionModel missionModel) {
        MissionDTO missionDTO = new MissionDTO();

        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setLevel(missionModel.getLevel());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }
}
