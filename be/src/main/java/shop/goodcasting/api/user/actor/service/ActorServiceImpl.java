package shop.goodcasting.api.user.actor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import shop.goodcasting.api.user.actor.domain.Actor;
import shop.goodcasting.api.user.actor.domain.ActorDTO;
import shop.goodcasting.api.user.actor.repository.ActorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository repo;

    @Override
    public List<Actor> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Actor> findById(Long actorId) {
        return repo.findById(actorId);
    }

    @Transactional
    @Override
    public Long delete(ActorDTO actorDTO) {
        Actor actor = dto2Entity(actorDTO);

        repo.update(actor.getUser().getUserId(), false);
        repo.delete(actor);

        return repo.findById(actor.getActorId()).orElse(null) == null ? 1L : 0L;
    }

    @Override
    public ActorDTO moreDetail(ActorDTO actorDTO) {
        repo.findById(actorDTO.getActorId());
        Actor actor = dto2Entity(actorDTO);
        repo.save(actor);
        return null;
    }
}


