package ProductService.repository;

import ProductService.model.ReleaseNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseNotesRepo extends JpaRepository<ReleaseNote, Integer> {
    void deleteReleaseNoteByVersion(String version);
}
