package com.bytes.parser.handler;


import com.bytes.parser.type.ClassFile;
import com.bytes.parser.type.U2;

import java.nio.ByteBuffer;

public class VersionHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 1;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 minorVersion = new U2(codeBuf.get(), codeBuf.get());
        classFile.setMinor_version(minorVersion);
        U2 majorVersion = new U2(codeBuf.get(), codeBuf.get());
        classFile.setMagor_version(majorVersion);
    }

}
