package com.bytes.parser.handler;

import com.bytes.parser.type.ClassFile;
import com.bytes.parser.type.U4;

import java.nio.ByteBuffer;


public class MagicHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMagic(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));
        if (!"0xCAFEBABE".equalsIgnoreCase(classFile.getMagic().toHexString())) {
            throw new Exception("这不是一个Class文件");
        }
    }

}
