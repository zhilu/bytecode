package com.bytes.parser.attribute;

import com.bytes.parser.type.U2;
import com.bytes.parser.type.U4;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValue_attribute {

    private U2 attribute_name_index;
    private U4 attribute_length;
    private U2 constantvalue_index;

}
