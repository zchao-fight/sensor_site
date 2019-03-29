package cn.ccf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {
   /* @Autowired
    private LogService logService;

    @RequestMapping(value = "/Com_Log",method = RequestMethod.GET)
    public ResponseEntity<List<Log>> listAllLog() {
        List<Log> list = logService.findAllLog();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/Com_Log/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Log> getLog(@PathVariable("id") int id) {
        System.out.println("Fetching Log with id" + id);
        Log log = logService.findById(id);
        if (log == null) {
            System.out.println();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    @RequestMapping(value = "/Com_Log", method = RequestMethod.POST)
    public ResponseEntity<Void> createLog(@RequestBody Log log, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Log:");

        if (logService.isLogExist(log)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        logService.saveLog(log);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ucBuilder.path("/api/Com_Log/{id}").buildAndExpand(log.getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Com_Log/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Log> updateLog(@PathVariable("id") int id, @RequestBody Log log) {
        System.out.println("Updating Log:"+id);
        Log currentLog = logService.findById(id);
        if (currentLog == null) {
            System.out.println("Log with id"+id+"not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logService.updateLog(log);

        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    @RequestMapping(value = "/Com_Log/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Log> deleteLog(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Log with id"+id);
        Log log = logService.findById(id);

        if (log == null) {
            System.out.println("Unable to delete Log with id" + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logService.deleteLogById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
