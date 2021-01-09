package com.bytes.parser.type.cp;

import com.bytes.parser.type.CpInfo;
import com.bytes.parser.type.U1;
import com.bytes.parser.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;


@Getter
public class CONSTANT_InvokeDynamic_info extends CpInfo {

    private U2 bootstrap_method_attr_index;
    private U2 name_and_type_index;

    public CONSTANT_InvokeDynamic_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bootstrap_method_attr_index = new U2(codeBuf.get(), codeBuf.get());
        name_and_type_index = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_InvokeDynamic_info";
    }
}
