package com.bytes.parser.handler;

import com.bytes.parser.type.ClassFile;
import com.bytes.parser.type.U2;

import java.nio.ByteBuffer;

public class AccessFlagsHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setAccess_flags(new U2(codeBuf.get(), codeBuf.get()));
    }

}
