package com.bytes.parser.type.cp;

import com.bytes.parser.type.U1;

public class CONSTANT_Float_info extends CONSTANT_Integer_info {

    public CONSTANT_Float_info(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Float_info";
    }

}
