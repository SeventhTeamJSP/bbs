package com.nediiii.ncu.bbs.service;

import com.nediiii.ncu.bbs.entity.BlockEntity;

import java.util.Iterator;
import java.util.List;

public interface BlockService {

    //    增
    public List<BlockEntity> insertBlocks(List<BlockEntity> blockList);

    //    删
    public boolean deleteBlocks(List<Integer> ids);

    public boolean deleteBlocks();

    //    改
    public List<BlockEntity> updateBlocks(List<BlockEntity> blockList);

    //    查
    public BlockEntity selectBlock(int id);

    public List<BlockEntity> selectBlocks();

    public Iterator<BlockEntity> selectBlocks(int pageNum, int pageSize);

}
