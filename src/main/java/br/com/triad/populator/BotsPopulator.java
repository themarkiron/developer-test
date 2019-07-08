package br.com.triad.populator;

import br.com.triad.dto.BotsDTO;
import br.com.triad.model.BotsModel;
import org.springframework.stereotype.Service;

@Service
public class BotsPopulator {


    public void populate(BotsDTO source, BotsModel target)
    {
        source.setId(target.getId());
        source.setName(target.getName());
    }
}
