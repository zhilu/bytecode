package com.bytes.parser.handler;

import com.bytes.parser.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {

    /**
     * 排序
     *
     * @return
     */
    int order();

    /**
     * 读取
     *
     * @param codeBuf
     * @param classFile
     */
    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;

}
