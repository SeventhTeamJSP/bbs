package com.nediiii.ncu.bbs.controller;

import com.nediiii.ncu.bbs.entity.BlockEntity;
import com.nediiii.ncu.bbs.service.implement.BlockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BlockController {

    @Autowired
    private BlockServiceImpl blockService;

    @PostMapping("/blocks")
    public Object addBlock(@RequestBody List<BlockEntity> blockList) {
        blockList = blockService.insertBlocks(blockList);
        return blockList;
    }

    @DeleteMapping("/blocks")
    public Object deleteBlock(@RequestBody List<Integer> ids) {
        return blockService.deleteBlocks(ids);
    }

    @DeleteMapping("/blocks/all")
    public Object deleteBlock() {
        return blockService.deleteBlocks();
    }

    @PutMapping("/blocks")
    public Object updateBlock(@RequestBody List<BlockEntity> blockList) {
        blockList = blockService.updateBlocks(blockList);
        return blockList;
    }

    @GetMapping("/blocks/{id}")
    public Object getBlockById(@PathVariable int id) {
        BlockEntity block = blockService.selectBlock(id);
        return new ResponseEntity<>(
                block,
                block == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/blocks")
    public Object getBlocks() {
        return blockService.selectBlocks();
    }
}
