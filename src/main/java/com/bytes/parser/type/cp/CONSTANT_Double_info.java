package com.bytes.parser.type.cp;

import com.bytes.parser.type.U1;

public class CONSTANT_Double_info extends CONSTANT_Long_info {

    public CONSTANT_Double_info(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Double_info";
    }
}
