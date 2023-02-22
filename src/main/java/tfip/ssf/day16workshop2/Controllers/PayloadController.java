package tfip.ssf.day16workshop2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfip.ssf.day16workshop2.Model.Payload;
import tfip.ssf.day16workshop2.Repository.PayloadRepo;

@RestController
@RequestMapping(path="/api/payloads")
public class PayloadController {
    @Autowired
    PayloadRepo payloadRepo;

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload) {
        payloadRepo.save(payload);
        return new ResponseEntity<Payload>(payload,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payload>> findAll() {
        return new ResponseEntity<List<Payload>>(payloadRepo.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findById(@PathVariable Integer id) {
        return new ResponseEntity<Payload>(payloadRepo.findPayloadById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        return new ResponseEntity<String>(payloadRepo.deletePayloadById(id),HttpStatus.OK);
    }
}
