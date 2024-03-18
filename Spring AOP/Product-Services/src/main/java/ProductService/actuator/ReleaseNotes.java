package ProductService.actuator;

import ProductService.model.ReleaseNote;
import ProductService.repository.ReleaseNotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RestControllerEndpoint(id="releasenotes")
public class ReleaseNotes {

    @Autowired
    ReleaseNotesRepo releasenotesrepo;
    @GetMapping
    public List<ReleaseNote> getAllReleaseNotes()
    {
        return releasenotesrepo.findAll();

    }
    @PostMapping
    public ReleaseNote addReleaseNotes( @RequestBody ReleaseNote releasenote)
    {
        ReleaseNote releaseNote =new ReleaseNote(releasenote.getVersion(), LocalDateTime.now(),releasenote.getChangeLogData());
        return releasenotesrepo.save(releaseNote);
    }
    @DeleteMapping("{id}")
    public void deleteReleaseNote(@Selector Integer id) {

        releasenotesrepo.delete(releasenotesrepo.findById(id).get());
    }
}
