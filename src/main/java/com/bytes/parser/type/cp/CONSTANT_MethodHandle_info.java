package com.bytes.parser.type.cp;

import com.bytes.parser.type.CpInfo;
import com.bytes.parser.type.U1;
import com.bytes.parser.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class CONSTANT_MethodHandle_info extends CpInfo {

    private U1 reference_kind;
    private U2 reference_index;

    public CONSTANT_MethodHandle_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        reference_kind = new U1(codeBuf.get());
        reference_index = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info";
    }
}
