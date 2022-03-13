package iwon.iwonbackend.service;

import iwon.iwonbackend.dao.FacilityRepository;
import iwon.iwonbackend.model.Facility;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {

    private final FacilityRepository repository;

    public FacilityService(FacilityRepository repository) {
        this.repository = repository;
    }

    public List<Facility> findAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Facility> findById(Long id) {
        return this.repository.findById(id);
    }

    public List<Facility> addFacilities(List<Facility> facilities) {
        return this.repository.saveAll(facilities);
    }

    public Facility updateFacility(Facility facility) {
        return this.repository.save(facility);
    }

    public void removeFacility(Long id) {
        this.repository.deleteById(id);
    }
}
