package br.com.argus.eorzea_database.controller;

import br.com.argus.eorzea_database.model.Action;
import br.com.argus.eorzea_database.service.ActionService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public List<Action> getAllActions() {
        return actionService.findAllActions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Action> getActionById(@PathVariable String id) {
        return actionService.findActionById(new ObjectId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/job/{jobId}")
    public List<Action> getActionsByJob(@PathVariable String jobId) {
        return actionService.findActionsByJobId(new ObjectId(jobId));
    }

    @GetMapping("/type/{type}")
    public List<Action> getActionsByType(@PathVariable Action.ActionType type) {
        return actionService.findActionsByType(type);
    }

    @GetMapping("/level")
    public List<Action> getActionsByLevelRange(
            @RequestParam int min,
            @RequestParam int max) {
        return actionService.findActionsByLevelRange(min, max);
    }

    @GetMapping("/cast-time")
    public List<Action> getActionsByCastTimeRange(
            @RequestParam float min,
            @RequestParam float max) {
        return actionService.findActionsByCastTimeRange(min, max);
    }

    @GetMapping("/recast-time")
    public List<Action> getActionsByRecastTimeRange(
            @RequestParam float min,
            @RequestParam float max) {
        return actionService.findActionsByRecastTimeRange(min, max);
    }

    @PostMapping
    public Action createAction(@RequestBody @Valid Action action) {
        return actionService.saveAction(action);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Action> updateAction(
            @PathVariable String id,
            @RequestBody @Valid Action action) {
        action.setId(new ObjectId(id));
        return ResponseEntity.ok(actionService.saveAction(action));
    }

    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable String id) {
        actionService.deleteAction(new ObjectId(id));
    }
}