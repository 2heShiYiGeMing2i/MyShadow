package tools;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;

/**
 * Created by zhaolei on 2018/4/7
 */
public enum CodeType {
    None(0),EncodeType(1),DecodeType(2);
    private int value;


    @JsonValue
    public int getValue() {
        return value;
    }

    CodeType(int value) {
        this.value = value;
    }


    // json 转换的时候
    @JsonCreator
    private static CodeType fromValue(String value){
        return fromValue(Integer.parseInt(value));
    }


    @Nonnull
    private static CodeType fromValue(int i) {
        for (CodeType type:CodeType.values()) {
            if (type.value == i)
                return type;
        }
        return None;
    }


}
