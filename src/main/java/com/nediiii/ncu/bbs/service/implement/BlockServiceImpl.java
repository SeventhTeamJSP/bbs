package com.nediiii.ncu.bbs.service.implement;

import com.nediiii.ncu.bbs.entity.BlockEntity;
import com.nediiii.ncu.bbs.repository.BlockRepository;
import com.nediiii.ncu.bbs.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImpl implements BlockService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public List<BlockEntity> insertBlocks(List<BlockEntity> blockList) {
        for (BlockEntity block : blockList) {
            block.setId(0);
        }
        return blockRepository.saveAll(blockList);
    }

    @Override
    public boolean deleteBlocks(List<Integer> ids) {
        for (int id : ids) {
            logger.info("删除了id为: " + id + " 的记录");
            blockRepository.deleteById(id);
        }
        return true;
    }

    @Override
    public boolean deleteBlocks() {
        blockRepository.deleteAll();
        return true;
    }

    @Override
    public List<BlockEntity> updateBlocks(List<BlockEntity> blockList) {
        return blockRepository.saveAll(blockList);
    }

    @Override
    public BlockEntity selectBlock(int id) {
        BlockEntity block = null;
        try {
            Optional<BlockEntity> optional = blockRepository.findById(id);
            block = optional.get();
        } catch (Exception ex) {
            logger.warn("程序遇到被手动忽略的异常");
            return null;
        }
        return block;
    }

    @Override
    public List<BlockEntity> selectBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public Iterator<BlockEntity> selectBlocks(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        Page<BlockEntity> blocks = blockRepository.findAll(pageable);
        Iterator<BlockEntity> blockIterator = blocks.iterator();
        return blockIterator;
    }
}
