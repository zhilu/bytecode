package com.bytes.parser.type.cp;

import com.bytes.parser.type.CpInfo;
import com.bytes.parser.type.U1;
import com.bytes.parser.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_String_info extends CpInfo {

    private U2 string_index;

    public CONSTANT_String_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        string_index = new U2(codeBuf.get(), codeBuf.get());
    }
    @Override
    public String toString() {
        return "CONSTANT_String_info";
    }
}
