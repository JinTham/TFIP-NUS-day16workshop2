package tfip.ssf.day16workshop2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfip.ssf.day16workshop2.Model.Boardgame;
import tfip.ssf.day16workshop2.Repository.BoardgameRepo;

@RestController
@RequestMapping(path="/api/boardgame")
public class BoardgameController {
    @Autowired
    private BoardgameRepo boardgameRepo;
    
    @PostMapping
    public ResponseEntity<Boardgame> save(@RequestBody Boardgame boardgame) {
        boardgameRepo.save(boardgame);
        return new ResponseEntity<Boardgame>(boardgame,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findById(@PathVariable Integer id) {
        Boardgame boardgame = boardgameRepo.findBoardgameById(id);
        if (null == boardgame){
            return new ResponseEntity<Boardgame>(boardgame, HttpStatus.valueOf(404));
        }
        return new ResponseEntity<Boardgame>(boardgameRepo.findBoardgameById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Boardgame>> findAll() {
        return new ResponseEntity<List<Boardgame>>(boardgameRepo.findAllBoardgame(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boardgame> update(@RequestBody Boardgame boardgame) {
        boardgameRepo.update(boardgame);
        return new ResponseEntity<Boardgame>(boardgame, HttpStatus.OK);
    }
}
